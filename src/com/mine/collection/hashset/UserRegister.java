package com.mine.collection.hashset;

import java.util.HashSet;
import java.util.Scanner;

public class UserRegister {
	public static HashSet <User> USER_DATA = new HashSet <User>();
	public static void main(String[] args) {
		initData(); //初始化人员信息
		Scanner input = new Scanner(System.in);
		System.out.print("请输入用户名：");
		String userName = input.nextLine(); //获取用户名
		System.out.print("请输入密码：");
		String password = input.nextLine(); //获取密码
		System.out.print("请重复密码：");
		String repassword = input.nextLine(); //获取重复密码
		System.out.print("出生日期： ");
		String birthday = input.nextLine(); //获取出生日期
		System.out.print("手机号码： ");
		String telNumber = input.nextLine(); //获取手机号码
		System.out.print("电子邮箱：");
		String email = input.nextLine(); //获取电子邮箱
		//校验用户信息，返回登录状态信息
		CheckInfo checkInfo = new CheckInfo(USER_DATA);
		String result = checkInfo.checkAction (userName, password, repassword, birthday, telNumber, email);
		System.out.println("注册结果：" + result);
	}
	private static void initData() {
		
	}
}
