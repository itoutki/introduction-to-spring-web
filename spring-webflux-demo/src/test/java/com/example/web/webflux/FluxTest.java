package com.example.web.webflux;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FluxTest {

    @Test
    public void testStream() {
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> output = input.stream()
                .filter(i -> i % 2 == 0)
                .map(i -> i * 2)
                .collect(Collectors.toList());

        System.out.println(output);
    }

    @Test
    public void testFlux() {
        Flux<Integer> input = Flux.just(1, 2, 3, 4, 5);
        Flux<Integer> output = input
                .filter(i -> i % 2 == 0)
                .map(i -> i * 2);

        output.subscribe(i -> System.out.println(i));
    }

    @Test
    public void testFluxInterval() throws Exception {
        Flux.interval(Duration.ofSeconds(1))
                .take(5)
                .map(l -> LocalDateTime.now())
                .subscribe(d -> System.out.println(d));

        Thread.sleep(10000);
    }

    @Test
    public void testMono() throws Exception {
        Mono.just("Reactor Mono")
                .map(str -> String.format("Hello, %s!", str))
                .subscribe(System.out::println);

    }
}
