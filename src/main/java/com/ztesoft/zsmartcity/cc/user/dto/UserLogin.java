package com.ztesoft.zsmartcity.cc.user.dto;

import java.io.Serializable;

public class UserLogin implements Serializable{
	
	private String userCode;
	
	private String password;

	

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String toString (){
		return "userCode="+userCode+"	password="+password;
	}
	
	
	
	

}
