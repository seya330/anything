package com.seya330.anything.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.seya330.anything")
@EntityScan(basePackages = {"com.seya330.anything"})
@EnableJpaAuditing
public class JpaConfig {
}
