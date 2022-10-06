package com.seleniumdemo.tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.seleniumdemo.models.User;
import com.seleniumdemo.pages.HomePage;
import com.seleniumdemo.utils.SeleniumHelper;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class EditDataTest extends BaseTest{
    @Test
    public void editAccountData() throws IOException {
        String password = "test1@test.pl";
        User user = new User();
        user.setFirstName("Sebusiek");
        user.setLastName("Sebuskowy");
        user.setDisplayName("Sebusiek");
        user.setCurrentPass(password);
        user.setPassword(password);

        ExtentTest test = extentReports.createTest("Edit Account Data Test");
        WebElement accountChanged = new HomePage(driver)
                .openMyAccountClick()
                .logInValidData("test1@test.pl",password)
                .editDataClick()
                .editUserData(user)
                .submitChanges()
                .getAccDetailsChangedText();
        Assert.assertTrue(accountChanged.getText().contains("Account details changed"));
        test.log(Status.PASS,"Account details changed successfully", SeleniumHelper.getScreen(driver));
    }

}
