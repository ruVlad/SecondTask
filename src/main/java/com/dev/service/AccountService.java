package com.dev.service;

import com.dev.model.Account;

import java.util.List;

public interface AccountService {

    public void insert(Account account);
    public void update(Account account);
    public Account getById(int id);
    public void delete(int id);
    public List<Account> getAll();
    public List<Account> getAccountsByIdFile(int id);

}
