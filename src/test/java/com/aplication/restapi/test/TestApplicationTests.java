package com.aplication.restapi.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;

@SpringBootTest
class TestApplicationTests {

	@Test
	void contextLoads() {
	}
	
    private final static String INPUT_CA = "ca";
    private final static String INPUT_ES = "es";
    private final static String INPUT_EN = "en";
    private final static String INPUT_OTHER = "au";
    private final static String INPUT_NUMBER = "1";
    
    private final ResultSimplifiedController resultSimplifiedController = new ResultSimplifiedController(null, null);
 
    @Test
    public void shouldReturnInputString() {
      //final CollectionModel<EntityModel<ResultSimplified>> resultSimplified = resultSimplifiedController.all();
      //assertThat(resultSimplified, notNullValue());
      
    }

}
