package com.dev.dao;

import com.dev.model.ClosingBalance;

import java.util.List;

public interface ClosingBalanceDAO {

    public void addClosingBalance(ClosingBalance closingBalance);
    public void updateClosingBalance(ClosingBalance closingBalance);
    public ClosingBalance getClosingBalance(int id);
    public void deleteClosingBalance(int id);
    public List<ClosingBalance> getClosingBalances();
    public List<ClosingBalance> getClosingBalancesBetweenIdAccount(int minValue, int maxValue);
}
