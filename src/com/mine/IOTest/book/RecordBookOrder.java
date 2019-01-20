package com.mine.IOTest.book;

import java.util.ArrayList;
import java.util.Scanner;

public class RecordBookOrder {
	//创建书架
	public static ArrayList<Books> booksList = new ArrayList<Books>();
	public static void main(String[] args) {
		init(); //初始化书架
		//打印书架上的图书信息
		for (int i=0; i<booksList.size(); i++){
			System.out.println(booksList.get(i));
		}
		while(true){
			Scanner input = new Scanner(System.in);
			System.out.print("请输入图书编号：");
			int bookId = input.nextInt();
			Books stockBooks = getBookById(bookId);
			if (stockBooks != null){
				System.out.println("当前图书信息：" + stockBooks);
				System.out.print("请输入购买数量：");
				int bookNumber = input.nextInt();
				if (bookNumber <= stockBooks.number){
					//将输入信息封装成Books对象
					Books books = new Books (stockBooks.id, stockBooks.name, stockBooks.price, bookNumber,
							stockBooks.price*bookNumber, stockBooks.publish);
					FileUtil.saveBooks (books); //将本条数据保存至本地文件
					//修改库存
					stockBooks.setNumber(stockBooks.number - bookNumber);
				} else{
					System.out.println("库存不足");
				}
			}else{
				System.out.println("图书编号输入有误！");
			}
		}
	}
	private static void init() {
		Books goods1 = new Books(101, "Java基础入门", 44.50, 100, 4450.00, "清华大学出版社");
		Books goods2 = new Books(102, "Java编程思想", 108.00, 50, 5400.00, "机械工业出版社");
		Books goods3 = new Books(102, "疯狂Java讲义", 99.00, 100, 9900.00, "电子工业出版社");
		booksList.add(goods1);
		booksList.add(goods2);
		booksList.add(goods3);
	}
	/**
	 * 根据图书编号查找图书信息
	 */
	private static Books getBookById (int bookId){
		for (int i=0; i<booksList.size(); i++){
			Books thisBook = booksList.get(i);
			if (bookId == thisBook.id){
				return thisBook;
			}
		}
		return null;
	}
}
