package com.haowaner.Dao.impl;

import com.haowaner.Dao.AccountDao;
import com.haowaner.damain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

/**
 * 账户持久层实现类
 */
@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {
    @Autowired//注入数据源
    private JdbcTemplate jdbcTemplate;
    @Override
    public Account find(String name) {
        Account account = jdbcTemplate.queryForObject("select * from account where name = ?", new BeanPropertyRowMapper<Account>(Account.class), name);
        return account;
    }
    //更新操作
    @Override
    public void update(Account account) {
        jdbcTemplate.update("update account set money = ? where id = ?", account.getMoney(), account.getId());
    }

}
