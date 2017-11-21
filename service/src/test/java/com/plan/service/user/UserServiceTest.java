package com.plan.service.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.plan.api.model.UserInfo;
import com.plan.api.user.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-application-context.xml" })
public class UserServiceTest {
	private static final Logger LOG = LoggerFactory.getLogger(UserServiceTest.class);

	@Autowired
	private IUserService userService;

	@Test
	public void testLogin() {
		LOG.info("test login for user service begin ...");
		UserInfo user = new UserInfo();
		user.setLoginName("admin");
		user.setLoginPwd("admin");
		UserInfo u = userService.Login(user);
		if (u == null) {
			LOG.error("login error , user is not exists !");
		} else {
			LOG.info("login success !");
		}
		LOG.info("END TEST LOGIN...");

	}
}
