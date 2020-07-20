package com.haowaner.service.impl;

import com.haowaner.Dao.AccountDao;
import com.haowaner.damain.Account;
import com.haowaner.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 业务层接口实现类
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {
    //注入accountDao
    @Autowired
    private AccountDao accountDao;
    @Override
    public Account find(String name) {
        return accountDao.find(name);
    }

    @Override
    //也可以卸载类上
   /* <tx:advice id="transactionInterceptor" transaction-manager="transactionManager">
        <tx:attributes>
            <tx:method name="*" isolation="DEFAULT" propagation="REQUIRED"/>
        </tx:attributes>
    </tx:advice>
            &lt;!&ndash;配置aop&ndash;&gt;
    <aop:config>
        <aop:advisor advice-ref="transactionInterceptor" pointcut="execution(* com.haowaner.service.impl..*.*(..))"></aop:advisor>
    </aop:config>*/
    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED,timeout =-1)
    public void transcation(String targetName, String proxyName, Double money) {
        //自己把方法补全
        Account fromAccount = accountDao.find(targetName);
        Account toAccount = accountDao.find(proxyName);
        fromAccount.setMoney(fromAccount.getMoney()-money);
        toAccount.setMoney(toAccount.getMoney()+money);
        accountDao.update(fromAccount);
        int i=10/0;
        accountDao.update(toAccount);
    }

}
