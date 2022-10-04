package com.seleniumdemo.tests;

import com.seleniumdemo.pages.HomePage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogInTest extends BaseTest {
    @Test
    public void logInWithValidData() {
        WebElement dashboardLink = new HomePage(driver)
                .openMyAccountClick()
                .logInValidData("test4@test.pl", "test4@test.pl")
                .getDashBoardLink();
        Assert.assertEquals(dashboardLink.getText(), "Dashboard");
    }

    /*@Test
    public void logInWithInvalidData() {
        WebElement error = new HomePage(driver)
                .openMyAccountClick()
                .logInInvalidData("test666@test.pl", "test")
                .getError();
        Assert.assertTrue(error.getText().contains("Incorrect"), "expected error text doesn't match");
    }*/
}
