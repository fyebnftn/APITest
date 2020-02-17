package com.aplication.restapi.test;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;
import com.aplication.restapi.test.remoteApi.PackageSearch;
import com.aplication.restapi.test.remoteApi.Result_;

@Configuration
@Slf4j
class LoadDatabase {

  @Bean
  CommandLineRunner initDatabase(packageSearchRepository repository) {
	  RestTemplate restTemplate = new RestTemplate();
	  PackageSearch packageSearch = restTemplate.getForObject(
				"https://opendata-ajuntament.barcelona.cat/data/api/3/action/package_search", PackageSearch.class);
	  for (Result_ result:packageSearch.getResult().getResults())
	  {
		  repository.save(new ResultSimplified(result.getCode(), result.getUrlTornada(), result.getOrganization().getDescription()));
	  }
	  return args -> {
      log.info("Loaded "+repository.count()+" results");
    };
  }
}