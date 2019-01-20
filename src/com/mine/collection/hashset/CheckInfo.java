package com.mine.collection.hashset;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

public class CheckInfo {
	public static HashSet<User> USER_DATA = new HashSet<User> ();
	
	public CheckInfo (HashSet<User> USER_DATA){
		this.USER_DATA = USER_DATA;
	}
	//校验用户信息，返回登录状态信息
	public String checkAction(String userName, String password, String repassword, String birthday, String telNumber,
			String email) {
		StringBuilder result = new StringBuilder();
		//1代表成功， 2代表失败
		int state = 1;
		//密码判断
		if(!password.equals(repassword)){
			result.append("两次输入密码不一致！\r\n");
			state = 2;
		}
		//生日判断
		if (birthday.length() != 10){
			result.append("生日格式不正确！\r\n");
			state = 2;
		}
		else{
			for (int i=0; i<birthday.length(); i++){
				Character thischar = birthday.charAt(i);
				if (i==4 || i==7){
					if (!(thischar == '-')){
						result.append("生日格式不正确");
						state = 2;
					}
				}
				else{
					if (!(Character.isDigit(thischar))){
						result.append("生日格式不正确");
						state = 2;
					}
				}
			}
		}
		//手机号判断
		if (telNumber.length() != 11){
			result.append("手机号码不正确！\r\n");
			state = 2;
		}else if (!(telNumber.startsWith("13") || telNumber.startsWith("15") || telNumber.startsWith("17") || telNumber.startsWith("18"))){
			result.append("手机号码不正确！\r\n");
			state = 2;
		}
		//邮箱判断
		if (!email.contains("@")){
			result.append("邮箱不正确！\r\n");
			state = 2;
		}
		//如果信息校验无误，则将新用户加入集合中
		if(state == 1){
			//格式化日期返回Date对象
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date dateBirthday = null;
			try {
				dateBirthday = format.parse(birthday);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			User newUser = new User(userName, password, dateBirthday, telNumber, email);
			if (!USER_DATA.add(newUser)){
				result.append("用户重复！");
				state = 2;
			}
			
			if (state == 1){
				result.append("注册成功");
			}
		}
		return result.toString();
	}
	
	
	
}
