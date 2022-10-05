package com.seleniumdemo.pages;

import com.seleniumdemo.models.Customer;
import com.seleniumdemo.utils.SeleniumHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddressDetailsPage {
    private WebDriver driver;
    @FindBy(id="billing_first_name")
    private WebElement firstNameInput;
    @FindBy(id="billing_last_name")
    private WebElement lastNameInput;
    @FindBy(id="billing_company")
    private WebElement companyNameInput;
    @FindBy(id="billing_country")
    private WebElement countrySelect;
    @FindBy(id="billing_address_1")
    private WebElement addressFirstInput;
    @FindBy(id="billing_postcode")
    private WebElement postCodeInput;
    @FindBy(id="billing_city")
    private WebElement cityInput;
    @FindBy(id="billing_phone")
    private WebElement phoneInput;
    @FindBy(id="billing_email")
    private WebElement emailInput;
    @FindBy(id="order_comments")
    private WebElement orderCommentsInput;
    @FindBy(id="place_order")
    private WebElement placeOrderButton;

    private static final Logger logger = LogManager.getLogger();

    public AddressDetailsPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }
    public OrderDetailsPage placeOrder(Customer customer, String comments) {
        logger.info("Commenced typing the data");
        firstNameInput.sendKeys(customer.getFirstName());
        lastNameInput.sendKeys(customer.getLastName());
        companyNameInput.sendKeys(customer.getCompanyName());
        Select country = new Select(countrySelect);
        country.selectByVisibleText(customer.getCountry());
        addressFirstInput.sendKeys(String.format("%s %s",customer.getStreet(),customer.getFlatNumber()));
        postCodeInput.sendKeys(customer.getZipCode());
        cityInput.sendKeys(customer.getCity());
        phoneInput.sendKeys(customer.getPhone());
        emailInput.sendKeys(customer.getEmail());
        orderCommentsInput.sendKeys(comments);
        SeleniumHelper.waitForElementToBeClickable(driver,placeOrderButton);
        logger.info("Finished typing data");
        logger.info("Starting performing the click test");
        placeOrderButton.click();
        logger.info("Completed the click");
        return new OrderDetailsPage(driver);
    }
}
