package com.plan.web.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {
	@RequestMapping("/index")
	public String index(Map<String, Object> model) {
		model.put("name", "adam");
		return "index";// 返回的内容就是templetes下面文件的名称
	}
}
