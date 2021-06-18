package org.zerock.controller.lecture;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/ex06/*")
@Log4j
public class Ex06Controller {
	
	@RequestMapping("/sub01")
	public String method01() {
		log.info("ex06, sub01 method");
		
		/* 이전 servlet의 코드로 치면 아래와 같다
		request.getRequestDispatcher("/WEB-INF/views/ex06/sub01.jsp").forward(request, response);
		 */
		
		return "ex06/sub01";
		
		/*
		/WEB-INF/views/ex06/sub01.jsp 경로를 찾는다
		 */
	}
	
	@RequestMapping("/sub02")
	public void method02() {
		log.info("ex06, sub02 method");
	}
	
	@RequestMapping("/sub03")
	public String method03() {
		log.info("ex06, sub03 method");
		
		// response.sendRedirect(request.getContextPath() + "/ex06/sub02");
		
		return "forward:/ex06/sub02";
	}
}
