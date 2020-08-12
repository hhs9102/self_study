package com.self.anno;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
public class Person {
	@AnnotationFieldTest(name = "This is Person name Annotaion")
	String name;
	
	@AnnotationFieldTest
			@Getter
	String  company;
	int age;
	
	@AnnotationMethodTest(lastName="HAM")
	public String getName() {
		return this.name;
	}

}
