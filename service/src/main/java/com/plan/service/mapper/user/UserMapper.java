package com.plan.service.mapper.user;

import com.plan.api.model.UserInfo;

/**
 * 用户mapper
 * @author wing
 *
 */
public interface UserMapper {
	UserInfo login(UserInfo userInfo);
}
