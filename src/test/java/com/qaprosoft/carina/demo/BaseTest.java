package com.qaprosoft.carina.demo;

import com.gurock.testrail.TestRailManager;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public abstract class BaseTest {

    protected String testCaseId;

    @AfterMethod
    public void tearDown(ITestResult result) throws Throwable {
        if (result.getStatus() == ITestResult.SUCCESS) {
            TestRailManager.addResultForTestCases(testCaseId, TestRailManager.TEST_CASE_PASSED_STATUS, "");
        } else if (result.getStatus() == ITestResult.FAILURE) {
            TestRailManager.addResultForTestCases(testCaseId, TestRailManager.TEST_CASE_FAILED_STATUS, result.getThrowable().getMessage());
        }
    }
}
