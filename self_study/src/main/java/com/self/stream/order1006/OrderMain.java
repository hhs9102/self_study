package com.self.stream.order1006;

import java.math.BigDecimal;
import java.util.Random;

public class OrderMain
{
    public static void main(String[] args) {

        Product p = new Product(new Random().nextLong());
        System.out.println("Product============================================");
        System.out.println(p.getTotalPrice());

        Item item1 = Item.builder()
                .id(new Random().nextLong())
                .name("테팔 스팀 다리미")
                .quantity(3)
                .price(new BigDecimal("43000"))
                .build();
        p.addItem(item1);

        System.out.println("Item1 세팅============================================");
        System.out.println("item1 : "+item1.getTotalPrice());
        System.out.println("product : "+p.getTotalPrice());

        Item item2 = Item.builder()
                .id(new Random().nextLong())
                .name("아메리카노")
                .price(new BigDecimal("4100"))
                .quantity(23)
                .build();

        p.addItem(item2);
        System.out.println("Item2 세팅============================================");
        System.out.println("item2 : "+item2.getTotalPrice());
        System.out.println("product : "+p.getTotalPrice());

        Item priceNullItem = Item.builder()
                .id(new Random().nextLong())
                .name("사무용의자")
                .quantity(30)
                .build();
        p.addItem(priceNullItem);
        System.out.println("Item3 세팅============================================");
        System.out.println("item3 : "+priceNullItem.getTotalPrice());
        System.out.println("product : "+p.getTotalPrice());

    }
}
