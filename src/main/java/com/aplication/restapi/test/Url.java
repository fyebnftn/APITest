package com.aplication.restapi.test;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.aplication.restapi.test.remoteApi.UrlTornada;
@Data
@Entity
class Url {

  private @Id @GeneratedValue Long id;
  private String es;
  private String ca;
  private String en;

  Url() {}

  Url(String ca, String es, String en) {
    this.ca = ca;
    this.es = es;
    this.en = en;
  }
  Url(UrlTornada url) {
	    this.ca = url.getCa();
	    this.es = url.getEs();
	    this.en = url.getEn();
	  }
  public String getLang(String lang)
  {
	  switch(lang) {
	  case "ca":
		  return ca;
	  case "es":
		  return es;
	  case "en":
		  return en;
	  default:
		  return ca;
	  }
  }
}

