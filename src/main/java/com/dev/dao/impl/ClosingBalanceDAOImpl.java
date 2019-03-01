package com.dev.dao.impl;

import com.dev.dao.ClosingBalanceDAO;
import com.dev.model.ClosingBalance;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClosingBalanceDAOImpl implements ClosingBalanceDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }


    public void addClosingBalance(ClosingBalance closingBalance) {
        getCurrentSession().save(closingBalance);
    }

    public void updateClosingBalance(ClosingBalance closingBalance) {
        ClosingBalance closingBalanceUpdate = getClosingBalance(closingBalance.getId());
        closingBalanceUpdate.setId(closingBalance.getId());
        closingBalanceUpdate.setIdAccount(closingBalance.getIdAccount());
        closingBalanceUpdate.setAsset(closingBalance.getAsset());
        closingBalanceUpdate.setLiability(closingBalance.getLiability());
        getCurrentSession().update(closingBalanceUpdate);

    }

    public ClosingBalance getClosingBalance(int id) {
        return (ClosingBalance) getCurrentSession().get(ClosingBalance.class, id);
    }

    public void deleteClosingBalance(int id) {
        ClosingBalance closingBalance= getClosingBalance(id);
        if (closingBalance != null)
            getCurrentSession().delete(closingBalance);

    }

    @SuppressWarnings("unchecked")
    public List<ClosingBalance> getClosingBalancesBetweenIdAccount(int minValue, int maxValue){
        List<ClosingBalance> closingBalances=
                getCurrentSession().createCriteria(ClosingBalance.class)
                        .add(Restrictions.between("idAccount", minValue, maxValue))
                        .list();
        return closingBalances;
    }

    @SuppressWarnings("unchecked")
    public List<ClosingBalance> getClosingBalances() {
        return getCurrentSession().createQuery("from ClosingBalance").list();
    }
}
