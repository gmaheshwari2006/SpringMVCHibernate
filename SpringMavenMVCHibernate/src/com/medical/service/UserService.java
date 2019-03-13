package com.medical.service;

import com.medical.entity.UserEntity;

public interface UserService {

	void saveOrUpdateUser(UserEntity userEntity);

	public UserEntity fetchUserByUserName(String userName);

}
