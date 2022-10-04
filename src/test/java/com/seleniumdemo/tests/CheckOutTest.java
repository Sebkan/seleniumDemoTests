package com.seleniumdemo.tests;

import com.seleniumdemo.models.Customer;
import com.seleniumdemo.pages.HomePage;
import com.seleniumdemo.pages.OrderDetailsPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckOutTest extends BaseTest {
    @Test
    public void buyProductTest() {
        Customer customer = new Customer();
        customer.setEmail("specificEmail@wp.pl");
        OrderDetailsPage orderDetailsPage = new HomePage(driver)
                .openShopPage()
                .openProduct("Java Selenium WebDriver")
                .addToCart()
                .viewCart()
                .openAddressDetails()
                .placeOrder(customer, "Be careful");
        Assert.assertTrue(orderDetailsPage.getConfirmationText().getText().contains("Thank you"));
        Assert.assertEquals(orderDetailsPage.getProductName().getText(), "Java Selenium WebDriver × 1");
    }
}
