package com.ztesoft.zsmartcity.cc.user.dao;

import java.util.List;

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


	
	public  UserInfo queryUserInfo(UserInfo user){
	
		List list = super.findAll("queryUser", user);
		if(list!=null&&list.size()>0){
			return (UserInfo)list.get(0);
		}
		return null;
		
	}

}
