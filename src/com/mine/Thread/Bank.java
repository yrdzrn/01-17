package com.mine.Thread;

public class Bank {
	private int sum;
	public void add (int num){
		synchronized (this) {
			sum += num;
			System.out.println("当前账户余额为：" + sum);
		}
	}
}
