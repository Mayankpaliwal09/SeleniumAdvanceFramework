package com.mayankPaliwal.pages.pageObjectModel.vwo;

import com.mayankPaliwal.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class FreetrialPage {

    WebDriver driver;

    public FreetrialPage(WebDriver driver){
        this.driver =driver;
    }

    private By btntrial = By.xpath("//span[contains(text(),'Start')]");
    private By usernameField = By.id("page-v1-step1-email");
     private By checkBox = By.id("page-free-trial-step1-cu-gdpr-consent-checkbox");
     private By trialPageBtn = By.xpath("//button[@data-qa='page-su-submit']");
    private By err_msg_trial_page = By.xpath("//div[contains(text(),'email already exists')]");



     public String trialPageEnterDetailsInvalid(String email){
         driver.get("https://app.vwo.com");
         driver.findElement(btntrial).click();


         WaitHelpers.waitForNumberOfWindows(driver,2);

         String parentWindow = driver.getWindowHandle();
         Set<String> windowhandles = driver.getWindowHandles();
         String errFreeTrial = "";
         for(String window : windowhandles){

             if(!window.equals(parentWindow)){
                 driver.switchTo().window(window);
                 driver.findElement(usernameField).sendKeys(email);
                 driver.findElement(checkBox).click();
                 driver.findElement(trialPageBtn).click();

                 WaitHelpers.checkForVisiblity(driver,5000,err_msg_trial_page);

                 errFreeTrial = driver.findElement(err_msg_trial_page).getText();

                   driver.close();
                 break;
             }
         }

         WaitHelpers.javaWait(4000);
         driver.switchTo().window(parentWindow);
         return errFreeTrial;

     }


}
