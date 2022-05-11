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
@ConfigurationProperties(prefix = "lostark.element.xpath")
public class LostarkElementXPathProperties {

  @NotBlank
  private final String popupCloseButton;

  @NotBlank
  private final String goToTradeLink;

  @NotBlank
  private final String userIdInput;

  @NotBlank
  private final String passwordInput;

  @NotBlank
  private final String loginSubmitButton;

  @NotBlank
  private final String auctionSearchInput;

  @NotBlank
  private final String auctionSearchButton;

  @NotBlank
  private final String costResult;
}
