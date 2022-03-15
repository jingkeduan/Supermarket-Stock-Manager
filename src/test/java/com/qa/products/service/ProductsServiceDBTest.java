package com.qa.products.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.qa.products.domain.Products;
import com.qa.products.repo.ProductsRepo;

@SpringBootTest
@ActiveProfiles("test")
public class ProductsServiceDBTest {
	
	@Autowired
	private ProductsServiceDB service;
	
	@MockBean
	private ProductsRepo repo;
	
	private List<Products> inputList;
	private List<Products> returnList;
	private Products a1;
	private Products a2;
	private Products a1r;
	private Products a2r;
	
	@BeforeEach
	void setUp() {
		a1=new Products("Apple","Fruits",200,1.75);
		a2=new Products("Grapes","Fruits",200,2.50);
		inputList=List.of(a1,a2);
		
		a1r=new Products(1L,"Apple","Fruits",200,1.75);
		a2r=new Products(2L,"Grapes","Fruits",200,2.50);
		returnList=List.of(a1r,a2r);
	}
	
	@Test
	void testCreate() {
		Mockito.when(this.repo.save(this.a1)).thenReturn(this.a1r);
		assertThat(this.service.create(this.a1)).isEqualTo(this.a1r);
		Mockito.verify(this.repo,Mockito.times(1)).save(this.a1);
	}
	
	@Test
	void testReadById() {
		final Long id=1L;
		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(this.a1r));
		assertThat(this.service.readById(id)).isEqualTo(this.a1r);
		Mockito.verify(this.repo,Mockito.times(1)).findById(id);	
	}
	
	@Test
	void testReadAll() {
		Mockito.when(this.repo.findAll()).thenReturn(this.returnList);
		assertThat(this.service.readAll()).isEqualTo(this.returnList);
		Mockito.verify(this.repo,Mockito.times(1)).findAll();
	}
	

}
