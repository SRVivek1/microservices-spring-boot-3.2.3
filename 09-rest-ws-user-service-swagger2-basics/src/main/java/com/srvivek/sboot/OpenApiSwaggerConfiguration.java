package com.srvivek.sboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiSwaggerConfiguration {

	@Bean
	OpenAPI openApiConfig() {
		return new OpenAPI()
				.info(new Info().title("User service API Info title").description("User service API info Description")
						.version("1.0.0"))
				.externalDocs(new ExternalDocumentation().description("User service, API Docs.")
						.url("htpp://localhost:8080/v3/api-docs"));
	}
}
