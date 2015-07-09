package com.ztesoft.zsmartcity.cc.user.service;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ztesoft.zsmartcc.config.MessageUtils;
import com.ztesoft.zsmartcc.validate.core.NeedValidate;
import com.ztesoft.zsmartcity.cc.user.dao.IUserDao;
import com.ztesoft.zsmartcity.cc.user.dto.UserInfo;
import com.ztesoft.zsmartcity.cc.user.dto.UserLogin;
import com.ztesoft.zsmartcity.cc.user.dto.UserLoginResp;

@Service("userService")
public class UserService implements IUserService{
	
	private static final String LOGIN_SUCESS  = "0000";
	
	private static final String LOGIN_FAIL  = "0001";
	
	final static  Logger logger = LoggerFactory.getLogger(UserService.class);
	
	
	
	@Resource
	private IUserDao userDao;
	
	@NeedValidate
	public UserLoginResp login(UserLogin login){
		if(logger.isDebugEnabled()){
			logger.debug("input parameters:"+login.toString());
		}
		UserLoginResp resp = new UserLoginResp();
		UserInfo user = new UserInfo();
		user.setUserCode(login.getUserCode());
		user.setPwd(login.getPassword());
		UserInfo userInfo = userDao.queryUserInfo(user);
		if(userInfo !=null){
			resp.setRespCode(LOGIN_SUCESS);
			resp.setMsg(MessageUtils.getMessage(LOGIN_SUCESS));
			resp.setUserInfo(userInfo);
		}else{
			resp.setRespCode(LOGIN_FAIL);
			resp.setMsg(MessageUtils.getMessage(LOGIN_FAIL));
		}
		if(logger.isDebugEnabled()){
			logger.debug("output parameters:"+resp.toString());
		}
		return resp;
	}

}
