package com.hhtc.controller;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hhtc.po.Student;
import com.hhtc.po.Teacher;
import com.hhtc.service.AdminService;
@Controller
public class HrefController {
	@Autowired
	private AdminService adminService;
	@RequestMapping("/index")
	public ModelAndView index(Model model) {
		ModelAndView mav = new ModelAndView("index");
		return mav;
	}
	//学生
	@RequestMapping("/hrefaddstu")
	public ModelAndView addstu(Model model) {
		ModelAndView mav = new ModelAndView("admin/addstu");
		return mav;
	}
	@RequestMapping("/hrefmohuname")
	public ModelAndView hrefmohuname(String stuname,Model model,HttpSession session) {
		List<Student> list=adminService.selectbyname(stuname);
		session.setAttribute("list", list);
		ModelAndView mav = new ModelAndView("admin/mohuname");
		return mav;
	}
	@RequestMapping("/hrefxiustu")
	public String xiustu(String Xh,Model model) {
		Student student=adminService.selectone(Xh);
		model.addAttribute("student",student);
		//System.out.println("XUEHAO: " + student.getXh());
		return "admin/updatestu";
	}
	@RequestMapping("/hrefstumanage")
	public ModelAndView hrefstumanage(Model model) {
		ModelAndView mav = new ModelAndView("admin/stumanage");
		return mav;
	}
//老师
	@RequestMapping("/hrefaddtea")
	public ModelAndView hrefaddtea(Model model) {
		ModelAndView mav = new ModelAndView("admin/addtea");
		return mav;
	}
	@RequestMapping("/hrefteamanage")
	public ModelAndView hrefteamanage(Model model) {
		ModelAndView mav = new ModelAndView("admin/teamanage");
		return mav;
	}
	@RequestMapping("/hrefmohunametea")
	public ModelAndView hrefmohunametea(String xm,Model model,HttpSession session) {
		List<Teacher> list=adminService.selectbynametea(xm);
		session.setAttribute("tealist",list);
		ModelAndView mav = new ModelAndView("admin/mohuname2");
		return mav;
	}
	@RequestMapping("/hrefxiutea")
	public String hrefxiutea(String Gh,Model model) {
		Teacher teacher=adminService.selectonetea(Gh);
		model.addAttribute("teacher",teacher);
		return "admin/updatetea";
	}
}
