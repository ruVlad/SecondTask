package com.dev.dao.impl;

import com.dev.dao.AccountDAO;
import com.dev.model.Account;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }


    public void addAccount(Account account) {
        getCurrentSession().save(account);
    }

    public void updateAccount(Account account) {
        Account accountUpdate = getAccount(account.getId());
        accountUpdate.setId(account.getId());
        accountUpdate.setNumber(account.getNumber());
        accountUpdate.setIdFile(account.getIdFile());
        getCurrentSession().update(accountUpdate);

    }

    public Account getAccount(int id) {
        Account account = (Account) getCurrentSession().get(Account.class, id);
        return account;
    }

    public void deleteAccount(int id) {
        Account account= getAccount(id);
        if (account != null)
            getCurrentSession().delete(account);

    }

    @SuppressWarnings("unchecked")
    public List<Account> getAccountsByIdFile(int id){
        List<Account> accounts =
                getCurrentSession().createCriteria(Account.class)
                        .add(Restrictions.eq("idFile", id))
                        .list();
        return accounts;
    }

    @SuppressWarnings("unchecked")
    public List<Account> getAccounts() {
        return getCurrentSession().createQuery("from Account").list();
    }
}
