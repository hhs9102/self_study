package com.self.generics.stack;

import lombok.extern.java.Log;

import java.util.Arrays;

@Log
public class Stack<E> {

	private E[] element;
	private int size = 0;
	private static final int DEFAULT_SIZE = 10;
	
	@SuppressWarnings("unchecked")
	public Stack(){
		element = (E[])new Object[DEFAULT_SIZE];
	}
	
	public void push(E e) {
		ensureCapacity();
		element[size++] = e;
	}
	
	public E pop(){
		if(isEmpty()) {
			throw new RuntimeException("Stack is empty.");
		}
		E result = element[--size];
		element[size] = null;	//메모리 초기화
		return result;
	}
	
	public void ensureCapacity() {
		if(element.length == size) {
			element = Arrays.copyOf(element, element.length + DEFAULT_SIZE);
		}
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public static void main(String[] args) {
		Stack<String> strStack = new Stack<>();	//7버전 이상부터 생략가능.
		strStack.push("1");
		strStack.push("2");
		strStack.push("3");
		
		while(!strStack.isEmpty()) {
			log.info(strStack.pop());
		}
	}
}
