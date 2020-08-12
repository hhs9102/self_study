package com.self.modern.stream;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Trader {
    private final String name;
    private final String city;

    public Trader(String name, String city){
        this.name = name;
        this.city = city;
    }
}
