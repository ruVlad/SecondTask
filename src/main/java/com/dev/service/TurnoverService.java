package com.dev.service;

import com.dev.model.OpeningBalance;
import com.dev.model.Turnover;


import java.util.List;

public interface TurnoverService {

    public void insert(Turnover turnover);
    public void update(Turnover turnover);
    public Turnover getById(int id);
    public void delete(int id);
    public List<Turnover> getAll();
    public List<Turnover> getTurnoversBetweenIdAccount(int minValue, int maxValue);

}
