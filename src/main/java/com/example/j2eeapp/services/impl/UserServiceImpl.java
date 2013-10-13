package com.example.j2eeapp.services.impl;

import com.example.j2eeapp.dao.UserDao;
import com.example.j2eeapp.domain.UserEntity;
import com.example.j2eeapp.services.UserService;

/**
 * Service providing service methods to work with user data and entity. 
 * 
 * @author Kristof
 *
 */
public class UserServiceImpl implements UserService {
	
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/**
	 * Create user - persist to database
	 * 
	 * @param userEntity
	 * @return true if success
	 */
	@Override
	public boolean createUser(UserEntity userEntity) {
		userDao.save(userEntity);
		return true;
	}

	
}
