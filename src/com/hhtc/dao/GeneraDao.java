package com.hhtc.dao;
import com.hhtc.po.Student;
import com.hhtc.po.Teacher;
public interface GeneraDao {
	public void updatepw(Teacher teacher);
	public void updatepscj(String Xh,String km,String score);
	public void updatekscj(String Xh,String km,String score);
	public void updatezpcj(String Xh,String km,String score);
	public void updatepws(Student student);
}
