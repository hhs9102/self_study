package com.self.anno;

import java.lang.reflect.Field;

public class MainClass {

	public static void main(String[] args) {
		Person p = new Person("HOSIK", 56);
		Field f  = p.getClass().getDeclaredFields()[0];
		AnnotationFieldTest annoField = f.getAnnotation(AnnotationFieldTest.class);
		
		String fieldName = annoField.name();
		System.out.println(fieldName);
	}

}
