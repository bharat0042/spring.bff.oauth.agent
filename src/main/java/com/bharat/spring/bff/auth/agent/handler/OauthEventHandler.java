package com.bharat.spring.bff.auth.agent.handler;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class OauthEventHandler {
  public Mono<ServerResponse> login(ServerRequest serverRequest) {
    return null;
  }

  public Mono<ServerResponse> callback(ServerRequest serverRequest) {
    return null;
  }
}
