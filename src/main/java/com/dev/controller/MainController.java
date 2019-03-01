package com.dev.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import com.dev.model.*;
import com.dev.service.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping(value="/")
public class MainController {



    @Autowired
    private FileService fileService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private OpeningBalanceService openingBalanceService;

    @Autowired
    private TurnoverService turnoverService;

    @Autowired
    private ClosingBalanceService closingBalanceService;

// парсинг .xls файла и запись в БД
    @RequestMapping(value="/parse", method=RequestMethod.POST)
    public ModelAndView parse(@ModelAttribute("file") MultipartFile file) {
        File file2 = new File();

        file2.setFileName(file.getOriginalFilename());
        fileService.insert(file2);
        System.out.println(file2.getId());

   ModelAndView modelAndView = new ModelAndView("redirect:/list");

        String result = "";
        InputStream inputStream = null;
        HSSFWorkbook workBook = null;
        try {
            inputStream = file.getInputStream();
            workBook = new HSSFWorkbook(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Sheet sheet = workBook.getSheetAt(0);
        Iterator<Row> it = sheet.iterator();
        label: while (it.hasNext()) {

            Account account = new Account();
            OpeningBalance openingBalance = new OpeningBalance();
            Turnover turnover = new Turnover();
            ClosingBalance closingBalance = new ClosingBalance();

            Row row = it.next();
            if(row.getRowNum() < 9)
                continue;
            Iterator<Cell> cells = row.iterator();
            Cell cell =  cells.next();
            int cellType = cell.getCellType();
                switch (cellType) {
                    case Cell.CELL_TYPE_STRING:
                        if (cell.getStringCellValue().contains("КЛАСС") || cell.getStringCellValue().contains("БАЛАНС"))
                            continue label;
                        account.setNumber(Integer.parseInt(cell.getStringCellValue()));
                        break;
                    case Cell.CELL_TYPE_NUMERIC:
                        account.setNumber((int)cell.getNumericCellValue());
                        break;
                }
            account.setIdFile(file2.getId());
            accountService.insert(account);
            cell = cells.next();
            openingBalance.setIdAccount(account.getId());
            openingBalance.setAsset(cell.getNumericCellValue());
            cell = cells.next();
            openingBalance.setLability(cell.getNumericCellValue());
            openingBalanceService.insert(openingBalance);
            cell = cells.next();
            turnover.setIdAccount(account.getId());
            turnover.setDebit(cell.getNumericCellValue());
            cell = cells.next();
            turnover.setLoan(cell.getNumericCellValue());
            turnoverService.insert(turnover);
            cell = cells.next();
            closingBalance.setIdAccount(account.getId());
            closingBalance.setAsset(cell.getNumericCellValue());
            cell = cells.next();
            closingBalance.setLiability(cell.getNumericCellValue());
            closingBalanceService.insert(closingBalance);
        }


        return modelAndView;
    }
// возвращение списка всех файлов
    @RequestMapping(value="/list")
    public ModelAndView listOfFiles() {
        ModelAndView modelAndView = new ModelAndView("index");

        List<File> files= fileService.getAll();
        modelAndView.addObject("files", files);

        return modelAndView;
    }

// возврат данных из БД на JSP
    @RequestMapping(value="/show/{id}", method=RequestMethod.GET)
    public ModelAndView showFile(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("showFile");
        List<Account> accounts = accountService.getAccountsByIdFile(id);

        int maxValue = accounts.get(0).getId();
        int minValue = accounts.get(0).getId();
        for(Account account : accounts){
            if (maxValue < account.getId()) maxValue = account.getId();
            if (minValue > account.getId()) minValue = account.getId();
        }
        List<OpeningBalance> openingBalances = openingBalanceService.getOpeningBalancesBetweenIdAccount(minValue,maxValue);
        List<Turnover> turnovers = turnoverService.getTurnoversBetweenIdAccount(minValue,maxValue);
        List<ClosingBalance> closingBalances = closingBalanceService.getClosingBalancesBetweenIdAccount(minValue,maxValue);
        List<Object> list = new ArrayList<>();

        for (int i = 0; i<accounts.size();i++){
            list.add(accounts.get(i).getNumber());
            list.add(openingBalances.get(i).getAsset());
            list.add(openingBalances.get(i).getLability());
            list.add(turnovers.get(i).getDebit());
            list.add(turnovers.get(i).getLoan());
            list.add(closingBalances.get(i).getAsset());
            list.add(closingBalances.get(i).getLiability());
        }
        modelAndView.addObject("list",list);
        return modelAndView;
    }

}
