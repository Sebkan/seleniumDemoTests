package com.seleniumdemo.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

    @FindBy(id = "reg_email")
    private WebElement regEmailInput;
    @FindBy(id = "reg_password")
    private WebElement regPasswordInput;
    @FindBy(name = "register")
    private WebElement registerButton;
    @FindBy(xpath = "//ul[@class='woocommerce-error']//li")
    private WebElement error;
    @FindBy(id = "username")
    private WebElement usernameInput;
    @FindBy(id = "password")
    private WebElement passwordInput;
    @FindBy(name = "login")
    private WebElement logInBtn;
    private static final Logger logger = LogManager.getLogger();

    private WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public LoggedUserPage registerAccountValidEmail(String email, String password) {
        userData(email, password);
        return new LoggedUserPage(driver);
    }

    public MyAccountPage registerAccountInvalidEmail(String email, String password) {
        userData(email, password);
        return this;
    }

    private void userData(String email, String password) {
        logger.info("Commenced typing email: "+email);
        regEmailInput.sendKeys(email);
        regPasswordInput.sendKeys(password);
        logger.info("Finished inserting the password: "+password);
        registerButton.click();
        logger.info("Clicked the button");
    }

    public WebElement getError() {
        return error;
    }

    public LoggedUserPage logInValidData(String username, String password) {
        logger.info("Commenced inserting data: "+username+", "+password);
        dataInput(username, password);
        logger.info("Data inserted");
        return new LoggedUserPage(driver);
    }

    public MyAccountPage logInInvalidData(String username, String password) {
        dataInput(username, password);
        return this;
    }

    private void dataInput(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        logInBtn.click();
    }


}
