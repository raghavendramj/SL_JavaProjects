package com.simplilearn.SpringBootDemo.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/demo/")
public class HelloController {

	@GetMapping("/hellospring")
	public String helloSpringBoot() {
		return "Hey Welcome to Spring Boot World!";
	}

	@GetMapping("/download")
	public ResponseEntity<InputStreamResource> downloadFile() throws IOException {
		String fileName = "raghav.txt";
		ClassLoader classLoader = new HelloController().getClass().getClassLoader();

		File file = new File(classLoader.getResource(fileName).getFile());

		InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
		HttpHeaders headers = new HttpHeaders();

		headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		headers.add("Pragma", "no-cache");
		headers.add("Expires", "0");

		ResponseEntity<InputStreamResource> responseEntity = ResponseEntity.ok().headers(headers)
				.contentLength(file.length()).contentType(MediaType.parseMediaType("application/txt")).body(resource);

		return responseEntity;
	}

}
