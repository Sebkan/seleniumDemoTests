package com.seleniumdemo.tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.seleniumdemo.pages.HomePage;
import com.seleniumdemo.utils.SeleniumHelper;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class ContactFormTest extends BaseTest {
    @Test
    public void contactUsWithValidData() throws IOException {
        ExtentTest test = extentReports.createTest("Contact Form With Valid Data");
        WebElement submissionText = new HomePage(driver)
                .contactFormValidData("Sebusiek", "test@test.pl", "Test message")
                .getSubmissionText();
        Assert.assertTrue(submissionText.getText().contains("demo page"));
        test.log(Status.PASS, "Assertion positive", SeleniumHelper.getScreen(driver));
    }

    @Test
    public void contactUsWithInvalidEmail() throws IOException {
        ExtentTest test = extentReports.createTest("Contact Form With Invalid email");
        WebElement errorText = new HomePage(driver)
                .contactFormInvalidData("Sebusiek", "test.pl", "Test message")
                .getErrorText();
        test.log(Status.PASS, "Assertion positive", SeleniumHelper.getScreen(driver));
        Assert.assertEquals(errorText.getText(), "Test Data");
    }
}