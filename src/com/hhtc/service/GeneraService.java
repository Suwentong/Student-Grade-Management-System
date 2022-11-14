package com.hhtc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hhtc.dao.GeneraDao;
import com.hhtc.po.Student;
import com.hhtc.po.Teacher;
@Component
public class GeneraService {
	@Autowired
	private GeneraDao generaDao;
	public void updatepw(Teacher teacher) {
		this.generaDao.updatepw(teacher);
	}
	public void updatepscj(String Xh,String km,String score) {
		this.generaDao.updatepscj(Xh,km,score);
	}
	public void updatekscj(String Xh,String km,String score) {
		this.generaDao.updatekscj(Xh,km,score);
	}
	public void updatezpcj(String Xh,String km,String score) {
		this.generaDao.updatezpcj(Xh,km,score);
	}
	public void updatepws(Student student) {
		this.generaDao.updatepws(student);
	}
}
