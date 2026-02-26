package br.org.obspegadadigital.api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Observatório de Pegada Digital - API")
                        .version("v2024.05.002")
                        .description("Sistema de Auditoria e Rastreabilidade de Emissões de CO2 " +
                                "evitadas através da desmaterialização digital."));
    }
}
