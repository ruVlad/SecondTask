package com.dev.service.impl;

import com.dev.dao.AccountDAO;
import com.dev.model.Account;
import com.dev.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDAO accountDAO;

    public void insert(Account account) {
        accountDAO.addAccount(account);
    }

    public void update(Account account) {
        accountDAO.updateAccount(account);
    }

    public Account getById(int id) {
        return accountDAO.getAccount(id);
    }

    public void delete(int id) {
        accountDAO.deleteAccount(id);
    }

    public List<Account> getAll() {
        return accountDAO.getAccounts();
    }

    public List<Account> getAccountsByIdFile(int id){
        return accountDAO.getAccountsByIdFile(id);
    }

}
