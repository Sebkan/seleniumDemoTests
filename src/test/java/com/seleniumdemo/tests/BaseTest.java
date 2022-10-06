package com.seleniumdemo.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.seleniumdemo.utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    protected WebDriver driver;
    protected ExtentHtmlReporter extentHtmlReporter;
    protected ExtentReports extentReports;
    @BeforeSuite
    public void beforeSuite(){
        extentHtmlReporter = new ExtentHtmlReporter("AddAllProductsToCart.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentHtmlReporter);
    }
    @AfterSuite
    public void afterSuite(){
        extentHtmlReporter.flush();
        extentReports.flush();
    }

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://seleniumdemo.com");
    }

    @AfterMethod
    public void tearDown() {
       driver.quit();
    }
}
