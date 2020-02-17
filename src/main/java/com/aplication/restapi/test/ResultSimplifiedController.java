package com.aplication.restapi.test;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.CollectionModel;

@RestController
class ResultSimplifiedController {

	private final packageSearchRepository repository;
	private final ResultSimplifiedResourceAssembler assembler;

	  ResultSimplifiedController(packageSearchRepository repository,
			  ResultSimplifiedResourceAssembler assembler) {

	    this.repository = repository;
	    this.assembler = assembler;
	  }

  // Aggregate root


	@GetMapping("/resultSimplified")
	  CollectionModel<EntityModel<ResultSimplified>> all() {

		List<EntityModel<ResultSimplified>> results = repository.findAll().stream()
			      .map(result ->
			      {
			    	  result.setUrl(result.getUrlSet().getLang("ca"));
			    	  return assembler.toModel(result);
			      }
			      	)
			      .collect(Collectors.toList());

	    return new CollectionModel<>(results,
	      linkTo(methodOn(ResultSimplifiedController.class).all()).withSelfRel());
	  }
	
	
	
	 @GetMapping("/resultSimplified/{id}")
	  EntityModel<ResultSimplified> one(@PathVariable Long id) {

		 ResultSimplified result = repository.findById(id)
	      .orElseThrow(() -> new ResultNotFoundException(id));

	    return assembler.toModel(result);
	  }
	 
	
	@GetMapping("/resultSimplifiedbyLang/{lang}")
	  CollectionModel<EntityModel<ResultSimplified>> allLang(@PathVariable String lang) {
		List<EntityModel<ResultSimplified>> results = repository.findAll().stream()
	      .map(result ->
	      {
	    	  result.setUrl(result.getUrlSet().getLang(lang));
	    	  return assembler.toModel(result);
	      }
	      	)
	      .collect(Collectors.toList());

	    return new CollectionModel<>(results,
	      linkTo(methodOn(ResultSimplifiedController.class).all()).withSelfRel());
	  }
}
