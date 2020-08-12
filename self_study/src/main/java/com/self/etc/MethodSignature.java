package com.self.etc;

import org.junit.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.Assert.assertEquals;

public class MethodSignature {

     public String testMethod(String str) throws RuntimeException{
        return "This is testMethod. Parameter is "+str;
    }

    @Test
    public void test() throws NoSuchMethodException {
        Method method = MethodSignature.class.getMethod("testMethod", String.class);
        assertEquals(String.class, method.getReturnType());
        assertEquals(1, method.getParameterTypes().length);
        assertEquals(String.class, method.getParameterTypes()[0]);
        assertEquals(1, method.getExceptionTypes().length);
        assertEquals(RuntimeException.class, method.getExceptionTypes()[0]);
        assertEquals(Modifier.PUBLIC, method.getModifiers());
        System.out.println(method);
    }
}
