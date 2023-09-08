package com.clinic.clinic.docs;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class OpenAPIConfig {
    @Value("${openapi.local-server-url}")
    private String localUrl;

    @Value("${openapi.production-server-url}")
    private String productionUrl;

    @Bean
    public OpenAPI openAPI() {
        Contact contact = new Contact();
        contact.setEmail("peralesvillanuevaemerson@gmail.com");
        contact.setName("David Emerson Perales Villanueva");

        License license = new License()
                .name("MIT License")
                .url("https://choosealicense.com/licenses/mit/");

        Info info = new Info()
                .title("ClinicApp")
                .version("1.0")
                .contact(contact)
                .description("This api exposes endpoits to manage users, schedules and appointments of a clinic.")
                .license(license);

        return new OpenAPI()
                .info(info)
                .servers(servers());
    }

    private List<Server> servers() {
        Server localServer = new Server();
        localServer.setUrl(localUrl);
        localServer.setDescription("Server url in local environment.");

        Server productionServer = new Server();
        productionServer.setUrl(productionUrl);
        productionServer.setDescription("Server url in production environment.");

        List<Server> servers = new ArrayList<>();
        servers.add(localServer);
        servers.add(productionServer);

        return servers;
    }
}
