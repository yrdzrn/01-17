package com.mine.net.chat;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ReceiverTask implements Runnable{
	private int receiverPort;

	public ReceiverTask(int receiverPort) {
		this.receiverPort = receiverPort;
	}

	@Override
	public void run() {
		try {
			//DatagramSocket对象
			DatagramSocket ds = new DatagramSocket(receiverPort);
			//创建DatagramPacket对象
			byte[] buf = new byte[1024];
			DatagramPacket dp = new DatagramPacket(buf, buf.length);
			while(true){
				ds.receive(dp);
				String str = new String(dp.getData(), 0, dp.getLength());
				System.out.println("收到" + dp.getAddress().getHostAddress() + "--发送的数据--" + str);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
