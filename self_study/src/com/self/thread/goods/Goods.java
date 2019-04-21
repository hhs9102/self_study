package com.self.thread.goods;

public class Goods {
	private Info info;
	boolean isUploaded;
	
	public Goods(Info info) {
		this.info = info;
	}

	public boolean isUploaded() {
		return isUploaded;
	}

	public synchronized void setUploaded(boolean isUploaded) {
		this.isUploaded = isUploaded;
		System.out.println(info.getName()+"이 업로드 되었습니다.");
		notifyAll();
	}
	
	public synchronized Info getInfo(){
		if(!isUploaded){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return info;
	}
}
