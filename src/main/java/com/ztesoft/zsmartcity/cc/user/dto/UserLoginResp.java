package com.ztesoft.zsmartcity.cc.user.dto;

import java.io.Serializable;

public class UserLoginResp implements Serializable{
	
	private String respCode;
	
	private String msg;
	
	private UserInfo userInfo;

	public String getRespCode() {
		return respCode;
	}

	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	
	

}
