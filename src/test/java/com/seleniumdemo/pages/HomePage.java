package com.seleniumdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    @FindBy(xpath = "(//span)[text()='My account'][1]")
    private WebElement myAccountBtn;
    @FindBy(xpath = "(//span)[text()='Shop'][1]")
    private WebElement shopBtn;

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public MyAccountPage openMyAccountClick() {
        myAccountBtn.click();
        return new MyAccountPage(driver);
    }
    public ProductListPage openShopPage(){
        shopBtn.click();
        return new ProductListPage(driver);
    }

}
