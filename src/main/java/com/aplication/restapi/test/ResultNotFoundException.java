package com.aplication.restapi.test;

class ResultNotFoundException extends RuntimeException {

	  ResultNotFoundException(Long id) {
	    super("Could not find employee " + id);
	  }
	}