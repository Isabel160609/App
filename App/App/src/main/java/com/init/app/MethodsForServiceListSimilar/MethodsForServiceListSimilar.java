package com.init.app.MethodsForServiceListSimilar;

import com.google.gson.Gson;
import com.init.app.dto.ListSimilar;
import com.init.app.dto.Product;

public class MethodsForServiceListSimilar {



	public static ListSimilar[] convertStringToArrayInt(String testString) throws Exception {


		ListSimilar[] listSimilar;
		try {
			int[] listId = new Gson().fromJson(testString, int[].class);

			 listSimilar = new ListSimilar[listId.length];
			for (int i = 0; i < listId.length; i++) {
				listSimilar[i] = new ListSimilar(listId[i]);

			}
		} catch (Exception e) {
			throw new Exception();
		}
		
		return listSimilar;
	}

	public static Product readjson(String message) throws Exception {

		Product product = new Product();
		try {

			product = new Gson().fromJson(message, Product.class);
			 if(product.getName().isEmpty()) {
				 throw new Exception();
			  }
		} catch (Exception ex) {
			throw new Exception("Error in the introduction of the json.");
		}

		return product;
	}

}
