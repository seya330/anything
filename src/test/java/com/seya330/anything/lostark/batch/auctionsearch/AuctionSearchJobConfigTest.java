package com.seya330.anything.lostark.batch.auctionsearch;

import org.junit.jupiter.api.Disabled;

//@SpringBatchTest
//@SpringBootTest(properties = {"spring.batch.job.enabled=false", "spring.batch.job.names=auctionSearchJob"})
//@ActiveProfiles("dev")
//@EnableConfigurationProperties(value = {LostarkProperties.class, ChromeDriverProperties.class, LostarkElementXPathProperties.class})
@Disabled
class AuctionSearchJobConfigTest {

  /*@Autowired
  JobLauncherTestUtils jobLauncherTestUtils;

  @Test
  void test() throws Exception {
    final JobParameters jobParameter = new JobParametersBuilder()
        .addString("date", LocalDateTime.now().toString())
        .toJobParameters();
    final JobExecution jobExecution = jobLauncherTestUtils.launchJob(jobParameter);
    assertThat(jobExecution.getExitStatus()).isEqualTo(ExitStatus.COMPLETED);
  }*/

}