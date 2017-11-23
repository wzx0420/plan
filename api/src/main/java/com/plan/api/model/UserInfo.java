package com.plan.api.model;

import java.util.Date;

/**
 * 用户模型
 * 
 * @author weizx
 * @date 2017-11-15
 */
public class UserInfo implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer userId;
	private String userName;
	private String loginName;
	private String loginPwd;
	private Date createTime;
	private Date loginOutTime;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginPwd() {
		return loginPwd;
	}

	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLoginOutTime() {
		return loginOutTime;
	}

	public void setLoginOutTime(Date loginOutTime) {
		this.loginOutTime = loginOutTime;
	}

}
