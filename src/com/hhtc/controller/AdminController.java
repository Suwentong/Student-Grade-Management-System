package com.hhtc.controller;
import java.util.List;
import javax.servlet.http.HttpSession;

import com.hhtc.po.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hhtc.service.AdminService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
@Controller
public class AdminController {
	@Autowired
		private AdminService adminService;
	@RequestMapping("/welcome")
	public ModelAndView welcome(Model model) {
		ModelAndView mav = new ModelAndView("admin/welcome");
		return mav;
	}
	//课程
	//课程数据分页
	@RequestMapping(value = "/listcourse",method = {RequestMethod.POST, RequestMethod.GET},produces ="application/json;charset=UTF-8")
	@ResponseBody
	public String listcourse(Page page) {
		List<Course> list=adminService.coursemanage();
		page.caculatestart();
		List<Course> list2=adminService.listcourse(page);
		JSONObject jsonobj=new JSONObject();
		jsonobj.put("code", 0);
		jsonobj.put("msg", "成功");
		jsonobj.put("count",list.size());
		JSONArray jsonobj2=new JSONArray();
		JSONObject jsonobj3=new JSONObject();
		for(Course course:list2) {
			jsonobj3.put("kh",course.getKh());
			jsonobj3.put("km",course.getKm());
			jsonobj3.put("xf",course.getXf());
			jsonobj3.put("xs",course.getXs());
			jsonobj3.put("yxh",course.getYxh());
			jsonobj2.add(jsonobj3);
		}
		jsonobj.put("data", jsonobj2);
		return jsonobj.toString();
	}
	//选课课程数据分页
	@RequestMapping(value = "/selectedcourse",method = {RequestMethod.POST, RequestMethod.GET},produces ="application/json;charset=UTF-8")
	@ResponseBody
	public String selectedcourse(String kh, String Xh, Page page) {
		System.out.println("XUEHAO: " + Xh);
		List<Course> list=adminService.selectedcourse(Xh);
		//page.caculatestart();
		//List<Course> list2=adminService.listcourse(page);
		JSONObject jsonobj=new JSONObject();
		jsonobj.put("code", 0);
		jsonobj.put("msg", "成功");
		jsonobj.put("count",list.size());
		JSONArray jsonobj2=new JSONArray();
		JSONObject jsonobj3=new JSONObject();
		for(Course course:list) {
			jsonobj3.put("kh",course.getKh());
			jsonobj3.put("km",course.getKm());
			jsonobj3.put("xf",course.getXf());
			jsonobj3.put("yxh",course.getYxh());
			jsonobj3.put("xm",course.getXm());
			jsonobj2.add(jsonobj3);
		}
		jsonobj.put("data", jsonobj2);
		return jsonobj.toString();
	}
	@RequestMapping(value = "/coursescore",method = {RequestMethod.POST, RequestMethod.GET},produces ="application/json;charset=UTF-8")
	@ResponseBody
	public String coursescore(String Xh, Page page) {
		List<Course> list=adminService.coursescore(Xh);
		//page.caculatestart();
		//List<Course> list2=adminService.listcourse(page);
		JSONObject jsonobj=new JSONObject();
		jsonobj.put("code", 0);
		jsonobj.put("msg", "成功");
		jsonobj.put("count",list.size());
		JSONArray jsonobj2=new JSONArray();
		JSONObject jsonobj3=new JSONObject();
		for(Course course:list) {
			jsonobj3.put("kh",course.getKh());
			jsonobj3.put("km",course.getKm());
			jsonobj3.put("pscj",course.getPscj());
			jsonobj3.put("kscj",course.getKscj());
			jsonobj3.put("zpcj",course.getZpcj());
			jsonobj2.add(jsonobj3);
		}
		jsonobj.put("data", jsonobj2);
		return jsonobj.toString();
	}
	//学生
		//学生数据分页
		@RequestMapping(value = "/liststudent",method = {RequestMethod.POST, RequestMethod.GET},produces ="application/json;charset=UTF-8")
		@ResponseBody
		public String liststudent(Page page) {
			List<Student> list=adminService.stumanage();
			page.caculatestart();
			List<Student> list2=adminService.liststudent(page);
			JSONObject jsonobj=new JSONObject();
			jsonobj.put("code", 0);
			jsonobj.put("msg", "成功");
			jsonobj.put("count",list.size());
			JSONArray jsonobj2=new JSONArray();
			JSONObject jsonobj3=new JSONObject();
		    for(Student student:list2) {
		    	jsonobj3.put("Xh",student.getXh());
		    	jsonobj3.put("xm",student.getXm());
				jsonobj3.put("xb",student.getXb());
				jsonobj3.put("csrq",student.getCsrq());
				jsonobj3.put("jg",student.getJg());
		    	jsonobj3.put("sjhm",student.getSjhm());
				jsonobj3.put("yxh",student.getYxh());
				jsonobj3.put("Zt",student.getZt());
				jsonobj3.put("logn",student.getLogn());
				jsonobj3.put("pswd",student.getPswd());
		    	jsonobj2.add(jsonobj3);
		    }
		    jsonobj.put("data", jsonobj2);		
			return jsonobj.toString();
		}
		@RequestMapping("/addstudent")
		public ModelAndView addstu(Student student,Model model) {
			adminService.addStudent(student);
			ModelAndView mav = new ModelAndView("admin/stumanage");
			return mav;
		}
		@RequestMapping("/delstu")
		public ModelAndView delstu(String id,Model model) {
			adminService.delstudnet(id);
			ModelAndView mav = new ModelAndView("admin/stumanage");
			return mav;
		}
		@RequestMapping("/updatestu")
		public ModelAndView updatestu(String xh, Student student, Model model) {
			//System.out.println("XUEHAO: " + xh);
			//System.out.println("XUEHAO: " + xh);
			student.setXh(Integer.parseInt(xh));
			//student.setXh(Xh);
			adminService.updatestu(student);
			ModelAndView mav = new ModelAndView("admin/stumanage");
			return mav;
		}
		@RequestMapping(value = "/mohuname",method = {RequestMethod.POST, RequestMethod.GET},produces ="application/json;charset=UTF-8")
		@ResponseBody
		public String mohuname(HttpSession session) {
			@SuppressWarnings("unchecked")
			List<Student> list=(List<Student>) session.getAttribute("list");
			JSONObject jsonobj=new JSONObject();
			jsonobj.put("code", 0);
			jsonobj.put("msg", "成功");
			jsonobj.put("count",list.size());
			JSONArray jsonobj2=new JSONArray();
			JSONObject jsonobj3=new JSONObject();
		    for(Student student:list) {
		    	//jsonobj3.put("id",student.getId());
		    	//jsonobj3.put("username",student.getUsername());
		    	//jsonobj3.put("password",student.getPassword());
		    	//jsonobj3.put("stuclass",student.getStuclass());
		    	//jsonobj3.put("stuname",student.getStuname());
		    	//jsonobj3.put("stuno",student.getStuno());
		    	jsonobj2.add(jsonobj3);
		    }
		    jsonobj.put("data", jsonobj2);		
			return jsonobj.toString();
		}
	//老师
		@RequestMapping("/addtea")
		public ModelAndView addteacher(Teacher teacher,Model model) {
			adminService.addteacher(teacher);
			ModelAndView mav = new ModelAndView("admin/teamanage");
			return mav;
		}
		@RequestMapping(value = "/teamanage",method = {RequestMethod.POST, RequestMethod.GET},produces ="application/json;charset=UTF-8")
		@ResponseBody
		public String teamanage(Model model) {
			List<Teacher> list=adminService.teamanage();
			JSONObject jsonobj=new JSONObject();
			jsonobj.put("code", 0);
			jsonobj.put("msg", "成功");
			jsonobj.put("count",list.size());
			JSONArray jsonobj2=new JSONArray();
			JSONObject jsonobj3=new JSONObject();
		    for(Teacher teacher:list) {
		    	jsonobj3.put("Gh",teacher.getGh());
		    	jsonobj3.put("xm",teacher.getXm());
		    	jsonobj3.put("xb",teacher.getXb());
		    	jsonobj3.put("csrq",teacher.getCsrq());
				jsonobj3.put("Zc",teacher.getZc());
				jsonobj3.put("jbgz",teacher.getJbgz());
				jsonobj3.put("yxh",teacher.getYxh());
				jsonobj3.put("logn",teacher.getLogn());
				jsonobj3.put("pswd",teacher.getPswd());
		    	jsonobj2.add(jsonobj3);
		    }
		    jsonobj.put("data", jsonobj2);		
			return jsonobj.toString();
		}
		@RequestMapping("/deltea")
		public ModelAndView deltea(String id,Model model) {
			adminService.delteacher(id);
			ModelAndView mav = new ModelAndView("admin/teamanage");
			return mav;
		}
		@RequestMapping("/updatetea")
		public ModelAndView updatetea(String gh,Teacher teacher,Model model) {
			teacher.setGh(Integer.parseInt(gh));
			adminService.updatetea(teacher);
			ModelAndView mav = new ModelAndView("admin/teamanage");
			return mav;
		}
		@RequestMapping(value = "/mohunametea",method = {RequestMethod.POST, RequestMethod.GET},produces ="application/json;charset=UTF-8")
		@ResponseBody
		public String mohunametea(HttpSession session) {
			@SuppressWarnings("unchecked")
			List<Teacher> list=(List<Teacher>) session.getAttribute("tealist");
			JSONObject jsonobj=new JSONObject();
			jsonobj.put("code", 0);
			jsonobj.put("msg", "成功");
			jsonobj.put("count",list.size());
			JSONArray jsonobj2=new JSONArray();
			JSONObject jsonobj3=new JSONObject();
		    for(Teacher teacher:list) {
		    	//jsonobj3.put("id",teacher.getId());
		    	//jsonobj3.put("username",teacher.getUsername());
		    	//jsonobj3.put("password",teacher.getPassword());
		    	//jsonobj3.put("teaname",teacher.getTeaname());
		    	jsonobj2.add(jsonobj3);
		    }
		    jsonobj.put("data", jsonobj2);		
			return jsonobj.toString();
		}
		@RequestMapping("/hrefselectcourse")
		public ModelAndView hrefselectcourse(String kh,String Gh, String Xh,Model model) {
			adminService.selectcourse(kh, Gh, Xh);
			ModelAndView mav = new ModelAndView("student/courseinfo");
			return mav;
		}
		@RequestMapping("/dropcourse")
		public ModelAndView dropcourse(String kh,String Xh,Model model) {
			adminService.dropcourse(kh, Xh);
			ModelAndView mav = new ModelAndView("student/scheduleinfo");
			return mav;
		}
}
