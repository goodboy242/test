package com.shlee.web.domain;

public class LoginVO {
	private String userId;
	private String userName;
	private String loginDate;

	@Override
	public String toString() {
		return "LoginVO [userId=" + userId + ", userName=" + userName + ", loginDate=" + loginDate + "]";
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(String loginDate) {
		this.loginDate = loginDate;
	}

}
