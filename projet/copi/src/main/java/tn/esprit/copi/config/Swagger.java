package tn.esprit.copi.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Swagger {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Copi Application")
                        .description("Gestion des cartes de poker")
                        .contact(new Contact()
                                .name("GhDev")
                                .email("*************@esprit.tn")
                                .url("https://www.linkedin.com/in//")));
    }


    @Bean
    public GroupedOpenApi pokerApi() {
        return GroupedOpenApi.builder()
                .group("Poker API")
                .pathsToMatch( "/pokercards/**") // Assurez-vous que le chemin correspond à votre contrôleur
                .build();
    }
    @Bean
    public GroupedOpenApi onlineSessionApi() {
        return GroupedOpenApi.builder()
                .group("Online Session API")
                .pathsToMatch("/online-sessions/**") // Chemin pour le contrôleur des sessions en ligne
                .build();
    }
    @Bean
    public GroupedOpenApi SessionPartipiantApi() {
        return GroupedOpenApi.builder()
                .group("Session Participant API")
                .pathsToMatch("/session-participants/**") // Chemin pour le contrôleur des sessions en ligne
                .build();
    }

    @Bean
    public GroupedOpenApi pokerResultApi() {
        return GroupedOpenApi.builder()
                .group("Poker Result API")
                .pathsToMatch("/poker-results/**")
                .build();
    }
}
