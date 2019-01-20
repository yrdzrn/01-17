package com.mine.net.chat;

import java.util.Scanner;

/**
 * 聊天室
 * @author 25868
 */
public class CharRoom {
	public static void main(String[] args) {
		System.out.println("欢迎进入聊天室！");
		Scanner input = new Scanner(System.in);
		System.out.print("请输入本程序发送端端口：");
		int sendPort = input.nextInt();
		System.out.print("请输入本程序接收端端口：");
		int receiverPort = input.nextInt();
		System.out.println("聊天室系统启动");
		new Thread(new SendTask(sendPort), "发送端任务").start();
		new Thread(new ReceiverTask(receiverPort), "接收端任务").start();
	}
}
