package com.bharat.spring.bff.auth.agent.config;

import com.bharat.spring.bff.auth.agent.utils.OauthAgentConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;

@EnableWebFluxSecurity
@EnableConfigurationProperties(OauthAgentConfiguration.class)
@Configuration
public class AppConfig {}
