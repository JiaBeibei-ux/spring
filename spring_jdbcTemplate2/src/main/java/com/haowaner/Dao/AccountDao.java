package com.haowaner.Dao;

import com.haowaner.damain.Account;

import java.util.List;

/**
 * 账户持久层
 */
public interface AccountDao {
    //查询方法
    public Account find(String name);
    public void update(Account account);
}
