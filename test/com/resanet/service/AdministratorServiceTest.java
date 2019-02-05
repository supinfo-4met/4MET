package com.resanet.service;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.zenika.supbook.service.AdministratorService;
import com.zenika.supbook.model.Administrator;

public class AdministratorServiceTest {
	@Test
	public void testCreate() {
		AdministratorService service = new AdministratorService();
		Administrator Administrator = new Administrator();
		Administrator.setLogin("John");
		Administrator.setPassword("Doe");
		service.create(Administrator);
		Assert.assertNotNull(Administrator.getId());
		Assert.assertTrue(0 != Administrator.getId());
	}
	
	@Test
	public void testFindAll() {
		AdministratorService service = new AdministratorService();
		List<Administrator> result = service.findAll();
		Assert.assertTrue(result.size() > 0);
	}
	
	@Test
	public void testReadById() {
		AdministratorService service = new AdministratorService();
		Administrator emptyResult = service.readById(0L);
		Assert.assertNull(emptyResult);
		
		Administrator validResult = service.readById(2L);
		Assert.assertNotNull(validResult);
	}
	
	@Test
	public void testDelete() {
		AdministratorService service = new AdministratorService();
		boolean emptyDelete = service.delete(0L);
		Assert.assertFalse(emptyDelete);
		
		boolean validDelete = service.delete(2L);
		Assert.assertTrue(validDelete);
	}
	
	@Test
	public void testUpdate() {
		AdministratorService service = new AdministratorService();
		Administrator notExistingAdministrator = new Administrator(0, "Scott", "Tiger2");
		boolean emptyUpdate = service.update(notExistingAdministrator);
		Assert.assertFalse(emptyUpdate);
		
		Administrator existingAdministrator = new Administrator(3, "Scott", "Tiger2");
		boolean validUpdate = service.update(existingAdministrator);
		Assert.assertTrue(validUpdate);
	}
}
