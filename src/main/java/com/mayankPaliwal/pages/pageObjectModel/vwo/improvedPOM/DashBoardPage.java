package com.mayankPaliwal.pages.pageObjectModel.vwo.improvedPOM;

import com.mayankPaliwal.base.CommonToAllPage;
import com.mayankPaliwal.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashBoardPage extends CommonToAllPage {


    WebDriver driver;

    public DashBoardPage(WebDriver driver){
        this.driver = driver;
    }
    private By userNameOnDashboard = By.xpath("//h6[text()='Edu']");


    public String loggedInUserName(){
        openDashboardVWOurl();
        WaitHelpers.checkForVisiblity(driver,5000,userNameOnDashboard);
        return gettext(userNameOnDashboard);

    }



}
