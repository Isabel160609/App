package com.init.app.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.init.app.MethodsForServiceListSimilar.MethodsForServiceListSimilar;
import com.init.app.dto.ListSimilar;
import com.init.app.dto.Product;

@Service
public class ServiceListSimilar {

	// private String BASE_URL = "http://localhost:3001";
	private String BASE_URL = "http://simulado:80";
	
	public Product[] listSimilarProducts(int id) throws Exception {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(BASE_URL + "/product/" + id + "/similarids")).GET().build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		if(response.statusCode()==HttpStatus.NOT_FOUND.value()) {
			throw new NotFoundException();
		}
		String body = response.body();

		ListSimilar[] listSimilars = MethodsForServiceListSimilar.convertStringToArrayInt(body);
		
		Product[] products = new Product[listSimilars.length];

		for (int i = 0; i < listSimilars.length; i++) {
			Product product = GiveProduct(listSimilars[i].getProductId());
			products[i] = product;
		}

		return products;
	}
	


	public Product GiveProduct(int productId) throws Exception {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(BASE_URL + "/product/" +  productId)).GET()
				.build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		String stringSimilars = response.body();

		Product product = MethodsForServiceListSimilar.readjson(stringSimilars);

		return product;

	}

}
