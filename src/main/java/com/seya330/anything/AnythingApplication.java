package com.seya330.anything;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan(basePackages = "com.seya330.anything")
@SpringBootApplication(scanBasePackages = "com.seya330.anything")
public class AnythingApplication {
  public static void main(String[] args) {
    SpringApplication.run(AnythingApplication.class, args);
  }
}
