package com.init.app.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.init.app.dto.Product;
import com.init.app.service.ServiceListSimilar;


@RestController
@RequestMapping("/product")
public class ControllerListSimilar {

	@Autowired
	private ServiceListSimilar serviceListSimilar;
	
	@GetMapping(value = "/list/{id}")
	public ResponseEntity<?> listProducts(@PathVariable int id) throws IOException, InterruptedException {
		try {
			Product[] productsSimilar=serviceListSimilar.listSimilarProducts(id);
			return new ResponseEntity<Product[]>(productsSimilar,HttpStatus.OK);
		} catch (NotFoundException notFoundException) {
			String response="Product not found whith id "+ id;
			return new ResponseEntity<String>(response, HttpStatus.NOT_FOUND);
		}catch(Exception e) {
			return new ResponseEntity<>( HttpStatus.CONFLICT);
		}
		
		
	}
	
}
