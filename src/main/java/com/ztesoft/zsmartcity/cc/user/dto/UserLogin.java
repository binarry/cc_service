package com.ztesoft.zsmartcity.cc.user.dto;

import java.io.Serializable;

import com.ztesoft.zsmartcc.validate.annotations.NotNull;
import com.ztesoft.zsmartcc.validate.annotations.Password;
import com.ztesoft.zsmartcc.validate.annotations.ValidateEntity;
@ValidateEntity
public class UserLogin implements Serializable{
	
	@NotNull
	private String userCode;
	
	@NotNull
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
	
	
	
	

}
