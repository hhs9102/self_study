package com.self.thread.goods;

public class Customer implements Runnable{
	private Goods goods;
	private String name;
	
	public Customer(String name, Goods goods) {
		this.name = name;
		this.goods = goods;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println(name+"님이 "+goods.getInfo().getName()+"을 보고있습니다.");
	}
	
	

}
