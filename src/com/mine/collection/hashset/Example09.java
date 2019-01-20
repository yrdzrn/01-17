package com.mine.collection.hashset;

import java.util.HashSet;

/**
 * 用HashSet存储学生信息，重写hascode()和equals()方法
 * @author 25868
 *
 */
public class Example09 {
	public static void main(String[] args) {
		HashSet<Student> hs = new HashSet<Student> ();
		Student stu1 = new Student ("1", "Jack");
		Student stu2 = new Student ("2", "Rose");
		Student stu3 = new Student ("2", "Rose");
		hs.add(stu1);
		hs.add(stu2);
		hs.add(stu3);
		System.out.println(hs);
	}
}
