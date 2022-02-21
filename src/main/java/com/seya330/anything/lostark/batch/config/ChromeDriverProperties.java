package com.seya330.anything.lostark.batch.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Getter
@Validated
@RequiredArgsConstructor
@ConstructorBinding
@ConfigurationProperties(prefix = "webdriver.chrome")
public class ChromeDriverProperties {

  @NotBlank
  private final String driver;
}


