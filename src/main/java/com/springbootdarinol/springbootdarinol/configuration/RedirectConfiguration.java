package com.springbootdarinol.springbootdarinol.configuration;

import static java.net.URI.create;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.temporaryRedirect;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class RedirectConfiguration {

  @Bean
  RouterFunction<ServerResponse> routerSwagger() {
    return route(GET("/"), this::swaggerDefaultPath)
        .andRoute(GET("/favicon.ico"), this::swaggerDefaultPath)
        .andRoute(GET("/docs"), this::swaggerDefaultPath)
        .andRoute(GET("/v3/api-docs"), this::swaggerDefaultPath);
  }
  private Mono<ServerResponse> swaggerDefaultPath(ServerRequest sr) {
    return temporaryRedirect(create("/swagger-ui/")).build();
  }
}
