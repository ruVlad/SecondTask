package com.dev.dao;

import com.dev.model.OpeningBalance;

import java.util.List;

public interface OpeningBalanceDAO {

    public void addOpeningBalance(OpeningBalance openingBalance);
    public void updateOpeningBalance(OpeningBalance openingBalance);
    public OpeningBalance getOpeningBalance(int id);
    public void deleteOpeningBalance(int id);
    public List<OpeningBalance> getOpeningBalances();
    public List<OpeningBalance> getOpeningBalancesBetweenIdAccount(int minValue, int maxValue);
}
