package com.dev.service.impl;

import com.dev.dao.OpeningBalanceDAO;
import com.dev.model.OpeningBalance;
import com.dev.service.OpeningBalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OpeningBalanceServiceImpl implements OpeningBalanceService {

    @Autowired
    private OpeningBalanceDAO openingBalanceDAO;

    public void insert(OpeningBalance openingBalance) {
        openingBalanceDAO.addOpeningBalance(openingBalance);
    }

    public void update(OpeningBalance openingBalance) {
        openingBalanceDAO.updateOpeningBalance(openingBalance);
    }

    public OpeningBalance getById(int id) {
        return openingBalanceDAO.getOpeningBalance(id);
    }

    public void delete(int id) {
        openingBalanceDAO.deleteOpeningBalance(id);
    }

    public List<OpeningBalance> getAll() {
        return openingBalanceDAO.getOpeningBalances();
    }

    public List<OpeningBalance> getOpeningBalancesBetweenIdAccount(int minValue, int maxValue){
        return openingBalanceDAO.getOpeningBalancesBetweenIdAccount(minValue, maxValue);
    }

}
