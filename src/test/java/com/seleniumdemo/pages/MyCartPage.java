package com.seleniumdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyCartPage {
    @FindBy(partialLinkText = "Proceed")
    private WebElement proceedToCheckOutBtn;
    private WebDriver driver;
    public MyCartPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }
    public AddressDetailsPage openAddressDetails(){
        proceedToCheckOutBtn.click();
        return new AddressDetailsPage(driver);
    }
}
