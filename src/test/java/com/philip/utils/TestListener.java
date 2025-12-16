package com.philip.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    private static ExtentReports extent;
    private static ExtentTest test;

    // This runs ONCE before any tests start
    @Override
    public void onStart(ITestContext context) {
        // 1. Setup the HTML file location
        ExtentSparkReporter spark = new ExtentSparkReporter("target/SparkReport.html");
        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("Philip's Automation Report");
        spark.config().setReportName("Smoke Test Results");

        // 2. Attach the reporter
        extent = new ExtentReports();
        extent.attachReporter(spark);
        extent.setSystemInfo("Tester", "Philip");
        extent.setSystemInfo("Environment", "QA");
    }

    // This runs BEFORE every single @Test
    @Override
    public void onTestStart(ITestResult result) {
        // Create a new entry in the report for this test
        test = extent.createTest(result.getMethod().getMethodName());
    }

    // This runs when a test PASSES
    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("Test Passed Successfully");
    }

    // This runs when a test FAILS
    @Override
    public void onTestFailure(ITestResult result) {
        test.fail("Test Failed: " + result.getThrowable().getMessage());
    }

    // This runs ONCE after all tests are finished
    @Override
    public void onFinish(ITestContext context) {
        // Write everything to the file
        extent.flush();
    }
}