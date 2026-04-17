package com.mayankPaliwal.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import static com.mayankPaliwal.driver.DriverManager.getDriver;

public class WaitHelpers {

    public static void javaWait(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }



    // Implicit Wait

    public static void implicitWait(WebDriver driver, int time){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
    }


    // Explicit waits
    public static void checkForVisiblity(WebDriver driver,int time, By locators){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locators));
    }

    public static void waitForVisibility(WebDriver driver, int time , String xpath){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    public static void waitForVisibilityByid(WebDriver driver, int time , String id){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
    }




    public static void fluentWait(WebDriver driver, String xpath){

        FluentWait<WebDriver> fwait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        WebElement modal = fwait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath((xpath)));
            }
        });
    }



    public static void waitForNumberOfWindows(WebDriver driver, int expectedWindows) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(driver1 -> driver.getWindowHandles().size()==expectedWindows);
    }


    public static WebElement presenceOfElement(By elementLocation) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(elementLocation));
    }

    public static WebElement presenceOfElement(WebDriver driver,By elementLocation) {
        return new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(elementLocation));
    }

    public static WebElement visibilityOfElement(By elementLocation) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(elementLocation));
    }
    public static WebElement visibilityOfElement(WebElement elementLocation) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(elementLocation));
    }

    public WebElement getElement(By key) {
        return getDriver().findElement(key);
    }


}
