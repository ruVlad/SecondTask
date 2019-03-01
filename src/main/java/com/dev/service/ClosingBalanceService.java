package com.dev.service;

import com.dev.model.ClosingBalance;

import java.util.List;

public interface ClosingBalanceService {

    public void insert(ClosingBalance closingBalance);
    public void update(ClosingBalance closingBalance);
    public ClosingBalance getById(int id);
    public void delete(int id);
    public List<ClosingBalance> getAll();
    public List<ClosingBalance> getClosingBalancesBetweenIdAccount(int minValue, int MaxValue);

}
