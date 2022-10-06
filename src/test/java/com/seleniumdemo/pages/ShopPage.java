package com.seleniumdemo.pages;

import com.seleniumdemo.utils.SeleniumHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ShopPage {
    @FindBy(tagName = "select")
    private WebElement sortSelect;
    @FindBy(xpath = "//a[@data-product_id='8']")
    private WebElement addJava;
    @FindBy(xpath = "//a[@data-product_id='27']")
    private WebElement addGit;
    @FindBy(xpath = "//a[@data-product_id='29']")
    private WebElement addCucumber;
    @FindBy(xpath = "//i[@class='icn-shoppingcart']")
    private WebElement cartIcon;
    @FindBy(xpath="//p[@class='woocommerce-mini-cart__buttons buttons']//a[text()='View cart']")
    private WebElement viewCartButton;
    @FindBy(tagName = "sup")
    private WebElement numberOfItems;
    private WebDriver driver;
    public ShopPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }
    public ProductPage openProduct(String title){
        By productXpath = By.xpath("//h2[text()='"+title+"']");
        SeleniumHelper.waitForElementToBeClickable(driver,productXpath);
        driver.findElement(productXpath).click();
        return new ProductPage(driver);
    }
    public ShopPage chooseSort(int index){
        Select select = new Select(sortSelect);
        select.selectByIndex(index);
        return this;
    }
    public MyCartPage addAllToCart() {

        SeleniumHelper.waitForElementToBeClickable(driver,addJava);
        addJava.click();
        SeleniumHelper.waitForElementToBeClickable(driver,addGit);
        SeleniumHelper.waitForTextToBePresent(driver,numberOfItems,"1");
        addGit.click();
        SeleniumHelper.waitForTextToBePresent(driver,numberOfItems,"2");
        SeleniumHelper.waitForElementToBeClickable(driver,addCucumber);
        addCucumber.click();
        SeleniumHelper.waitForTextToBePresent(driver,numberOfItems,"3");
        SeleniumHelper.moveToElement(driver,cartIcon);
        SeleniumHelper.waitForElementToBeClickable(driver,viewCartButton);
        viewCartButton.click();
        return new MyCartPage(driver);
    }


}
