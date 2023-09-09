package com.clinic.clinic.docs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;
import java.util.List;

@Configuration
public class OpenAPIConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .securitySchemes(Collections.singletonList(new BasicAuth("basicAuth")))
                .securityContexts(Collections.singletonList(securityContext()));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("ClinicApp API")
                .description("This api exposes endpoits to manage users, schedules and appointments of a clinic.")
                .version("1.0.0")
                .license("MIT License")
                .licenseUrl("https://choosealicense.com/licenses/mit/")
                .contact(contact())
                .build();
    }

    private Contact contact(){
        return new Contact(
                "EmersonDinosaur",
                "https://emersonDinosaurPortfolio.com",
                "emersonDinosaur@gmail.com"
        );
    }

    private SecurityContext securityContext() {
        return SecurityContext
                .builder()
                .securityReferences(defaultAuth())
                .build();
    }

    private List<SecurityReference> defaultAuth(){
        AuthorizationScope[] authorizationScopes = {
                new AuthorizationScope("global", "accessEverything")
        };

        return Collections.singletonList(
                new SecurityReference("basicAuth", authorizationScopes)
        );
    }
}
