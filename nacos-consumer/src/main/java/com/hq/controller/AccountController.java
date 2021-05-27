package com.hq.controller;

import com.hq.generator.domain.Account;
import com.hq.service.AccountService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class AccountController {
    @Autowired
    AccountService accountService;

    @RequestMapping("/payMoney")
    public String payMoney(String accountid,double amount) {
        Account account = accountService.selectByPrimaryKey(accountid);
        BigDecimal amount1 = account.getAmount();

            BigDecimal decimal = new BigDecimal(amount);
            if (amount1.compareTo(decimal) == -1){
                throw new RuntimeException("付款失败");
            }
            BigDecimal subtract = amount1.subtract(decimal);
            account.setAmount(subtract);
            accountService.updateByPrimaryKey(account);
            return "付款成功";


    }

    @RequestMapping("/getAccount")
    public String getAcount(String id){
        return accountService.selectByPrimaryKey(id).toString();
    }


}
