package org.zerock.controller.lecture.rest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.controller.lecture.domain.User;


@RestController
@RequestMapping("/rest05")
public class Ex05RestController {

	@RequestMapping("/sub01")
	public User method01(@RequestBody User user) {
		
		return user;
	}
}
