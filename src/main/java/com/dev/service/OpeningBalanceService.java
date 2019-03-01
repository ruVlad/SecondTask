package com.dev.service;

import com.dev.model.OpeningBalance;


import java.util.List;

public interface OpeningBalanceService {

    public void insert(OpeningBalance openingBalance);
    public void update(OpeningBalance openingBalance);
    public OpeningBalance getById(int id);
    public void delete(int id);
    public List<OpeningBalance> getAll();
    public List<OpeningBalance> getOpeningBalancesBetweenIdAccount(int minValue, int maxValue);

}
