package com.ofamy.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/hello")
public class HelloController {

	@RequestMapping(value="/")
	public String sayHello(@RequestParam(defaultValue="Foulen") String name){
		return "Hello "+name ;
	}
}
