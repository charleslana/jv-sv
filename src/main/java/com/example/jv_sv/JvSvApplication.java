package com.example.jv_sv;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;

@SpringBootApplication
public class JvSvApplication {

	public static void main(String[] args) {
		SpringApplication.run(JvSvApplication.class, args);
	}

	@Bean
	public OpenAPI customOpenApi(@Value("${app.version}") String appVersion,
			@Value("${app.description}") String appDescription) {
		return new OpenAPI().components(new Components())
				.info(new io.swagger.v3.oas.models.info.Info().title("Server API")
						.version(appVersion)
						.description(appDescription)
						.license(new License().name("Server by Charles Lana")
								.url("https://github.com/charleslana")));
	}

}
