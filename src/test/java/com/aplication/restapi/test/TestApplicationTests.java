package com.aplication.restapi.test;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;

@SpringBootTest
class TestApplicationTests {

	@Autowired
	packageSearchRepository repository;
	@Autowired
	ResultSimplifiedResourceAssembler assembler;

	void contextLoads() {
	}
	
    private final static String INPUT_CA = "ca";
    private final static String INPUT_ES = "es";
    private final static String INPUT_EN = "en";
    private final static String INPUT_OTHER = "fr";
    private final static String INPUT_NUMBER = "1";
    
    private ResultSimplifiedController resultSimplifiedController;
 
    @Test
    public void shouldReturnInputString() {
    	resultSimplifiedController = new ResultSimplifiedController(repository,assembler);
    	CollectionModel<EntityModel<ResultSimplified>> resultSimplified = resultSimplifiedController.all();
      assertThat(resultSimplified, notNullValue());
    }
    
    @Test
    public void shouldReturnInputStringforLanguages() {
    resultSimplifiedController = new ResultSimplifiedController(repository,assembler);
      CollectionModel<EntityModel<ResultSimplified>> resultSimplified = resultSimplifiedController.allLang(INPUT_CA);
      assertThat(resultSimplified, notNullValue());
      resultSimplified = resultSimplifiedController.allLang(INPUT_ES);
      assertThat(resultSimplified, notNullValue());
      resultSimplified = resultSimplifiedController.allLang(INPUT_EN);
      assertThat(resultSimplified, notNullValue());
      resultSimplified = resultSimplifiedController.allLang(INPUT_OTHER);
      assertThat(resultSimplified, notNullValue());
      
      resultSimplified = resultSimplifiedController.allLang(INPUT_NUMBER);
      assertThat(resultSimplified, notNullValue());
    }
    


}
