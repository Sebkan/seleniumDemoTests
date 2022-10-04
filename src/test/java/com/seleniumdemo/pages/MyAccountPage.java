package com.seleniumdemo.pages;

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

    private WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public LoggedUser registerAccountValidEmail(String email, String password) {
        userData(email, password);
        return new LoggedUser(driver);
    }

    public MyAccountPage registerAccountInvalidEmail(String email, String password) {
        userData(email, password);
        return this;
    }

    private void userData(String email, String password) {
        regEmailInput.sendKeys(email);
        regPasswordInput.sendKeys(password);
        registerButton.click();
    }

    public WebElement getError() {
        return error;
    }

    public LoggedUser logInValidData(String username, String password) {
        dataInput(username, password);
        return new LoggedUser(driver);
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
