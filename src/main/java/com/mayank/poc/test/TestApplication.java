package com.mayank.poc.test;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class TestApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}

	@Override
	public void run(String[] args){

		// ComplexJsonToObjectMappingExample.convert();
	}
}
