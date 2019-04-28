package com.self.anno;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AnnotationTestMain {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		Person p = new Person("HOSIK", 56);
		Field f  = p.getClass().getDeclaredFields()[0];
		AnnotationFieldTest annoField = f.getAnnotation(AnnotationFieldTest.class);
		
		String fieldName = annoField.name();
		System.out.println(fieldName);
		
		Method m = p.getClass().getDeclaredMethod("getName");
		AnnotationMethodTest annoMethod = m.getAnnotation(AnnotationMethodTest.class);
		System.out.println(annoMethod.lastName());
	}

}
