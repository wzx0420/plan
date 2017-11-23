package com.plan.api.user;

import com.plan.api.entity.UserInfo;

public interface IUserService {
	UserInfo login(UserInfo userInfo);
}
