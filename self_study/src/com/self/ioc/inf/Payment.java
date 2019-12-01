package com.self.ioc.inf;

import com.self.ioc.Account;

public interface Payment {
    public int pay(Account account, int price);
}
