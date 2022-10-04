package com.seleniumdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoggedUser {
    @FindBy(linkText = "Dashboard")
    private WebElement dashBoardLink;

    private WebDriver driver;
    public LoggedUser(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }
    public WebElement getDashBoardLink(){
        return dashBoardLink;
    }

}
