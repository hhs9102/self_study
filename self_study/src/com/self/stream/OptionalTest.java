package com.self.stream;

import com.self.stream.order.Product;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OptionalTest {


    @Test
    public void optionalOfNullableTest(){
        Map<String, String> strMap =  null;
        Map<String, String> copiedMap = Optional.ofNullable(strMap)
                                        .orElse(new HashMap<String, String>());
        copiedMap.put("test", "TEST");
        Assert.assertEquals("TEST", copiedMap.get("test"));
    }

    @Test
    public void optionalOfTest(){
        Optional optional = Optional.of("ofTest");
        System.out.println(optional.get());
        System.out.println(optional);
        System.out.println(optional.getClass());
        System.out.println(Optional.empty());

        String filteredStr = (String)optional.filter(str -> "ofaTest".equals(str)).orElse("TTTT");
        System.out.println(filteredStr);

        Optional<Product> optProduct = Optional.empty();
        Product p = optProduct.orElse(new Product(1l, "Mac", new BigDecimal("3000000")));
        System.out.println(p.getPrice());

        if(optional.isPresent()){
            System.out.println("isPresent");
        }
    }

    @Test
    public void optionalIfPresentTest(){
        InnerClassTest innerClassTest = new InnerClassTest();
        System.out.println(innerClassTest.getNumber().get());
        innerClassTest.getStr().ifPresent(System.out::println);

        innerClassTest.getStr().ifPresent(System.out::println);
        String test = innerClassTest.getStr().orElse("3");
        innerClassTest.getStr().ifPresentOrElse(System.out::println, () -> System.out.println("333"));
    }

    class InnerClassTest{
        private int number;
        private String str;

        public void setStr(String str){
            this.str=str;
        }

        public Optional<String> getStr(){
            return Optional.ofNullable(str);
        }

        public void setNumber(int number){
            this.number= number;
        }

        public Optional<Integer> getNumber(){
            return Optional.ofNullable(number);
        }
    }
}
