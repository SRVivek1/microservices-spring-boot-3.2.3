package com.srvivek.sboot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenApiSwaggerConfiguration {

	@Bean
	OpenAPI openApiConfig() {

		final Server server1 = new Server();
		server1.setUrl("http://localhost:8080/");
		
		final Server server2 = new Server();
		server2.setUrl("http://localhost:9080/");
		
		final List<Server> servers = new ArrayList<>();
		servers.add(server1);
		servers.add(server2);
		
		return new OpenAPI()
				.info(new Info().title("User service API Info title").description("User service API info Description")
						.version("1.0.0").contact(new Contact().name("@srvivek1").email("srvivek@test.com").url("http://localhost:8080/")))
				.externalDocs(new ExternalDocumentation().description("User service, API Docs.")
						.url("htpp://localhost:8080/v3/api-docs")).servers(servers);
	}
}
