package com.mine.net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Receiver {
	public static void main(String[] args) throws Exception{
		byte[] buf = new byte[1024];
		//监听端口
		DatagramSocket ds = new DatagramSocket(8954);
		//接收数据
		DatagramPacket dp = new DatagramPacket(buf, buf.length);
		System.out.println("等待接收数据");
		ds.receive(dp);
		String str = new String(dp.getData(), 0, dp.getLength()) + "from" + dp.getAddress().getHostAddress() + ":" +dp.getPort();
		System.out.println(str);
		ds.close();
	}
}
