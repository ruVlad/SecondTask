package com.dev.dao.impl;

import com.dev.dao.OpeningBalanceDAO;
import com.dev.model.OpeningBalance;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OpeningBalanceDAOImpl implements OpeningBalanceDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }


    public void addOpeningBalance(OpeningBalance openingBalance) {
        getCurrentSession().save(openingBalance);
    }

    public void updateOpeningBalance(OpeningBalance openingBalance) {
        OpeningBalance openingBalanceUpdate = getOpeningBalance(openingBalance.getId());
        openingBalanceUpdate.setId(openingBalance.getId());
        openingBalanceUpdate.setIdAccount(openingBalance.getIdAccount());
        openingBalanceUpdate.setAsset(openingBalance.getAsset());
        openingBalanceUpdate.setLability(openingBalance.getLability());
        getCurrentSession().update(openingBalanceUpdate);

    }

    public OpeningBalance getOpeningBalance(int id) {
        OpeningBalance openingBalance = (OpeningBalance) getCurrentSession().get(OpeningBalance.class, id);
        return openingBalance;
    }

    public void deleteOpeningBalance(int id) {
        OpeningBalance openingBalance= getOpeningBalance(id);
        if (openingBalance != null)
            getCurrentSession().delete(openingBalance);

    }

    @SuppressWarnings("unchecked")
    public List<OpeningBalance> getOpeningBalancesBetweenIdAccount(int minValue, int maxValue){
        List<OpeningBalance> openingBalances=
                getCurrentSession().createCriteria(OpeningBalance.class)
                        .add(Restrictions.between("idAccount", minValue, maxValue))
                        .list();
        return openingBalances;
    }

    @SuppressWarnings("unchecked")
    public List<OpeningBalance> getOpeningBalances() {
        return getCurrentSession().createQuery("from OpeningBalance").list();
    }
}
