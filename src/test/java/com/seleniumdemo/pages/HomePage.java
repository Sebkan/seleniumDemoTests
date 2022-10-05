package com.seleniumdemo.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    @FindBy(xpath = "(//span)[text()='My account'][1]")
    private WebElement myAccountBtn;
    @FindBy(xpath = "(//span)[text()='Shop'][1]")
    private WebElement shopBtn;
    @FindBy(id="nimble_name608340875")
    private WebElement nameFormInput;
    @FindBy(id="nimble_email608340875")
    private WebElement emailFormInput;
    @FindBy(id="nimble_message608340875")
    private WebElement messageFormInput;
    @FindBy (id="nimble_submit608340875")
    private WebElement submitFormButton;
    @FindBy(xpath = "//span[contains(text(),'demo')]")
    private WebElement sentFormSpan;
    @FindBy(xpath = "//strong[text()='Test Data']")
    private WebElement wrongEmailText;
    private static final Logger logger = LogManager.getLogger();

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

    public HomePage contactFormValidData(String name,String email, String message){
        formFilling(name, email, message);
        return this;
    }
    public HomePage contactFormInvalidData(String name,String email, String message){
        formFilling(name, email, message);
        return this;
    }
    private void formFilling (String name,String email,String message){
        logger.info("Inserted data: "+name+", "+email+", "+message);
        nameFormInput.sendKeys(name);
        emailFormInput.sendKeys(email);
        messageFormInput.sendKeys(message);
        logger.info("Completed inserting data");
        submitFormButton.click();
        logger.info("Clicked the button");
    }
    public WebElement getSubmissionText(){
        return sentFormSpan;
    }
    public WebElement getErrorText(){
        return wrongEmailText;
    }
}
