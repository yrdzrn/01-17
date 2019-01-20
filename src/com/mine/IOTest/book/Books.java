/**
 * 保存书店每日交易记录
 */
package com.mine.IOTest.book;

public class Books {
	int id;
	String name; //图书名称
	double price; //图书单价
	int number; //图书数量
	double money; //总价
	String publish; //出版社
	//构造函数
	public Books(int id, String name, double price, int number, double money, String publish) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.number = number;
		this.money = money;
		this.publish = publish;
	}
	@Override
	public String toString() {
		String message = "图书编号：" + id + " 图书名称：" + name +
				" 出版社：" + publish + " 单价：" + price + "库存数量" + number;
		return message;
	}
	
	public void setNumber (int number){
		this.number = number; 
	}
}
