package com.plan.web.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {
	private static final Logger LOG = LoggerFactory.getLogger(WebController.class);

	@RequestMapping("/login.html")
	public String login(Map<String, Object> model, HttpServletRequest request) {
		LOG.info("login method is go!");
		model.put("basePath", request.getContextPath());
		return "user/login";// 返回的内容就是templetes下面文件的名称
	}

	@RequestMapping("/register.html")
	public String register(Map<String, Object> model, HttpServletRequest request) {
		LOG.info("register method is go!");
		model.put("basePath", request.getContextPath());
		return "user/register";// 返回的内容就是templetes下面文件的名称
	}

	@RequestMapping("/")
	public String common(Map<String, Object> model, HttpServletRequest request) {
		LOG.info("common method is go! =="+ request.getContextPath()+"==");
		model.put("basePath", request.getContextPath());
		return "user/login";// 返回的内容就是templetes下面文件的名称
	}
}
