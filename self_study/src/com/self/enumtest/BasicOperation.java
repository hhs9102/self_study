package com.self.enumtest;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public enum BasicOperation {

	PLUS("+", "P"){
		public double apply(double x, double y) {
			return x+y;
		}
	}
	,MINUS("-", "M"){
		public double apply(double x, double y) {
			return x-y;
		}
	}
	;
	
	String symbol;
	String code;
	
	public abstract double apply(double x, double y);
	private static Map<String, BasicOperation> basicOperationMap = new HashMap<String, BasicOperation>();
	
	private BasicOperation(String symbol, String code) {
		this.symbol = symbol;
		this.code = code;
	}
	
	public static BasicOperation getBasicOperationByCode(String code) {
		if(basicOperationMap.isEmpty()) {
			for(BasicOperation bo : BasicOperation.values()) {
				basicOperationMap.put(bo.getCode(), bo);
			}
		}
		if(basicOperationMap.containsKey(code)) {
			return basicOperationMap.get(code);
		}
		throw new RuntimeException(code + " not exists");
	}
}
