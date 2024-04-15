package com.rest.springrestapi.dao;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.slf4j.Logger;

import org.springframework.context.annotation.Configuration;

import com.rest.springrestapi.entity.Excursion;

@Configuration
public class LoadDatabase {
       private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(ExcursionRepository repository) {

    return args -> {
      log.info("Preloading " + repository.save(new Excursion("Museum Trip", "Munich",20)));

    };
  }
}
