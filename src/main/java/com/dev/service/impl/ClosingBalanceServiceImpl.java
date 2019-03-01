package com.dev.service.impl;

import com.dev.dao.ClosingBalanceDAO;
import com.dev.model.ClosingBalance;
import com.dev.service.ClosingBalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClosingBalanceServiceImpl implements ClosingBalanceService {

    @Autowired
    private ClosingBalanceDAO closingBalanceDAO;

    public void insert(ClosingBalance closingBalance) {
        closingBalanceDAO.addClosingBalance(closingBalance);
    }

    public void update(ClosingBalance closingBalance) {
        closingBalanceDAO.updateClosingBalance(closingBalance);
    }

    public ClosingBalance getById(int id) {
        return closingBalanceDAO.getClosingBalance(id);
    }

    public void delete(int id) {
        closingBalanceDAO.deleteClosingBalance(id);
    }

    public List<ClosingBalance> getAll() {
        return closingBalanceDAO.getClosingBalances();
    }

    public List<ClosingBalance> getClosingBalancesBetweenIdAccount(int minValue, int maxValue){
        return closingBalanceDAO.getClosingBalancesBetweenIdAccount(minValue, maxValue);
    }

}
