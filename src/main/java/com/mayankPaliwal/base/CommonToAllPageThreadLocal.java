package com.mayankPaliwal.base;

import com.mayankPaliwal.utils.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.mayankPaliwal.driver.DriverManagerTL.getDriver;

public class CommonToAllPageThreadLocal {

    // common functions here

    public void openVWOurl(){
      getDriver().get(PropertiesReader.readKey("url"));
    }


    public void openDashboardVWOurl(){
        getDriver().get(PropertiesReader.readKey("dashboardURL"));
    }

    public void openHRM(){
        getDriver().get(PropertiesReader.readKey("ohr_url"));
    }


    public void clickElement(By by){
        getDriver().findElement(by).click();
    }

    public void clickElement(WebElement by){
        by.click();
    }


    public void enterInput(By by,String key){
        getDriver().findElement(by).sendKeys(key);
    }

    public void enterInput(WebElement by,String key){
        by.sendKeys(key);
    }

    public String gettext(By by){
        return getDriver().findElement(by).getText();
    }

    public String gettext(WebElement by){
        return by.getText();
    }

}
