package com.hhtc.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hhtc.po.Student;
import com.hhtc.service.GeneraService;
import com.hhtc.service.AdminService;
@Controller
public class StudentController {
	@Autowired
	private GeneraService generaService;
	private AdminService adminService;

	//学生
	@RequestMapping("/hrefscheduleinfo")
	public ModelAndView hrefscheduleinfo(Model model) {
		ModelAndView mav = new ModelAndView("student/scheduleinfo");
		return mav;
	}
	@RequestMapping("/hrefcourseinfo")
	public ModelAndView hrefcourseinfo(Model model) {
		ModelAndView mav = new ModelAndView("student/courseinfo");
		return mav;
	}
	@RequestMapping("/hrefstuinfo")
	public ModelAndView hrefstuinfo(Model model) {
		ModelAndView mav = new ModelAndView("student/stuinfo");
		return mav;
	}
	@RequestMapping("/hrefupdatepws")
	public ModelAndView hrefupdatepws(Model model) {
		ModelAndView mav = new ModelAndView("student/updatepws");
		return mav;
	}
	@RequestMapping("/updatepws")
	public ModelAndView updatepws(Student student,Model model) {
		this.generaService.updatepws(student);
		ModelAndView mav = new ModelAndView("success");
		return mav;
	}
	/*@RequestMapping("/hrefselectcourse")
	public ModelAndView hrefselectcourse(String kh,String Gh, String Xh,Model model) {
		System.out.println("KEHAO: " + kh);
		System.out.println("GONGHAO: " + Gh);
		System.out.println("XUEHAO: " + Xh);
		this.adminService.selectcourse("08305004", "101", "1101");
		ModelAndView mav = new ModelAndView("student/courseinfo");
		return mav;
	}*/
}
