package com.hhtc.service;
import java.util.List;

import com.hhtc.po.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hhtc.dao.AdminDao;

@Component
public class AdminService {
	@Autowired
	private AdminDao adminDao;
	//课程
	public List<Course> listcourse(Page page){
		return this.adminDao.listcourse(page);
	}
	public List<Course> coursemanage() { return this.adminDao.coursemanage(); }
	public List<Course> selectedcourse(String Xh) { return this.adminDao.selectedcourse(Xh); }
	public List<Course> coursescore(String Xh) {
		return this.adminDao.coursescore(Xh);
	}
	//学生
	//分页
	public List<Student> liststudent(Page page){
		return this.adminDao.liststudent(page);
	}
	public void addStudent(Student student) {
		this.adminDao.addStudent(student);
	}
	public Student selectone(String Xh) {
		return adminDao.selectone(Xh);
	};
	public List<Student> stumanage() {
		return this.adminDao.stumanage();
	}
	public void delstudnet(String id) {
		this.adminDao.delstudnet(id);
	}
	public void updatestu(Student student) {
		this.adminDao.updatestu(student);
	};
	public List<Student> selectbyname(String stuname){
		return this.adminDao.selectbyname(stuname);
	}

	public List<Student> stuscoree(String Gh){
		return this.adminDao.stuscoree(Gh);
	}
	public void selectcourse(String kh,String Gh, String Xh) { this.adminDao.selectcourse(kh,Gh,Xh);}
	public void dropcourse(String kh,String Xh) { this.adminDao.dropcourse(kh,Xh);}
	
	//老师
	public void addteacher(Teacher teacher) {
		this.adminDao.addteacher(teacher);
	};
	public Teacher selectonetea(String Gh) {
		return this.adminDao.selectonetea(Gh);
	}
	public List<Teacher> teamanage(){
		return this.adminDao.teamanage();
	}
	public void delteacher(String id){
		this.adminDao.delteacher(id);
	}
	public void updatetea(Teacher teacher) {
		this.adminDao.updatetea(teacher);
	};
	public List<Teacher> selectbynametea(String xm){
		return this.adminDao.selectbynametea(xm);
	}
}