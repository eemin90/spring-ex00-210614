package org.zerock.controller.lecture;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.controller.lecture.domain.User;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/ex08/*")
@Log4j
public class Ex08Controller {
	
	@RequestMapping("/sub01")
	public void method01(Model model) {
		log.info("ex08, sub01 method");
		
		model.addAttribute("name", "donald");
		model.addAttribute("age", 22);
	}
	
	@RequestMapping("/sub02")
	public void method02(Model model) {
		log.info("ex08, sub02 method");
		
		User user = new User();
		user.setId("bts");
		user.setAge(32);
		
		model.addAttribute("user", user);
	}
	
	@RequestMapping("/sub03")
	public String method03(Model model) {
		log.info("ex08, sub03 method");
		
		User user = new User();
		user.setId("korea");
		user.setAge(5000);
		
//		model.addAttribute("user", user);
		model.addAttribute(user); // attribute name을 생략하면 해당 class의 소문자명이 들어온다 (위 코드와 같다)
		
		return "ex08/sub02";
	}
	
	@RequestMapping("/sub04")
	public String method04(User user, Model model) {
		log.info("ex08, sub04 method");
		
		model.addAttribute("user", user);
		
		return "ex08/sub02";
	}
	
	@RequestMapping("/sub05")
	public String method05(@ModelAttribute("user") User user, Model model) {
		log.info("ex08, sub05 method");
		
		return "ex08/sub02";
	}
	
	@RequestMapping("/sub06")
	public String method06(@ModelAttribute User user, Model model) { // attribute name을 생략하면 해당 타입의 소문자명이 들어온다 (위 코드와 같다). 기본 자료형에는 불가
		log.info("ex08, sub06 method");
		
		return "ex08/sub02";
	}
	
	@RequestMapping("/sub07")
	public String method07(User user, Model model) { // @ModelAttribute와 addAttribute()를 생략해도 위 코드와 같다
		log.info("ex08, sub07 method");
		
		return "ex08/sub02";
	}
	
	@RequestMapping("/sub08")
	public String method08(User user, Model model) {
		log.info("ex08, sub07 method");
		
		model.addAttribute("hello world"); // attribute name(여기서는 String 타입)이 생략되어 view에서는 ${string}으로 값을 읽을 수 있다
		
		return "ex08/sub02";
	}
	
	@RequestMapping("/sub09")
	public String method09(User user) { // Model 타입과 값을 생략해도 View에서 값을 가져오는 것이 가능하다
		log.info("ex08, sub09 method");
		
		return "ex08/sub02";
	}
	
	@RequestMapping("/sub10")
//	public void method10(@RequestParam int age, @RequestParam String name) { // @RequestParam 생략 가능
	public void method10(@ModelAttribute("age") int age,  @ModelAttribute("name") String name) {
		log.info("ex08, sub10 method");
		
		log.info(age);
		log.info(name);
	}
	
}
