package com.seleniumdemo.pages;

import com.seleniumdemo.utils.SeleniumHelper;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyCartPage {
    @FindBy(partialLinkText = "Proceed")
    private WebElement proceedToCheckOutBtn;
    @FindBy(css = "a[class='button wc-backward']")
    private WebElement returnToShopBtn;
    @FindBy(tagName = "h2")
    private WebElement headingTotals;
    @FindBy(xpath = "//input[@aria-labelledby='Java Selenium WebDriver quantity']")
    private WebElement addJavaQuantityInput;
    @FindBy(xpath = "//input[@aria-labelledby='GIT basics quantity']")
    private WebElement addGitQuantityInput;
    @FindBy(xpath = "//input[@aria-labelledby='BDD Cucumber quantity']")
    private WebElement addCucumberQuantityInput;
    @FindBy (name = "update_cart")
    private WebElement updateCartButton;
    @FindBy(xpath = "//div[@class='woocommerce-message']")
    private WebElement cartUpdatedText;
    @FindBy(id = "coupon_code")
    private WebElement couponCodeInput;
    @FindBy(name = "apply_coupon")
    private WebElement applyCouponButton;
    @FindBy(xpath = "//li[contains(text(),'Coupon')]")
    private WebElement couponAlertText;
    private WebDriver driver;
    public MyCartPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }
    public AddressDetailsPage openAddressDetails(){
        proceedToCheckOutBtn.click();
        return new AddressDetailsPage(driver);
    }
    public ShopPage returnToShop() {
        returnToShopBtn.click();
        return new ShopPage(driver);
    }

    public MyCartPage setItemsNumber(String addJava, String addGit, String addCucumber) {
        addJavaQuantityInput.clear();
        addJavaQuantityInput.sendKeys(addJava);
        addGitQuantityInput.clear();
        addGitQuantityInput.sendKeys(addGit);
        addCucumberQuantityInput.clear();
        addCucumberQuantityInput.sendKeys(addCucumber);
        updateCartButton.click();
        return this;
    }
    public WebElement getHeadingTotals() {
        return headingTotals;
    }
    public WebElement getCartUpdatedText() {
        SeleniumHelper.waitForElementToBeVisible(driver,cartUpdatedText);
        return cartUpdatedText;
    }
    public MyCartPage insertCoupon(String couponCode) {
        couponCodeInput.sendKeys(couponCode);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()",applyCouponButton);
        //applyCouponButton.click();
        return this;
    }
    public WebElement getCouponAlertText() {
        SeleniumHelper.waitForElementToBeVisible(driver,couponAlertText);
        return couponAlertText;
    }
}
