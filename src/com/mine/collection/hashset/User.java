package com.mine.collection.hashset;

import java.util.Date;

public class User {
	private String useName; //用户名
	private String password; //密码
	private Date birthday; //生日
	private String telNumber; //手机号码
	private String email; //邮箱

	public User() {
	}
	
	public User(String useName, String password, Date birthday, String telNumber, String email) {
		this.useName = useName;
		this.password = password;
		this.birthday = birthday;
		this.telNumber = telNumber;
		this.email = email;
	}

	@Override
	public int hashCode() {
		return useName.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (useName == null) {
			if (other.useName != null)
				return false;
		} else if (!useName.equals(other.useName))
			return false;
		return true;
	}
	
	
}
