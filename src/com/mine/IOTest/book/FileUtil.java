package com.mine.IOTest.book;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileUtil {
	/**
	 * csv文件格式
	 */
	public static final String SEPARARE_FIELD = ","; //字段分隔 英文逗号
	public static final String SEPARARE_LINE = "\r\n";  //行分隔
	/**
	 * 保存图书信息
	 */
	public static void saveBooks (Books books){
		//判断本地是否存在此文件
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyyMMdd"); //定义日期格式
		String name = "销售记录" + format.format(date) + ".csv"; //拼接文件名
		InputStream in = null;
		try {
			in = new FileInputStream(name);
			if (in != null){
				in.close();
				createFile (name, true, books); //存在文件，采取修改文件方式
			}
		} catch (FileNotFoundException e) {
			createFile(name, false, books); //不存在文件，采取新建新文件方式
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private static void createFile(String name, boolean label, Books books) {
		BufferedOutputStream out = null;
		StringBuffer sbf = new StringBuffer(); //拼接内容
		try {
			if (label){ //当已存在当天的文件，则在
				//创建输出流，用于追加文件
				out = new BufferedOutputStream (new FileOutputStream(name, true));
			}
			else {
				//创建输出流，用来保存文件
				out = new BufferedOutputStream(new FileOutputStream(name));
				String[] fieldSort = new String[] {"图书编号", "图书名称", "购买数量", "单价", "总价", "出版社"};
				//创建表头
				for (String fieldKey : fieldSort){
					//新建时，将表头存入本地文件
					sbf.append(fieldKey).append(SEPARARE_FIELD);
				}
			}
			sbf.append(SEPARARE_LINE); //追加换行符
			sbf.append(books.id).append(SEPARARE_FIELD);
			sbf.append(books.name).append(SEPARARE_FIELD);
			sbf.append(books.number).append(SEPARARE_FIELD);
			sbf.append((double)books.price).append(SEPARARE_FIELD);
			sbf.append((double)books.money).append(SEPARARE_FIELD);
			sbf.append(books.publish).append(SEPARARE_FIELD);
			String str = sbf.toString();
			byte[] b = str.getBytes();
			for (int i=0; i<b.length; i++){
				out.write(b[i]); //将内容写入本地文件
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null){
					out.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
