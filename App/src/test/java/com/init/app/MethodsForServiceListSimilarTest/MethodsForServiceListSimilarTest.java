package com.init.app.MethodsForServiceListSimilarTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.init.app.MethodsForServiceListSimilar.MethodsForServiceListSimilar;
import com.init.app.dto.ListSimilar;
import com.init.app.dto.Product;

@SpringBootTest(classes = MethodsForServiceListSimilarTest.class)
class MethodsForServiceListSimilarTest {

	@Test
	void convertStringToArrayIntTest() throws Exception {
		String test = "[2,3,4]";
		ListSimilar[] expected = { new ListSimilar(2), new ListSimilar(3), new ListSimilar(4) };
		ListSimilar[] result = MethodsForServiceListSimilar.convertStringToArrayInt(test);
		assertEquals(expected[0].getProductId(), result[0].getProductId());
		assertEquals(expected[1].getProductId(), result[1].getProductId());
		assertEquals(expected[2].getProductId(), result[2].getProductId());
		assertEquals(expected.length, result.length);
	}

	@Test
	
	void convertStringToArrayIntFailTest()  {
		  try {
			  String test = "Hello";
				ListSimilar[] result = MethodsForServiceListSimilar.convertStringToArrayInt(test);
		        fail("No exception caught :()");
		    }
		    catch (Exception ex) {
		        assertEquals(Exception.class, ex.getClass());
		       
		    }
	}

	@Test
	void readjsonTest() throws Exception {
		String json = "{\"id\":\"1\",\"name\":\"Shirt\",\"price\":9.99,\"availability\":true}";

		Product expected = new Product(1, "Shirt", 9.99, true);
		Product resoult = MethodsForServiceListSimilar.readjson(json);
		assertEquals(expected.getId(), resoult.getId());
		assertEquals(expected.getName(), resoult.getName());
		assertEquals(expected.getPrice(), resoult.getPrice());
		assertEquals(expected.isAvailability(), resoult.isAvailability());
	}

	@Test
	void readjsonFailTest()  {
		  try {
			  String json = "1";
			  Product resoult = MethodsForServiceListSimilar.readjson(json);
			  fail("No exception caught :()");

		    }
		    catch (Exception ex) {
		        assertEquals(Exception.class, ex.getClass());
		       
		    }
	}
}
