package com.kuro.hrwebapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.Data;

@Data
@SpringBootApplication
public class HrWebAppApplication implements CommandLineRunner {

	@Autowired
	private CustomProperties properties;

	public static void main(String[] args) {
		SpringApplication.run(HrWebAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("API URL : " + properties.getApiUrl());
		System.out.println("Site URL : http://localhost:9001");
	}

}