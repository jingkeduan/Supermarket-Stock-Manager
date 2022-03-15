package com.qa.products.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.products.domain.Products;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts= {"classpath.products-scheme.sql","classpath:products-data.sql"},executionPhase=Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("Test")
public class ProductsControllerTest {
	
	@Autowired
	private MockMvc mock;
	
	@Autowired
	private ObjectMapper map;
	
	@Test
	void testCreate() throws Exception {
		Products create=new Products("Banana","Fruits",100,1.50);
		String createJSON=this.map.writeValueAsString(create);
		RequestBuilder mockRequest=post("/create").contentType(MediaType.APPLICATION_JSON).content(createJSON);
		Products saved=new Products(3L,"Banana","Fruits",100,1.50);
		String savedJSON=this.map.writeValueAsString(saved);
		ResultMatcher matchStatus=status().isCreated();
		ResultMatcher matchBody=content().json(savedJSON);
		this.mock.perform(mockRequest).andExpect(matchBody).andExpect(matchStatus);
	}
	

}
