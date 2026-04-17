package com.mayankPaliwal.pages.pageObjectModel.vwo.improvedPOM;

import com.mayankPaliwal.base.CommonToAllPage;
import com.mayankPaliwal.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.mayankPaliwal.driver.DriverManager.getDriver;

public class LoginPage extends CommonToAllPage {

    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    private By username = By.id("login-username");
    private By password = By.id("login-password");
    private By btn = By.id("js-login-btn");
    private By error_message = By.id("js-notification-box-msg");

    public String login_with_Invalid_creds(String user,String pwd){

        openVWOurl();
        enterInput(username,user);
        enterInput(password,pwd);
        clickElement(btn);

        WaitHelpers.checkForVisiblity(getDriver(),5000,error_message);

        return gettext(error_message);

    }



    public void login_with_valid_creds(String user,String pwd) {

        openVWOurl();
        enterInput(username,user);
        enterInput(password,pwd);
        clickElement(btn);
        WaitHelpers.javaWait(4000);
    }
}
