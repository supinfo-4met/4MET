package com.resanet.service;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.zenika.supbook.model.User;
import com.zenika.supbook.service.UserService;

public class UserServiceTest {
	@Test
	public void testCreate() {
		UserService service = new UserService();
		User user = new User();
		user.setLogin("CrazyUser2");
		user.setEmail("crazy.user2@somewhere.com");
		service.create(user);
		Assert.assertNotNull(user.getId());
		Assert.assertTrue(0 != user.getId());
	}
	
	@Test
	public void testFindAll() {
		UserService service = new UserService();
		List<User> result = service.findAll();
		Assert.assertTrue(result.size() > 0);
	}
	
	@Test
	public void testReadById() {
		UserService service = new UserService();
		User emptyResult = service.readById(0L);
		Assert.assertNull(emptyResult);
		
		User validResult = service.readById(3L);
		Assert.assertNotNull(validResult);
	}
	
	@Test
	public void testDelete() {
		UserService service = new UserService();
		boolean emptyDelete = service.delete(0L);
		Assert.assertFalse(emptyDelete);
		
		boolean validDelete = service.delete(3L);
		Assert.assertTrue(validDelete);
	}
	
	@Test
	public void testUpdate() {
		UserService service = new UserService();
		User notExistingUser = new User(0, "CrazyUser1", "crazy.user@somewhere.com");
		boolean emptyUpdate = service.update(notExistingUser);
		Assert.assertFalse(emptyUpdate);
		
		User existingUser = new User(1, "CrasyUser2", "crazy.user2@somewhere.com");
		boolean validUpdate = service.update(existingUser);
		Assert.assertTrue(validUpdate);
	}
}
