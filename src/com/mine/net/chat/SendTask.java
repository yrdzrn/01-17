package com.mine.net.chat;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class SendTask implements Runnable{
	private int sendPort;

	public SendTask(int sendPort) {
		this.sendPort = sendPort;
	}

	@Override
	public void run() {
		try {
			//创建DatagramSocket对象
			DatagramSocket ds = new DatagramSocket();
			//输入要发送的数据
			Scanner input= new Scanner(System.in);
			while(true){
				String data = input.nextLine();
				//封装数据到DatagramPacket对象中
				byte[] buf =data.getBytes();
				DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("127.0.0.255"), sendPort);
				//发送数据
				ds.send(dp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
