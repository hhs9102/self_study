package com.self.ioc;

public class Account {
    private int amount;
    public Account(int amount){
        this.amount = amount;
    }
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
