package com.ztesoft.zsmartcity.cc.user.dao;

import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.ztesoft.zsmartcc.jdbc.core.GenericJdbcDAO;
import com.ztesoft.zsmartcity.cc.user.dto.UserInfo;

@Repository("userDAO")
public class UserDao implements IUserDao { 
	@Autowired
	@Qualifier("ccGenericJdbcDAO")
	private GenericJdbcDAO genericJdbcDAO;
	private static final String QUERY_USER_INFO = "select user_name,user_code,pwd from CCS_USER t where user_code= :user_code and pwd= :pwd";
	
	public  UserInfo queryUserInfo(UserInfo user){
		Map params = new Hashtable();
		params.put("user_code", user.getUserCode());
		params.put("pwd", user.getPwd());
		return genericJdbcDAO.queryForBean(QUERY_USER_INFO, params, UserInfo.class);
		
	}

}
