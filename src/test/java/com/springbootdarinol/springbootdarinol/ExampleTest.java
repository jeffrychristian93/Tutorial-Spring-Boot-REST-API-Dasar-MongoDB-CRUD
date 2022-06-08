package com.springbootdarinol.springbootdarinol;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ExampleTest {

  @Test
  void name() {
    final List<Integer> rooms = Arrays.asList(1, 2, 3, 4, 5);

    Flux.fromIterable(rooms)
        .flatMap(data -> {
          if (data % 2 == 0) {
            return Mono.empty();
          }
          return Mono.just(data);
        })
        .collectList()
        .doOnNext(n -> {
          System.out.println(n);
        })
        .subscribe();

  }
}
