package com.bharat.spring.bff.auth.agent.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authentication.HttpStatusServerEntryPoint;

@Configuration
public class SecurityConfig {
  @Bean
  SecurityWebFilterChain customSecurityWebFilterChain(ServerHttpSecurity serverHttpSecurity) {
    return serverHttpSecurity
        .formLogin(ServerHttpSecurity.FormLoginSpec::disable)
        .csrf(ServerHttpSecurity.CsrfSpec::disable)
        .httpBasic(ServerHttpSecurity.HttpBasicSpec::disable)
        .logout(ServerHttpSecurity.LogoutSpec::disable)
        .authorizeExchange(
            authorizeExchangeSpec ->
                authorizeExchangeSpec
                    .pathMatchers("/oauth/login")
                    .permitAll()
                    .pathMatchers("/oauth/callback")
                    .permitAll()
                    .pathMatchers(HttpMethod.OPTIONS)
                    .permitAll()
                    .anyExchange()
                    .authenticated())
        .exceptionHandling(
            exceptionHandlingSpec ->
                exceptionHandlingSpec.authenticationEntryPoint(
                    new HttpStatusServerEntryPoint(HttpStatus.FORBIDDEN)))
        .build();
  }
}
