package com.plan.service.impl.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.plan.api.model.UserInfo;
import com.plan.api.user.IUserService;
import com.plan.service.mapper.user.UserMapper;

/**
 * 用户服务实现类
 * 
 * @author weizx
 * @date 2017-11-15
 *
 */
@Component
@Service(version="1.0.0")
public class UserServiceImpl implements IUserService {
	private final static Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserMapper userMapper;

	/*
	 * 登录方法实现 
	 */
	@Override
	public UserInfo login(UserInfo userInfo) {
		LOG.info("login methid begin params :{}" + userInfo);
		try {
			UserInfo user = userMapper.login(userInfo);
			return user;
		} catch (Exception e) {
			LOG.error("select DB error ! ", e);
			return null;
		}
	}

}
