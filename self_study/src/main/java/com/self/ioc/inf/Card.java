package com.self.ioc.inf;

import com.self.ioc.Account;

public class Card implements Payment{
    private int cardNumber;

    public Card(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public int pay(Account account, int price) {
        account.setAmount(account.getAmount() - price);
        return account.getAmount();
    }
}
