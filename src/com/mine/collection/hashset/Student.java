package com.mine.collection.hashset;

public class Student {
	private String id;
	private String name;
	public Student(String id, String name) {
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Stuent [id=" + id + ", name=" + name + "]";
	}
	@Override
	public int hashCode() {
		return id.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj){
			return true;
		}
		if (!(obj instanceof Student)){
			return false;
		}
		Student stu = (Student)obj;
		boolean b = this.id.equals(stu.id);
		return b;
	}
}
