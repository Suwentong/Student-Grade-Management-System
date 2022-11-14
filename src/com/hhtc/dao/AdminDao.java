package com.hhtc.dao;
import java.util.List;

import com.hhtc.po.*;

public interface AdminDao {
	//课程
	public List<Course> coursemanage();
	public List<Course> selectedcourse(String Xh);
	public List<Course> coursescore(String Xh);
	public List<Course> listcourse(Page page);
	//学生
	public void addStudent(Student student);
	public Student selectone(String Xh);
	public List<Student> stumanage();
	public void delstudnet(String id);
	public void updatestu(Student student);
	public List<Student> selectbyname(String stuname);
	public List<Student> liststudent(Page page);

	public List<Student> stuscoree(String Gh);
	public void selectcourse(String kh,String Gh, String Xh);
	public void dropcourse(String kh,String Xh);
	//老师
	public void addteacher(Teacher teacher);
	public Teacher selectonetea(String Gh);
	public List<Teacher> teamanage();
	public void delteacher(String id);
	public void updatetea(Teacher teacher);
	public List<Teacher> selectbynametea(String xm);
}
