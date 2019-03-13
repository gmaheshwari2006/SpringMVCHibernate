package com.medical.dac;

import com.medical.entity.UserEntity;

public interface UserDac {
	public UserEntity fetchUser(Long id);
	public void saveOrUpdateUser(UserEntity userEntity);
	public UserEntity fetchUserByUserName(String userName); 
}
