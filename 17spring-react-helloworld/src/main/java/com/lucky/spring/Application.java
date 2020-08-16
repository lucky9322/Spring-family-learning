package com.lucky.spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    public void run(String... args) throws Exception {
        //generateStyle();
        fromIterableStyle();
    }

    private void generateStyle() {
        Flux<String> generate = Flux.generate(() -> 0, (state, sink) -> {
            sink.next("3 x " + state + " = " + 3 * state);
            if (state == 5) {
                sink.complete();
            }
            return state + 1;
        });
        generate.toStream().forEach(g -> {
            System.out.println(g);
        });
    }

    private void fromIterableStyle() {
        List<String> words = Arrays.asList("th", "qu");
        Flux<String> manyLetters = Flux.fromIterable(words)
                .flatMap(word -> {
                    System.out.println("step1=" + word);
                    return Flux.fromArray(word.split(""));
                })
                .filter(s -> {
                    System.out.println("step2=" + s);
                    return true;
                })
                .filter(s -> {
                    System.out.println("step3=" + s);
                    return true;
                });
        manyLetters.subscribe(s -> System.out.println("result=" + s));
    }
}
