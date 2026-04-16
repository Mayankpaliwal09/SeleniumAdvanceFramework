package com.mayankPaliwal.pages.pageObjectModel.vwo;

import com.mayankPaliwal.utils.PropertiesReader;
import com.mayankPaliwal.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {



    // Step -0  Page class
    // Step -0  parametrized contructor

    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }



    // Step -1 Locators

    private By username = By.id("login-username");
    private By password = By.id("login-password");
    private By btn = By.id("js-login-btn");
    private By error_message = By.id("js-notification-box-msg");


    // we can add more locators if we are testing it pr automating it
//    private By signBySSO = By.xpath("//button[normalize-space()='Sign in using SSO]");


    // Step-2  Page Actions

    public String loginWithInvalidCreds(String user , String pwd){

        driver.get(PropertiesReader.readKey("url"));
        driver.findElement(username).sendKeys(PropertiesReader.readKey("invalid_username"));
        driver.findElement(password).sendKeys(PropertiesReader.readKey("invalid_password"));
        driver.findElement(btn).click();

        WaitHelpers.checkForVisiblity(driver,5000,error_message);
       String err_msg =  driver.findElement(error_message).getText();

        return err_msg;
    }

    public void loginWithValidCreds(String user , String pwd){
        driver.get(PropertiesReader.readKey("url"));
        driver.findElement(username).sendKeys(PropertiesReader.readKey("username"));
        driver.findElement(password).sendKeys(PropertiesReader.readKey("password"));
        driver.findElement(btn).click();

        WaitHelpers.javaWait(4000);
    }




}
