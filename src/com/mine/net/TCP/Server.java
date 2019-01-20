package com.mine.net.TCP;

import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws Exception{
		new TCPServer().listen();
	}
}

//TCP服务端
class TCPServer {
	private static final int PORT = 7788;
	//定义一个listen方法，抛出一个异常
	public static void listen () throws Exception {
		//创建SeverSocket对象
		ServerSocket severSocket = new ServerSocket(PORT);
		while (true){
			final Socket client = severSocket.accept();
			new Thread(){
				public void run(){
					OutputStream os;
					try {
						os = client.getOutputStream();
						System.out.println("开始与客户端交互数据");
						os.write(("欢迎你").getBytes());
						Thread.sleep(5000);
						System.out.println("结束与客户端交互数据");
						os.close();
						client.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}.start();
		}
	}
}
