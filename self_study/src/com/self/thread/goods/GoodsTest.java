package com.self.thread.goods;

public class GoodsTest {

	public static void main(String[] args) {
		HomepageManager homepageManager = new HomepageManager();
		Info info = new Info("삼성 노트북", 1800000);
		Goods goods = new Goods(info);
		homepageManager.uploadGoods(goods);
		
		Customer customer1 = new Customer("홍길동", goods);
		Customer customer2 = new Customer("이영자", goods);
		
		new Thread(customer1).start();
		new Thread(customer2).start();
		new Thread(homepageManager).start();
		
		
	}

}
