package com.seleniumdemo.utils;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.seleniumdemo.pages.OrderDetailsPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class SeleniumHelper {
    private static String getPath(WebDriver driver) throws IOException {
        int randomNumber = (int)(Math.random()*1000);
        String pathName = "src/test/resources/screenshot"+randomNumber+".png";
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File file = screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,new File(pathName));
        return pathName;
    }
    public static MediaEntityModelProvider getScreen(WebDriver driver) throws IOException {
        return MediaEntityBuilder.createScreenCaptureFromPath(getPath(driver)).build();
    }
    public static void waitForElementToBeVisible(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static void waitForElementToBeClickable(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(locator));

    }
    public static void waitForElementToBeClickable(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.pollingEvery(Duration.ofMillis(100));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public static void waitForTextToBePresent(WebDriver driver, WebElement element,String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.pollingEvery(Duration.ofMillis(100));
        wait.until(ExpectedConditions.textToBePresentInElement(element,text));
    }
    public static void waitForElementToBePresent(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    public static void moveToElement(WebDriver driver, WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }
}
