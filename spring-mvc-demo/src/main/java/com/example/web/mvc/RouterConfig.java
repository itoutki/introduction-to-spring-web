package com.example.web.mvc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.RouterFunctions;
import org.springframework.web.servlet.function.ServerResponse;

@Configuration
public class RouterConfig {
    @Bean
    RouterFunction<?> routerFunction() {
        return RouterFunctions.route()
                .GET("/hellorestfn",
                        request -> ServerResponse.ok().body("Hello, Spring MVC.fn!"))
                .build();
    }
}
