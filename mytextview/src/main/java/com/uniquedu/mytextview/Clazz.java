package com.uniquedu.mytextview;

import java.util.List;

public class Clazz {
	private String clazzName;
	private String clazzNum;
	private List<Student> students;
	public String getClazzName() {
		return clazzName;
	}
	public void setClazzName(String clazzName) {
		this.clazzName = clazzName;
	}
	public String getClazzNum() {
		return clazzNum;
	}
	public void setClazzNum(String clazzNum) {
		this.clazzNum = clazzNum;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public Clazz(String clazzName, String clazzNum, List<Student> students) {
		this.clazzName = clazzName;
		this.clazzNum = clazzNum;
		this.students = students;
	}
	public Clazz() {
	}
	
}
