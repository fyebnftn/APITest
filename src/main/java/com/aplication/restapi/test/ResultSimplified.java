package com.aplication.restapi.test;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.aplication.restapi.test.remoteApi.UrlTornada;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
@Entity
class ResultSimplified {

  private @Id @GeneratedValue Long id;
  private String code;
  private String url;
  private @JsonIgnore @OneToOne(cascade = {CascadeType.ALL}) Url urlSet;
  private String organization_description;

  ResultSimplified() {}

  ResultSimplified(String code, UrlTornada url, String organization_description) {
    this.code = code;
    this.urlSet = new Url(url);
    this.organization_description = organization_description;
  }

}