package com.self.ioc.inf;

import com.self.ioc.Account;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import static org.junit.Assert.assertEquals;

public class InfTest {

    @Rule
    public TestName name = new TestName();
    Payment payment;

    @Before
    public void setUp(){
        if("infCardTest".equals(name.getMethodName())){
            payment = new Card(129837);
        }else if("infCashTest".equals(name.getMethodName())){
            payment = new Cash();
        }
    }

    @Test
    public void infCardTest(){
        Account account = new Account(10000);
        int price = 3000; //물품가
        payment.pay(account, price); //지불

        System.out.println("잔고 : "+account.getAmount());
        assertEquals(7000, account.getAmount());
    }

    @Test
    public void infCashTest(){
        Account account = new Account(10000);
        int price = 3000; //물품가
        payment.pay(account, price); //지불

        System.out.println("잔고 : "+account.getAmount());
        assertEquals(7000, account.getAmount());
    }
}
