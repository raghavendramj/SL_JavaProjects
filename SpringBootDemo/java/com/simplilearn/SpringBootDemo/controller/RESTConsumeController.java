package com.simplilearn.SpringBootDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.simplilearn.SpringBootDemo.beans.Todo;

@Controller
public class RESTConsumeController {

	@RequestMapping("/")
	@ResponseBody
	public String index() {
		RestTemplate restTemplate = new RestTemplate();
		Todo oneTodo = restTemplate.getForObject("https://jsonplaceholder.typicode.com/todos/1", Todo.class);
		return oneTodo.toString();
	}
}
