package com.self.modern.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Practice5_6_2 {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011,300)
                ,new Transaction(raoul, 2012,1000)
                ,new Transaction(raoul, 2011,400)
                ,new Transaction(mario, 2012,710)
                ,new Transaction(mario, 2012,700)
                ,new Transaction(brian, 2012,950)
        );



        System.out.println("1. 2011년에 일어난 모든 트랜잭션 값을 찾아 오름차순으로 정리하시오. : \n"+transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList())
        );

        System.out.println("2. 거래자가 근무하는 모든 도시를 중복없이 나열하시오. : \n"+ transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getCity)
                .distinct()
                .collect(Collectors.toList())
        );

        System.out.println("3. 케임브리지에서 근무하는 모든 거래자를 찾아서 이름순으로 정렬하시오. : \n"+ transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .map(Trader::getName)
                .distinct()
                .sorted(String::compareTo)
                .collect(Collectors.toList())
        );

        System.out.println("4. 모든 거래자의 이름을 알파벳순으로 정렬해서 반환하시오. : \n"+ transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getName)
                .distinct()
                .sorted()
                .collect(Collectors.toList())
        );

        System.out.println("5. 밀라노에 거래자가 있는가? : \n"+ transactions.stream()
                .anyMatch(t -> t.getTrader().getCity().equals("Milan"))
        );

        System.out.println("6. 케임브리지에 거주하는 거래자의 모든 트랜잭션 값을 출력하시오. : \n" +transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .collect(Collectors.toList())
        );

        System.out.println("7. 전체 트랜잭션 중 최댓값은 얼마인가? : \n"+ transactions.stream()
                .map(Transaction::getValue)
                .max(Integer::compareTo)
                .get()
        );

        System.out.println("8. 전체 트랜잭션 중 최댓값은 얼마인가? : \n"+ transactions.stream()
                .map(Transaction::getValue)
                .min(Integer::compareTo)
                .get()
        );

    }

}
