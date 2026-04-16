package com.mayankPaliwal.pages.pageObjectModel.vwo;

import com.mayankPaliwal.utils.WaitHelpers;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashBoardPage {


    WebDriver driver;

    public DashBoardPage(WebDriver driver){
        this.driver = driver;
    }


    private By userNameOnDashboard = By.xpath("//h6[text()='Edu']");


    public String loggedInUserName(){


        driver.get("https://app.vwo.com/#/dashboard/");

        WaitHelpers.checkForVisiblity(driver,5000,userNameOnDashboard);
        return driver.findElement(userNameOnDashboard).getText();
    }


}
