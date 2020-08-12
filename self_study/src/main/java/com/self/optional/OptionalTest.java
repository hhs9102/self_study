package com.self.optional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class OptionalTest {

    @Test
    public void optionalMapTest(){
        Optional<TestObject> nullTestEnumInTestObject = Optional.ofNullable(new TestObject());
        Boolean result;

        Optional<TestEnum> testEnum = nullTestEnumInTestObject
                .map(TestObject::getTestEnum);
        assertEquals(Optional.empty(), testEnum);

        /**
         * nullTestEnumInTestObject를 map을 통해 Optional로 값을 받아오고
         * 해당 값을 map으로 다시 변환시켰는데, Optional이 비어있으면 아무일도 일어나지 않는다.
         */
        result = nullTestEnumInTestObject
                .map(TestObject::getTestEnum)   //getTestEnum의 값이 null이다. 비어있는 Optional을 반환함
                .map(TestEnum::isSuccess)       //아무일도 일어나지 않는다.
                .orElse(false);
        assertFalse(result);

        Optional<TestObject> nonNullTestEnumInTestObject = Optional.ofNullable(new TestObject(TestEnum.SUCCESS));
        result = nonNullTestEnumInTestObject
                .map(TestObject::getTestEnum)   //getTestEnum의 값이 null이 아니다.
                .map(TestEnum::isSuccess)
                .orElse(false);
        assertTrue(result);

    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class TestObject{
        private TestEnum testEnum;
    }

    private enum TestEnum {
        SUCCESS("성공")
        ,FAIL("실패");

        private String text;

        TestEnum(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }

        public Boolean isSuccess(){
            return equals(SUCCESS);
        }
    }
}


