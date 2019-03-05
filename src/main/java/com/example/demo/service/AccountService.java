package com.example.demo.service;

import com.example.demo.entity.Account;

import java.util.List;

/**
 * @Auther: admin
 * @Date: 2019/3/5 11:45
 * @Description:
 */
public interface AccountService {
    int add(Account account);

    int update(Account account);

    int delete(int id);

    Account findAccountById(int id);

    List<Account> findAccountList();

}
