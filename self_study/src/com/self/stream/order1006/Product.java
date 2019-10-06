package com.self.stream.order1006;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Product {

    long id;
    List<Item> items;

    public Product(long id){
        this.id = id;
        this.items = new ArrayList<>();
    }

    public void addItem(Item item){
        this.items.add(item);
    }

    public List<Item> getItems(){
        return items;
    }

    public BigDecimal getTotalPrice(){

        return items.stream()
                .map(i-> i.getTotalPrice())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
