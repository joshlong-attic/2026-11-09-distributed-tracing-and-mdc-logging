package com.example.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestClient;

@SpringBootApplication
public class ClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

}

@Controller
@ResponseBody
class ClientController {
	
	
	// important: use an autoconfigured RestClient!
    private final RestClient http;

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	
    ClientController(RestClient.Builder http) {
        this.http = http.build();
    }

    @GetMapping("/client")
    String call() {
		this.logger.info("calling the service");
        return this.http.get()
                .uri("http://localhost:8081/service")
                .retrieve()
                .body(String.class);
    }
}