package org.example.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class FullFlowTest {

    @Test
    public void testFullUploadFlow() {
        log.info("Starting Full Upload Flow Test");

        int totalTests = 0;
        int passedTests = 0;
        List<String> failedTests = new ArrayList<>();

        totalTests++;
        try {
            log.info("Running registerJobSeekerTest...");
            new registerJobSeekerTest().shouldRegisterJobseekerSuccessfully();
            log.info("registerJobSeekerTest passed.");
            passedTests++;
        } catch (Exception e) {
            log.error("registerJobSeekerTest failed.", e);
            failedTests.add("registerJobSeekerTest");
        }

        totalTests++;
        try {
            log.info("Running searchJobTest...");
            new searchJobTest().shouldSearchJobs();
            log.info("searchJobTest passed.");
            passedTests++;
        } catch (Exception e) {
            log.error("searchJobTest failed.", e);
            failedTests.add("searchJobTest");
        }

        totalTests++;
        try {
            log.info("Running StartUploadTest...");
            new StartUploadTest().shouldInitiateUploadSuccessfully();
            log.info("StartUploadTest passed.");
            passedTests++;
        } catch (Exception e) {
            log.error("StartUploadTest failed.", e);
            failedTests.add("StartUploadTest");
        }

        totalTests++;
        try {
            log.info("Running MultipartUploadTest...");
            new MultipartUploadTest().shouldReturnUploadHeaders();
            log.info("MultipartUploadTest passed.");
            passedTests++;
        } catch (Exception e) {
            log.error("MultipartUploadTest failed.", e);
            failedTests.add("MultipartUploadTest");
        }

        totalTests++;
        try {
            log.info("Running UploadPartTest...");
            new UploadPartTest().shouldUploadFilePartSuccessfully();
            log.info("UploadPartTest passed.");
            passedTests++;
        } catch (Exception e) {
            log.error("UploadPartTest failed.", e);
            failedTests.add("UploadPartTest");
        }

        // Final summary
        log.info("========== TEST SUMMARY ==========");
        log.info("Total tests run   : {}", totalTests);
        log.info("Tests passed      : {}", passedTests);
        log.info("Tests failed      : {}", failedTests.size());

        if (!failedTests.isEmpty()) {
            log.info("Failed tests:");
            for (String failedTest : failedTests) {
                log.info(" - {}", failedTest);
            }
        } else {
            log.info("All tests passed successfully.");
        }
        log.info("==================================");
    }
}
