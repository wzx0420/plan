package com.plan.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("test")
public class HelloWorldController {

	@RequestMapping(method = RequestMethod.GET)
	public String getTest() {
		return "hello ! world ! springboot !";
	}
}
