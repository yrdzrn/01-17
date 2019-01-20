package com.mine.IOTest.Notepad;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Notepad {
	private static String filePath;
	private static String message = "";
	public static void main(String[] args) throws Exception{
		Scanner input = new Scanner(System.in);
		System.out.println("--1:新建文件 2.打开文件 3.修改文件 4.保存 5.退出");
		while(true){
			System.out.print("请输入指令：");
			int command = input.nextInt();
			switch (command) {
			case 1:
				createFile(); //1：新建文件
				break;
			case 2:
				openFile(); //2：打开文件
				break;
			case 3:
				editFile(); //3: 修改文件
				break;
			case 4:
				saveFile(); //4: 保存
				break;
			case 5:
				exit(); //5: 退出
				break;
			default:
				System.out.println("输入指令有误！");
				break;
			}
		}
	}
	/**
	 * 新建文件   从控制台获取内容
	 */
	private static void createFile() {
		message = ""; //新建文件时，message内容暂时清空
		Scanner input = new Scanner(System.in);
		System.out.println("请输入内容：停止输入请输入\"stop\"：");
		StringBuffer sbf = new StringBuffer ();
		String inputMessage = "";
		while (!inputMessage.equals("stop")){
			if (sbf.length() > 0){
				sbf.append("\r\n");
			}
			sbf.append(inputMessage);
			inputMessage = input.nextLine();
		}
		message = sbf.toString(); //将输入内容缓存
	}
	/**
	 * 打开文件
	 * @throws Exception
	 * 用户输入路径异常抛出
	 */
	private static void openFile() throws Exception{
		message = ""; //打开文件，将message内容清空
		Scanner input = new Scanner (System.in);
		System.out.println("请输入打开文件的位置：");
		filePath = input.next();//获取打开文件的位置
		if (filePath != null && !filePath.endsWith(".txt")){
			System.out.println("请选择文本文件！");
			return;
		}
		FileReader in = new FileReader(filePath);
		char[] charArray = new char[1024]; //缓冲数组
		int len = 0;
		StringBuffer sbf = new StringBuffer();
		while((len = in.read(charArray)) != -1){
			sbf.append(charArray);
		}
		message = sbf.toString();
		System.out.println("打开文件内容：" + "\r\n" + message);
		in.close();
	}
	/**
	 * 修改 通过字符串替换的形式
	 */
	private static void editFile() {
		 if (message=="" && filePath==null){
			 System.out.println("请先新建文件或者打开文件");
			 return;
		 }
		 Scanner input = new Scanner(System.in);
		 System.out.println("请输入要修改的内容（以\"修改的目标文字:修改之后的文字\"格式）," + "停止修改请输入\"stop\": ");
		 String inputMessage = "";
		 while (!inputMessage.equals("stop")){
			 inputMessage = input.nextLine();
			 if (inputMessage!=null && inputMessage.length()>0){
				 //将输入的文字根据“:”拆分成数组
				 String[] editMessage = inputMessage.split(":");
				 if (editMessage!=null && editMessage.length>1){
					 message = message.replace(editMessage[0], editMessage[1]);
				 }
			 }
		 }
		 System.out.println("修改后的内容：" + "\r\n" + message);
	}
	
	/**
	 * 保存
	 * 新建文件存在用户的输入路径   打开文件将原文件覆盖
	 */
	private static void saveFile() throws Exception{
		Scanner input = new Scanner(System.in);
		FileWriter out = null;
		if (filePath != null){ //文件是打开载入的
			out = new FileWriter(filePath);
		}else{ //文件是新建的
			System.out.print("请输入保存路径：");
			filePath = input.next();
			//将路径全部转换为小写字母后判断是不是文本格式
			if (!filePath.toLowerCase().endsWith(".txt")){
				filePath += ".txt";
			}
			out = new FileWriter(filePath);
		}
		out.write(message);
		out.close();
		message = "";
		filePath = null;
	}
	/**
	 * 退出
	 */
	private static void exit() {
		System.out.println("您已退出系统，谢谢使用");
		System.exit(0);
	}
}
