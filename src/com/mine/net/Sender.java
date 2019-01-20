package com.mine.net;

import java.net.*;

public class Sender {
	public static void main(String[] args) throws Exception{
		DatagramSocket ds = new DatagramSocket(3000);
		String str = "Hello world";
		byte[] arr = str.getBytes();
		DatagramPacket dp = new DatagramPacket(arr, arr.length, InetAddress.getByName("localhost"), 8954);
		System.out.println("发送信息");
		ds.send(dp);
		ds.close();
	}
}
