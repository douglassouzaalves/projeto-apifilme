package br.com.projetox.v2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration //informando pro spring que é uma classe de configuração
@EnableSwagger2
public class SwaggerConfig {

    @Bean       //responsável por criar a página do Swagger
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.projetox"))
                .paths(regex("/v2/filmes.*"))
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo() {

        ApiInfo apiInfo = new ApiInfo(
                "API REST",
                "API REST de cadastro de filmes.",
                "2.0",
                "...",
                new Contact("Teste", "https://teste.com",
                        "teste@teste.com"),
                "Versão 2.0",
                "Teste...", new ArrayList<>()
        );

        return apiInfo;
    }

}
