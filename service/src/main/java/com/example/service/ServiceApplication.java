package com.example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@SpringBootApplication
public class ServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceApplication.class, args);
    }

}

@Controller
@ResponseBody
class GreetingsService {

	private final Logger log = LoggerFactory.getLogger(getClass());
	
    @GetMapping("/service")
	Map<String, String> message() {
		this.log .info("received a new request!") ;
        return Map.of("message", "Hello World");
    }
}