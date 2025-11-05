package com.hogwarts.inventoryservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

	    @Bean
	    public OpenAPI customOpenAPI() {
	        
	        Info info = new Info()
	                .title("API for Inventory Service")
	                .version("1.0.0")
	                .description("API documentation for my Inventory Service");

	        return new OpenAPI()
	                .info(info);
	    }	 
}
