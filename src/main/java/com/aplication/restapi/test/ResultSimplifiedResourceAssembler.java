package com.aplication.restapi.test;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
class ResultSimplifiedResourceAssembler implements RepresentationModelAssembler<ResultSimplified, EntityModel<ResultSimplified>> {

  @Override
  public EntityModel<ResultSimplified> toModel(ResultSimplified result) {

    return new EntityModel<>(result,
      linkTo(methodOn(ResultSimplifiedController.class).one(result.getId())).withSelfRel(),
      linkTo(methodOn(ResultSimplifiedController.class).all()).withRel("resultSimplified"));
  }
  
}