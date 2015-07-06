package com.ztesoft.zsmartcity.cc.user.dao;

import java.util.Hashtable;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ztesoft.zsmartcity.cc.framework.dao.AbstractDAO;
import com.ztesoft.zsmartcity.cc.user.dto.UserInfo;

@Repository("userDAO")
public class UserDao extends AbstractDAO implements IUserDao { 
	
	@Override
	public String getMbatisMapperNamesapce() {
		// TODO Auto-generated method stub
		return "zsmart.cc.user";
	}


	private static final String QUERY_USER_INFO = "select user_name,user_code,pwd from CCS_USER t where user_code= :user_code and pwd= :pwd";
	
	public  UserInfo getUserInfo(UserInfo user){
		Map params = new Hashtable();
		
		return (UserInfo)super.selectOne("queryUser", user);
		
	}

}
