package com.seleniumdemo.pages;

import com.seleniumdemo.models.User;
import com.seleniumdemo.utils.SeleniumHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoggedUserPage {
    @FindBy(linkText = "Dashboard")
    private WebElement dashBoardLink;
    @FindBy(xpath = "//a[contains(text(),'edit')]")
    private WebElement editDataLink;
    @FindBy(id = "account_first_name")
    private WebElement firstName;
    @FindBy(id = "account_last_name")
    private WebElement lastName;
    @FindBy(id = "account_display_name")
    private WebElement displayName;
    @FindBy(id = "password_current")
    private WebElement currentPassword;
    @FindBy(id = "password_1")
    private WebElement newPassword;
    @FindBy(id = "password_2")
    private WebElement confirmPassword;
    @FindBy(name = "save_account_details")
    private WebElement saveAccountButton;
    @FindBy(xpath = "//div[@class='woocommerce-message']")
    private WebElement accDetailsChangedText;

    private WebDriver driver;
    private static Logger logger = LogManager.getLogger();
    public LoggedUserPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }
    public WebElement getDashBoardLink(){
        SeleniumHelper.waitForElementToBePresent(driver, By.linkText("Dashboard"));
        return dashBoardLink;
    }
    public LoggedUserPage editDataClick() {
        editDataLink.click();
        return this;
    }
    public LoggedUserPage editUserData(User user) {
        logger.info("Commenced filling up the form");
        firstName.clear();
        firstName.sendKeys(user.getFirstName());
        lastName.clear();
        lastName.sendKeys(user.getLastName());
        displayName.clear();
        displayName.sendKeys(user.getDisplayName());
        currentPassword.sendKeys(user.getCurrentPass());
        newPassword.sendKeys(user.getPassword());
        confirmPassword.sendKeys(user.getPassword());
        logger.info("Completed filling up the form");
        return this;
    }
    public LoggedUserPage submitChanges() {
        logger.info("Clicking the Submit Changes button");
        saveAccountButton.click();
        logger.info("Button clicked");
        return this;
    }
    public WebElement getAccDetailsChangedText() {
        return accDetailsChangedText;
    }

}
