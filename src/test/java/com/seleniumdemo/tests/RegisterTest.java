package com.seleniumdemo.tests;

import com.seleniumdemo.pages.HomePage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {
    @Test
    public void registerUserTest() {
        int randomNumber = (int) (Math.random() * 1000);
        String email = "test" + randomNumber + "@test.pl";
        WebElement dashBoardLink = new HomePage(driver)
                .openMyAccountClick()
                .registerAccountValidEmail(email, "Testtest12345!").getDashBoardLink();
        Assert.assertEquals(dashBoardLink.getText(), "Dashboard");
    }

    @Test
    public void registerUserWithSameEmailTest() {
        WebElement error = new HomePage(driver)
                .openMyAccountClick()
                .registerAccountInvalidEmail("test@test.pl", "Testtest12345!").getError();
        Assert.assertTrue(error.getText().contains("An account is already registered with your email"));
    }
}


