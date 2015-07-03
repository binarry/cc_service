package com.ztesoft.zsmartcity.cc.user.dto;

import java.io.Serializable;




public class UserInfo implements Serializable{

	private String userName;
	 
	
	private String pwd;
	
	
	private String userCode;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	
	
	
	
	
	

}
