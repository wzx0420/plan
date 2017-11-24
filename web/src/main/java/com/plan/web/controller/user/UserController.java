package com.plan.web.controller.user;

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

	@PostMapping(value = WebConstants.SUBMIT_LOGIN, produces = "application/json;charset=UTF-8")
	public UserInfo login(@RequestBody UserInfo user) {
		LOG.info("login method is go! params :{}", user);
		if (userService == null) {
			LOG.error("dubbo registration error ! userService is null !");
			return null;
		}
		UserInfo users = userService.login(user);
		LOG.info("userService login method result :{}" + users);
		return users;
	}
}
