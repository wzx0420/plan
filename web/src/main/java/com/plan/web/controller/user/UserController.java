package com.plan.web.controller.user;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.plan.api.model.UserInfo;
import com.plan.api.user.IUserService;
import com.plan.web.common.WebConstants;

@RestController
@RequestMapping(WebConstants.USER)
public class UserController {
	private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

	@Reference(version = "1.0.0", timeout = 3000)
	private IUserService userService;

	@PostMapping(WebConstants.SUBMIT_LOGIN)
	public Map<String, String> login(@RequestBody UserInfo user) {
		LOG.info("login method is go! params{}", user);
		UserInfo userInfo = new UserInfo();
		userInfo.setLoginName("admin");
		userInfo.setLoginPwd("admin");

		Map<String, String> map = new HashMap<>();
		map.put("k", "I am king of the world !");
		// userInfo.setLoginName(model.get("loginName") + "");
		// userInfo.setLoginPwd(model.get("loginPwd") + "");
		if (userService == null) {
			LOG.error("dubbo registration error ! userService is null");
			return null;
		}
		user = userService.login(userInfo);
		LOG.info("userService login method result :{}" + user);
		return map;
		// return userService.login(userInfo);
	}
}
