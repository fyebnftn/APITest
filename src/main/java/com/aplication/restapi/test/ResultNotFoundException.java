package com.aplication.restapi.test;

class ResultNotFoundException extends RuntimeException {

	  ResultNotFoundException(Long id) {
	    super("No se encontró el empleado " + id);
	  }
	}