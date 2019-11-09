package com.self.modern.stream;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Transaction {
    private final Trader trader;
    private final int year;
    private final int value;

    public Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }
}
