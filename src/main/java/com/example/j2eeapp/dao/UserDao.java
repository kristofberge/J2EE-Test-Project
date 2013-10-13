package com.example.j2eeapp.dao;

import com.example.j2eeapp.commons.dao.GenericDao;
import com.example.j2eeapp.domain.UserEntity;

/**
 * Data access object interface to work with User entity database operations
 * 
 * @author Kristof
 *
 */
public interface UserDao extends GenericDao<UserEntity, Long>{

	/**
	 * Queries database for user name availability.
	 * 
	 * @param userName
	 * @return true if available
	 */
	boolean checkAvailable(String userName);
	
	/**
	 * Queries user by userName.
	 * 
	 * @param userName
	 * @return
	 */
	UserEntity loadUserByUserName(String userName);
}
