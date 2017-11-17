package com.plan.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloWorldController {
	private final Logger LOG = LoggerFactory.getLogger(HelloWorldController.class);

	@RequestMapping(value = "/test",method = RequestMethod.GET)
	public String getTest() {
		return "hello ! world ! springboot !";
	}

	@RequestMapping(value = "/l", method = RequestMethod.GET)
	public String testLogin() {
		LOG.info("test login method is go!");
		return "login";
	}

}
