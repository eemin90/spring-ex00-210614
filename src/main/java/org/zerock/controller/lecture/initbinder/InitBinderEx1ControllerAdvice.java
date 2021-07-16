package org.zerock.controller.lecture.initbinder;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

import lombok.extern.log4j.Log4j;

@ControllerAdvice
@Log4j
public class InitBinderEx1ControllerAdvice {

	@InitBinder
	public void method1() {
		log.info("advice method1");
	}
}
