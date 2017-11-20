package com.plan.web.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {
	@RequestMapping("/login")
	public String index(Map<String, Object> model, HttpServletRequest request) {
		model.put("basePath", request.getContextPath());
		return "login";// 返回的内容就是templetes下面文件的名称
	}
}
