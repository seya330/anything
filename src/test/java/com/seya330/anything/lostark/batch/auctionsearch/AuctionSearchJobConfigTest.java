package com.seya330.anything.lostark.batch.auctionsearch;

import com.seya330.anything.lostark.batch.config.ChromeDriverProperties;
import com.seya330.anything.lostark.batch.config.LostarkElementXPathProperties;
import com.seya330.anything.lostark.batch.config.LostarkProperties;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBatchTest
@SpringBootTest(properties = {"spring.batch.job.enabled=false", "spring.batch.job.names=auctionSearchJob"})
@ActiveProfiles("dev")
@EnableConfigurationProperties(value = {LostarkProperties.class, ChromeDriverProperties.class, LostarkElementXPathProperties.class})
@Disabled
class AuctionSearchJobConfigTest {

  @Autowired
  JobLauncherTestUtils jobLauncherTestUtils;

  @Test
  void test() throws Exception {
    final JobParameters jobParameter = new JobParametersBuilder()
        .addString("date", LocalDateTime.now().toString())
        .toJobParameters();
    final JobExecution jobExecution = jobLauncherTestUtils.launchJob(jobParameter);
    assertThat(jobExecution.getExitStatus()).isEqualTo(ExitStatus.COMPLETED);
  }
}