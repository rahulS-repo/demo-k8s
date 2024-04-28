package com.rahulsharma.demok8s;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/api")
@Slf4j
public class DemoK8sApplication {

	@GetMapping("/hello-app")
	public ResponseEntity<String> getData(){
		return ResponseEntity.status(HttpStatus.OK).body("Hi User. Welcome to our app!");
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoK8sApplication.class, args);
		log.info("Spring started.....");
	}

}
