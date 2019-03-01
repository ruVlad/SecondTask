package com.dev.dao;

import com.dev.model.Account;

import java.util.List;

public interface AccountDAO {

    public void addAccount(Account account);
    public void updateAccount(Account account);
    public Account getAccount(int id);
    public void deleteAccount(int id);
    public List<Account> getAccounts();
    public List<Account> getAccountsByIdFile(int id);
}
