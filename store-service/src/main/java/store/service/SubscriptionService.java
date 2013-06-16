package store.service;


import org.springframework.beans.factory.annotation.Required;

import store.dao.UserDao;
import store.model.Address;
import store.model.User;
import store.model.dto.SubscribingUserDTO;


public class SubscriptionService {

	private UserDao userDao;
	
	public void storeUser(SubscribingUserDTO userSubscribeDTO ){
		
		User user = new User();
		user.setEmail(userSubscribeDTO.getEmail());
		user.setAddress(null);
		user.setFirstName(userSubscribeDTO.getFirstName());
		user.setLastName(userSubscribeDTO.getLastName());
		user.setPassword(userSubscribeDTO.getPassword());
		
		Address address = new Address();
		address.setNumber(userSubscribeDTO.getNumber());
		address.setStreet(userSubscribeDTO.getStreet());
		address.setTown(userSubscribeDTO.getTown());
		address.setCountry(userSubscribeDTO.getCountry());
		user.setAddress(address);
		
		userDao.store(user);
	}
	
	@Required
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
