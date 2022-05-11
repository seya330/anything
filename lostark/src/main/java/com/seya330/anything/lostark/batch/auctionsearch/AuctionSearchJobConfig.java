package com.seya330.anything.lostark.batch.auctionsearch;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.repeat.RepeatStatus;

@Slf4j
//@Configuration
//@EnableBatchProcessing
//@RequiredArgsConstructor
//@ConditionalOnProperty(prefix = "spring.batch.job", value = "names", havingValue = "auctionSearchJob")
public class AuctionSearchJobConfig {

//  private final JobBuilderFactory jobBuilderFactory;
//
//  private final StepBuilderFactory stepBuilderFactory;
//
//  private final AuctionSearchJobListener auctionSearchJobListener;
//
//  private final ChromeDriverProperties chromeDriverProperties;
//
//  private final LostarkProperties lostarkProperties;
//
//  private final LostarkElementXPathProperties xPathProperties;
//
//  private final DestructionStoneCrystalJpaRepository destructionStoneCrystalJpaRepository;
//
//  @Bean
//  public Job auctionSearchJob() {
//    System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, chromeDriverProperties.getDriver());
//    return jobBuilderFactory.get("auctionSearchJob")
//        .incrementer(new RunIdIncrementer())
//        .start(auctionSearchStep())
//        .listener(auctionSearchJobListener)
//        .build();
//  }
//
//  @Bean
//  public Step auctionSearchStep() {
//    return stepBuilderFactory.get("auctionSearchStep")
//        .tasklet((stepContribution, chunkContext) -> {
//          final WebDriver driver = new ChromeDriver();
//          final JavascriptExecutor js = (JavascriptExecutor) driver;
//          goToMainPage(driver);
//          closePopup(driver);
//          goToAuctionPage(driver, js);
//          login(driver);
//          search(driver);
//          int cost = getCost(driver);
//          driver.close();
//          destructionStoneCrystalJpaRepository.save(DestructionStoneCrystal.builder()
//              .cost(cost)
//              .build());
//          return RepeatStatus.FINISHED;
//        })
//        .build();
//  }
//
//  private void search(WebDriver driver) {
//    final WebElement searchInput = driver.findElement(By.xpath(xPathProperties.getAuctionSearchInput()));
//    searchInput.sendKeys("파괴석 결정");
//    final WebElement auctionSearchButton = driver.findElement(By.xpath(xPathProperties.getAuctionSearchButton()));
//    auctionSearchButton.click();
//  }
//
//  private void login(final WebDriver driver) {
//    final WebElement userId = driver.findElement(By.xpath(xPathProperties.getUserIdInput()));
//    final WebElement password = driver.findElement(By.xpath(xPathProperties.getPasswordInput()));
//    final WebElement submitButton = driver.findElement(By.xpath(xPathProperties.getLoginSubmitButton()));
//    userId.sendKeys("seya3302@gmail.com ");
//    password.sendKeys("Tkauszld12!");
//    submitButton.click();
//  }
//
//  private void goToAuctionPage(final WebDriver driver, final JavascriptExecutor js) {
//    final WebElement goToTradeLink = driver.findElement(By.xpath(xPathProperties.getGoToTradeLink()));
//    js.executeScript("arguments[0].click();", goToTradeLink);
//  }
//
//  private void closePopup(final WebDriver driver) {
//    final WebElement popupCloseButton = driver.findElement(By.xpath(xPathProperties.getPopupCloseButton()));
//    if (popupCloseButton != null) {
//      popupCloseButton.click();
//    }
//  }
//
//  private void goToMainPage(final WebDriver driver) {
//    driver.get(lostarkProperties.getMainUrl());
//    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//  }
//
//  private int getCost(final WebDriver driver) {
//    final WebElement cost = driver.findElement(By.xpath(xPathProperties.getCostResult()));
//    return Integer.parseInt(cost.getText());
//  }

}
