package com.ztesoft.zsmartcity.cc.user.service;

import com.ztesoft.zsmartcity.cc.user.dto.UserLogin;
import com.ztesoft.zsmartcity.cc.user.dto.UserLoginResp;

public interface IUserService {
	
	public UserLoginResp login(UserLogin userInfo);

}
