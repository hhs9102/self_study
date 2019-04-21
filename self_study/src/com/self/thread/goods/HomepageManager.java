package com.self.thread.goods;

public class HomepageManager implements Runnable{
	Goods goods;
	public void uploadGoods(Goods goods){
		this.goods = goods;
	}

	@Override
	public void run() {
		goods.setUploaded(true);
	}

}
