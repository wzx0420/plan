package com.plan.api.user;

import com.plan.api.model.UserInfo;

public interface IUserService {
	UserInfo login(UserInfo userInfo);
}
