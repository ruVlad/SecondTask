package com.dev.dao;

import com.dev.model.Turnover;

import java.util.List;

public interface TurnoverDAO {

    public void addTurnover(Turnover turnover);
    public void updateTurnover(Turnover turnover);
    public Turnover getTurnover(int id);
    public void deleteTurnover(int id);
    public List<Turnover> getTurnovers();
    public List<Turnover> getTurnoversBetweenIdAccount(int minValue, int maxValue);
}
