package com.init.app.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.init.app.dto.Product;
import com.init.app.service.ServiceListSimilar;


@SpringBootTest(classes= {ControllerListSimilarTest .class})
class ControllerListSimilarTest {

	@Mock 
	ServiceListSimilar serviceListSimilar;
	
	@InjectMocks
	ControllerListSimilar controllerListSimilar;
	
	@Test
	void listProductsTest() throws Exception {
		Product product2=new Product(2,"Dress",19.99,true);
		Product product3=new Product(3,"Blazer",29.99,false);
		Product product4=new Product(4,"Boots",39.99,true);
		int i=1;
		Product [] products=new Product[]{product2,product3,product4};
		when(serviceListSimilar.listSimilarProducts(i)).thenReturn(products);
		ResponseEntity<Product[]> response=(ResponseEntity<Product[]>) controllerListSimilar.listProducts(1);
		assertEquals(HttpStatus.OK,response.getStatusCode());
		assertEquals(Product.class,response.getBody().getClass());
		assertEquals(products.length,response.getBody().length);
	}

}
