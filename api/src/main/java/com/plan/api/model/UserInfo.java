package com.plan.api.model;

import java.util.Date;

/**
 * 用户模型
 * 
 * @author weizx
 * @date 2017-11-15
 */
public class UserInfo {
	private Integer userId;
	private String userName;
	private String loginName;
	private char[] loginPwd;
	private Date createTime;
	private Date loginOutTime;
}
