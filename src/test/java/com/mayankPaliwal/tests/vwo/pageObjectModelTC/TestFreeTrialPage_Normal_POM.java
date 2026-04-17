package com.mayankPaliwal.tests.vwo.pageObjectModelTC;

import com.mayankPaliwal.pages.pageObjectModel.vwo.normalPOM.FreetrialPage;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestFreeTrialPage_Normal_POM {

    @Owner("Mayank Paliwal")
    @Description("Verify that with the invalid credentials and verifying the error message")
    @Test
    public void test_Free_Trial_page(){


        WebDriver driver = new ChromeDriver();

        FreetrialPage freeTrialPage = new FreetrialPage(driver);
        String err =  freeTrialPage.trialPageEnterDetailsInvalid("20010041034@gateway.edu.in");


        assertThat(err).isNotEmpty().isNotNull().isNotBlank();
        Assert.assertEquals(err,"An account with this email already exists. Login Here");

        driver.quit();
    }
}
