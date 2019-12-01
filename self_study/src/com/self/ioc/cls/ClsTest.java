package com.self.ioc.cls;

import com.self.ioc.Account;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClsTest {

    @Test
    public void classTest(){
        Account account = new Account(10000);
        Payment payment = new Payment();
        int price = 3000; //물품가
        payment.pay(account, price); //지불

        System.out.println("잔고 : "+account.getAmount());
        assertEquals(7000, account.getAmount());
    }
}
