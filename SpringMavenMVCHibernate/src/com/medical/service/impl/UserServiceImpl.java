package com.medical.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.medical.dac.UserDac;
import com.medical.entity.UserEntity;
import com.medical.service.UserService;


@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDac userDac;
	
	

	public UserDac getUserDac() {
		return userDac;
	}



	public void setUserDac(UserDac userDac) {
		this.userDac = userDac;
	}



	@Override
	@Transactional
	public void saveOrUpdateUser(UserEntity userEntity) {
		userDac.saveOrUpdateUser(userEntity);
		
	}



	@Override
	@Transactional(readOnly = false, isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED)
	public UserEntity fetchUserByUserName(String userName) {
		return userDac.fetchUserByUserName(userName);
	}

}
