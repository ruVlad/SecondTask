package com.dev.dao.impl;

import com.dev.dao.TurnoverDAO;
import com.dev.model.Turnover;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TurnoverDAOImpl implements TurnoverDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }


    public void addTurnover(Turnover turnover) {
        getCurrentSession().save(turnover);
    }

    public void updateTurnover(Turnover turnover) {
        Turnover turnoverUpdate = getTurnover(turnover.getId());
        turnoverUpdate.setId(turnover.getId());
        turnoverUpdate.setIdAccount(turnover.getIdAccount());
        turnoverUpdate.setDebit(turnover.getDebit());
        turnoverUpdate.setLoan(turnover.getLoan());
        getCurrentSession().update(turnoverUpdate);

    }

    public Turnover getTurnover(int id) {
        Turnover turnover = (Turnover) getCurrentSession().get(Turnover.class, id);
        return turnover;
    }

    public void deleteTurnover(int id) {
        Turnover turnover= getTurnover(id);
        if (turnover != null)
            getCurrentSession().delete(turnover);

    }

    @SuppressWarnings("unchecked")
    public List<Turnover> getTurnoversBetweenIdAccount(int minValue, int maxValue){
        List<Turnover> turnovers =
                getCurrentSession().createCriteria(Turnover.class)
                        .add(Restrictions.between("idAccount", minValue, maxValue))
                        .list();
        return turnovers;
    }

    @SuppressWarnings("unchecked")
    public List<Turnover> getTurnovers() {
        return getCurrentSession().createQuery("from Turnover").list();
    }
}
