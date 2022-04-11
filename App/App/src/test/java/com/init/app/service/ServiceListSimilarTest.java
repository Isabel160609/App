package com.init.app.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import com.init.app.dto.Product;


@SpringBootTest()
@Import(ServiceListSimilar.class)
class ServiceListSimilarTest {

	@Autowired 
	private ServiceListSimilar serviceListSimilar;

	@Test
	void listSimilarProductsTest() throws Exception   {
		int id=1;
		 
		Product product2=new Product(2,"Dress",19.99,true);
		Product product3=new Product(3,"Blazer",29.99,false);
		Product product4=new Product(4,"Boots",39.99,true);
		Product [] expected=new Product[]{product2,product3,product4};
		Product [] resoult=serviceListSimilar.listSimilarProducts(id);
		assertEquals(expected.length,resoult.length);
	}

	@Test
	void GiveProductTest() throws Exception{
		
		int id=2;
		Product expected=new Product(2,"Dress",19.99,true);
		Product resoult = serviceListSimilar.GiveProduct(id);
		assertEquals(expected.getId(),resoult.getId());
		assertEquals(expected.getName(),resoult.getName());
		assertEquals(expected.getPrice(),resoult.getPrice());
		assertEquals(expected.isAvailability(),resoult.isAvailability());
	}
	
}

