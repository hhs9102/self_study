package com.self.generics;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Box<T extends Eatable> {

	private final String box;
	private final List<T> list;
	
	public Box(String box) {
		this.box = box;
		list = new ArrayList<T>();
	}
	
	public void addBox(T e) {
		list.add((T) e);
	}
}
