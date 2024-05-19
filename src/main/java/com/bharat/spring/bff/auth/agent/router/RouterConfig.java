package com.bharat.spring.bff.auth.agent.router;

import com.bharat.spring.bff.auth.agent.handler.OauthEventHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.*;

@Configuration
public class RouterConfig {
  public final String OAUTH_PATH = "/oauth";

  @Bean
  RouterFunction<ServerResponse> oauthRoutes(OauthEventHandler oauthEventHandler) {
    return RouterFunctions.nest(
        RequestPredicates.path(OAUTH_PATH),
        RouterFunctions.route()
            .GET("/login", oauthEventHandler::login)
            .GET("/callback", oauthEventHandler::callback)
            .build());
  }
}
