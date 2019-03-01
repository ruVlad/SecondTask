package com.dev.service.impl;

import com.dev.dao.TurnoverDAO;
import com.dev.model.Turnover;
import com.dev.service.TurnoverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TurnoverServiceImpl implements TurnoverService {

    @Autowired
    private TurnoverDAO turnoverDAO;

    public void insert(Turnover turnover) {
        turnoverDAO.addTurnover(turnover);
    }

    public void update(Turnover turnover) {
        turnoverDAO.updateTurnover(turnover);
    }

    public Turnover getById(int id) {
        return turnoverDAO.getTurnover(id);
    }

    public void delete(int id) {
        turnoverDAO.deleteTurnover(id);
    }

    public List<Turnover> getAll() {
        return turnoverDAO.getTurnovers();
    }

    public List<Turnover> getTurnoversBetweenIdAccount(int minValue, int maxValue){
        return turnoverDAO.getTurnoversBetweenIdAccount(minValue, maxValue);
    }

}
