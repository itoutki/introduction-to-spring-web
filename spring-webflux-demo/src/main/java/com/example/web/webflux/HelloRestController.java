package com.example.web.webflux;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Date;

@RestController
public class HelloRestController {
    @GetMapping("/hellorest")
    public Mono<String> handleHelloRest() {
        String message = "Hello, Spring WebFlux!";
        return Mono.just(message);
    }

    @GetMapping("/interval")
    public Flux<Message> handleInterval() {
        return Flux.interval(Duration.ofSeconds(1))
                .take(5)
                .map(l -> new Message(new Date().toString()));
    }

    class Message {
        String message;

        public Message(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
