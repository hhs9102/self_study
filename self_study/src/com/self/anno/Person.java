package com.self.anno;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person {
	@AnnotationFieldTest(name = "This is Field Annotaion")
	String name;
	int age;
	
	@AnnotationMethodTest(lastName="HAM")
	public String getName() {
		return this.name;
	}

}
