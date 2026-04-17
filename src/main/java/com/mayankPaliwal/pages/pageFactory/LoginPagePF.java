package com.mayankPaliwal.pages.pageFactory;

import com.mayankPaliwal.base.CommonToAllPage;
import com.mayankPaliwal.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.mayankPaliwal.driver.DriverManager.getDriver;

public class LoginPagePF extends CommonToAllPage {

    WebDriver driver;

    public LoginPagePF(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //private By username = By.id("login-username")

    @FindBy(id = "login-username")
    private WebElement username;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(id = "js-login-btn")
    private WebElement btn;

    @FindBy(id = "js-notification-box-msg")
    private By error_message;

    public String login_with_Invalid_creds(String user,String pwd){

        openVWOurl();
        enterInput(username,user);
        enterInput(password,pwd);
        clickElement(btn);

        WaitHelpers.checkForVisiblity(getDriver(),5000,error_message);

//        WaitHelpers.javaWait(5000);
        System.out.println(error_message);
        return gettext(error_message);

    }
}
