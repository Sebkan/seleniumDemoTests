package com.seleniumdemo.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.seleniumdemo.pages.HomePage;
import com.seleniumdemo.pages.MyCartPage;
import com.seleniumdemo.utils.SeleniumHelper;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddAllCartTest extends BaseTest{
    @Test
    public void addAllProductsTest() throws IOException {
       ExtentTest test = extentReports.createTest("Add All Products");

        WebElement headingCartTotals = new HomePage(driver)
                .cartClick()
                .returnToShop()
                .chooseSort(3)
                .addAllToCart()
                .getHeadingTotals();
        Assert.assertEquals(headingCartTotals.getText(),"Cart totals");
        test.log(Status.PASS,"Cart page opened", SeleniumHelper.getScreen(driver));

        WebElement updatedCart = new MyCartPage(driver)
                .setItemsNumber("2","2","2")
                .getCartUpdatedText();
        Assert.assertTrue(updatedCart.getText().contains("Cart updated"),"Invalid text returned");
        test.log(Status.PASS,"Quantity of items updated",SeleniumHelper.getScreen(driver));

        WebElement couponText = new MyCartPage(driver)
                .insertCoupon("test")
                .getCouponAlertText();
        Assert.assertTrue(couponText.getText().contains("does not exist"),"Invalid alert");
        test.log(Status.PASS,"Wrong coupon code alert",SeleniumHelper.getScreen(driver));
    }
}
