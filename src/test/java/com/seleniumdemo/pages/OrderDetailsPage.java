package com.seleniumdemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderDetailsPage {
    @FindBy(xpath = "//div[@class='woocommerce-order']//p")
    private WebElement orderConfirmationText;
    @FindBy(xpath = "//td[contains(@class,'product-name')]")
    private WebElement productName;

    private WebDriver driver;
    public OrderDetailsPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }
    public WebElement getConfirmationText(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOf(orderConfirmationText));
        return orderConfirmationText;
    }
    public WebElement getProductName(){
        return productName;
    }

}
