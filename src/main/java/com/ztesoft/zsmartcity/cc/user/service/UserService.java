package com.ztesoft.zsmartcity.cc.user.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ztesoft.zsmartcity.cc.user.dao.IUserDao;
import com.ztesoft.zsmartcity.cc.user.dto.UserInfo;
import com.ztesoft.zsmartcity.cc.user.dto.UserLogin;
import com.ztesoft.zsmartcity.cc.user.dto.UserLoginResp;

@Service("userService")
public class UserService implements IUserService{
	
	
	
	@Resource
	private IUserDao userDao;
	
	public UserLoginResp login(UserLogin login){
		UserLoginResp resp = new UserLoginResp();
		UserInfo user = new UserInfo();
		user.setUserCode(login.getUserCode());
		user.setPwd(login.getPassword());
		UserInfo userInfo = userDao.queryUserInfo(user);
		if(userInfo !=null){
			resp.setRespCode("0000");
			resp.setUserInfo(userInfo);
		}else{
			resp.setRespCode("0001");
		}
		return resp;
	}

}
