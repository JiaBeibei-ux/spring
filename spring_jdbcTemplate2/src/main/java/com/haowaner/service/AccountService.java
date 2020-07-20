package com.haowaner.service;

import com.haowaner.damain.Account;

import java.util.List;

/**
 * 账户业务层接口
 */
public interface AccountService {
    //查询方法
    public Account find(String name);
    //转账的方法
    public void transcation(String targetName,String proxyName,Double money);
}
