package com.ebaolife.demo.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.ebaolife.demo.model.Person;

@Controller
@RequestMapping("/mvc")
public class HelloController {
	@RequestMapping("/hello")
	public String hello(){
		return "hello";
	}
	
	@RequestMapping("/person")
	public String toPerson(String name,int age){
		System.out.println("name="+name+",age="+age);
		return "hello";
	}
	
	@RequestMapping("/person1")
	public String toPerson(Person p){
		System.out.println(p.getName()+" "+p.getAge());
		return "hello";
	}
	
	@RequestMapping("/date")
	public String date(Date date){
	    System.out.println(date);
	    return "hello";
	}
	    
	//将String类型转化为Date类型
	@InitBinder
	public void initBinder(ServletRequestDataBinder binder){
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),
	            true));
	}
	
	@RequestMapping("/show")
	public String showPerson(Map<String,Object> map){
	    Person p =new Person();
	    map.put("p", p);
	    p.setAge(20);
	    p.setName("jayjay");
	    return "show";
	}
	
	@RequestMapping("/redirect")
	public String redirect(){
	    return "redirect:person?name=lxq&&age=12";
	}
	
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	public String upload(HttpServletRequest req) throws Exception{
	    MultipartHttpServletRequest mreq = (MultipartHttpServletRequest)req;
	    MultipartFile file = mreq.getFile("file");
	    String fileName = file.getOriginalFilename();
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	    String filepath = req.getSession().getServletContext().getRealPath("/")+
	            "upload\\"+sdf.format(new Date())+fileName.substring(fileName.lastIndexOf('.'));
	    FileOutputStream fos = new FileOutputStream(new File(filepath));
	    fos.write(file.getBytes());
	    fos.flush();
	    fos.close();
	     
	    return "hello";
	}
	
	/**
	 * 局部的异常处理
	 */
	
	@ExceptionHandler
	public ModelAndView exceptionHandler(Exception ex){
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("exception", ex);
		System.out.println("in testExceptionHandler");
		return mv;
	}
	
	@RequestMapping("/error")
	public String error(){
		int i = 5/0;
		return "hello";
	}
	
}
