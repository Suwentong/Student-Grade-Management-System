package com.hhtc.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hhtc.po.Page;
import com.hhtc.po.Student;
import com.hhtc.po.Teacher;
import com.hhtc.service.AdminService;
import com.hhtc.service.GeneraService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
@Controller
public class TeachController {
	@Autowired
	private AdminService adminService;
	@Autowired
	private GeneraService generaService;
	@RequestMapping("/hrefaddscore")
	public ModelAndView hrefaddscore(Model model) {
		ModelAndView mav = new ModelAndView("teacher/addscore");
		return mav;
	}
	@RequestMapping("/hrefupdatepw")
	public ModelAndView hrefupdatepw(Model model) {
		ModelAndView mav = new ModelAndView("teacher/updatepw");
		return mav;
	}
	@RequestMapping(value = "/stuscore",method = {RequestMethod.POST, RequestMethod.GET},produces ="application/json;charset=UTF-8")
	@ResponseBody
	public String stuscoree(String Gh, Page page,Model model) {
		List<Student> list=adminService.stuscoree(Gh);
		//page.caculatestart();
		//List<Student> list2=adminService.liststudent(page);
		JSONObject jsonobj=new JSONObject();
		jsonobj.put("code", 0);
		jsonobj.put("msg", "成功");
		jsonobj.put("count",list.size());
		JSONArray jsonobj2=new JSONArray();
		JSONObject jsonobj3=new JSONObject();
	    for(Student student:list) {
	    	jsonobj3.put("Xh",student.getXh());
	    	jsonobj3.put("xm", student.getXm());
	    	jsonobj3.put("km",student.getKm());
	    	jsonobj3.put("pscj",student.getPscj());
	    	jsonobj3.put("kscj",student.getKscj());
			jsonobj3.put("zpcj",student.getZpcj());
			jsonobj3.put("pjjd",student.getPjjd());
	    	jsonobj2.add(jsonobj3);
	    }
	    jsonobj.put("data", jsonobj2);		
		return jsonobj.toString();
	}
	@RequestMapping("/updatepw")
	public ModelAndView updatepw(Teacher teacher,Model model) {
		this.generaService.updatepw(teacher);
		ModelAndView mav = new ModelAndView("success");
		return mav;
	}
	@RequestMapping("/updatepscj")
	public ModelAndView updatepscj(String Xh,String km,String score,Model model) {
		this.generaService.updatepscj(Xh,km,score);
		ModelAndView mav = new ModelAndView("teacher/addscore");
		return mav;
	}
	@RequestMapping("/updatekscj")
	public ModelAndView updatekscj(String Xh,String km,String score,Model model) {
		this.generaService.updatekscj(Xh,km,score);
		ModelAndView mav = new ModelAndView("teacher/addscore");
		return mav;
	}@RequestMapping("/updatezpcj")
	public ModelAndView updatezpcj(String Xh,String km,String score,Model model) {
		this.generaService.updatezpcj(Xh,km,score);
		ModelAndView mav = new ModelAndView("teacher/addscore");
		return mav;
	}
}
