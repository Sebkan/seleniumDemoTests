package com.seleniumdemo.tests;

import com.seleniumdemo.pages.HomePage;
import com.seleniumdemo.pages.LoggedUserPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogInTest extends BaseTest {
    @Test
    public void logInWithValidData() {
        WebElement dashboardLink = new HomePage(driver)
                .openMyAccountClick()
                .logInValidData("test1@test.pl", "test1@test.pl")
                .getDashBoardLink();
        Assert.assertEquals(dashboardLink.getText(), "Dashboard");
    }



}
