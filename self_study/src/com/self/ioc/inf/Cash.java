package com.self.ioc.inf;

import com.self.ioc.Account;

public class Cash implements Payment{
    @Override
    public int pay(Account account, int price) {
        account.setAmount(account.getAmount() - price);
        return account.getAmount();
    }
}
