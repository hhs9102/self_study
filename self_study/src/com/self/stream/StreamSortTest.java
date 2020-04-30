package com.self.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class StreamSortTest {

    private List<Person> personList = new ArrayList<>();

    @Before
    public void setup(){
        personList.add(new Person("name1", 170, LocalDate.of(1990,01,01)));
        personList.add(new Person("name2", 175, LocalDate.of(1991,01,01)));
        personList.add(new Person("name3", 170, LocalDate.of(1991,01,01)));
        personList.add(new Person("name4", 180, LocalDate.of(1990,01,01)));
        personList.add(new Person("name5", 180, LocalDate.of(1993,01,01)));
        personList.add(new Person("name6", 180, LocalDate.of(2000,01,01)));
    }

    @Test
    public void 제일_크고_제일_젊은_사람(){
        assertEquals(6, personList.size());

        assertEquals("name6", personList.stream()
                .sorted(Comparator.comparing(Person::getHeight,Comparator.reverseOrder())
                        .thenComparing(Person::getBirth, Comparator.reverseOrder()))
                .findFirst()
                .get()
                .getName());

        assertEquals("name6", personList.stream()
                .sorted(Person::compareTallAndYoung)
                .findFirst()
                .get()
                .getName());
    }

    @Data
    @AllArgsConstructor
    public static class Person{
        private String name;
        private Integer height;
        private LocalDate birth;

        //TODO 좀 더 깔끔하게..? 멋지게..?
        public int compareTallAndYoung(Person target){
            if(this.height < target.getHeight()){
                return 1;
            }else if(this.height == target.getHeight()){
                if(target.getBirth().isBefore(this.birth)){
                    return 1;
                }else if(target.getBirth().equals(this.birth)){
                    return 0;
                }else{
                    return -1;
                }
            }else{
                return -1;
            }

        }
    }
}


