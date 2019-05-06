package com.self.anno;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AnnotationTestMain {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		Person p = new Person("HOSIK", "A Company", 56);
		Field nameField  = p.getClass().getDeclaredFields()[0];
		Field companyField  = p.getClass().getDeclaredFields()[1];
		
		AnnotationFieldTest nameAnnoField = nameField.getAnnotation(AnnotationFieldTest.class);
		AnnotationFieldTest companyAnnoField = companyField.getAnnotation(AnnotationFieldTest.class);
		
		System.out.println(nameAnnoField.name());
		System.out.println(companyAnnoField.name());
		
		Method m = p.getClass().getDeclaredMethod("getName");
		AnnotationMethodTest annoMethod = m.getAnnotation(AnnotationMethodTest.class);
		System.out.println(annoMethod.lastName());
	}

}
