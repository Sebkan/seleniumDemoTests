package com.seleniumdemo.tests;

import com.seleniumdemo.pages.HomePage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactFormTest extends BaseTest {
    @Test
    public void contactUsWithValidData(){
        WebElement submissionText = new HomePage(driver)
                .contactFormValidData("Sebusiek","test@test.pl","Test message")
                .getSubmissionText();
        Assert.assertTrue(submissionText.getText().contains("demo page"));

    }
    @Test
    public void contactUsWithInvalidEmail() {
        WebElement errorText = new HomePage(driver)
                .contactFormInvalidData("Sebusiek", "test.pl", "Test message")
                .getErrorText();
        Assert.assertEquals(errorText.getText(),"Test Data");
    }
}
