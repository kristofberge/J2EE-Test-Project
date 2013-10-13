package com.example.j2eeapp.dao;

import javax.persistence.Query;

import org.springframework.util.Assert;

import com.example.j2eeapp.commons.dao.GenericJpaDao;
import com.example.j2eeapp.domain.UserEntity;

/**
 * Data access object interface to work with User entity database operations
 * 
 * @author Kristof
 * 
 */
public class UserJpaDao extends GenericJpaDao<UserEntity, Long> implements
		UserDao {

	public UserJpaDao() {
		super(UserEntity.class);
	}

	/**
	 * Queries database for user name availability.
	 * 
	 * @param userName
	 * @return true if available
	 */
	public boolean checkAvailable(String userName) {
		Assert.notNull(userName);
		
		Query query = getEntityManager().createQuery("select count(*) from " + getPersistentClass().getSimpleName() 
				+ " u where u.userName = :userName").setParameter("userName", userName);
		
		Long count = (Long) query.getSingleResult();
		return count < 1;
	}

	/**
	 * Queries user by userName.
	 * 
	 * @param userName
	 * @return
	 */
	public UserEntity loadUserByUserName(String userName) {
		Assert.notNull(userName);
		
		UserEntity user = null;
		
		Query query = getEntityManager().createQuery("select u from " + getPersistentClass().getSimpleName()
				 + " u where u.userName = :userName").setParameter("userName", userName);
		
		try {
			user = (UserEntity) query.getSingleResult();
		} catch (Exception e) {
			//do nothing
		}
	
		return user;
	}

}
