package com.self.ioc.cls;

import com.self.ioc.Account;

public class Payment {
    public int pay(Account account, int price){
        account.setAmount(account.getAmount() - price);
        return account.getAmount();
    }
}
