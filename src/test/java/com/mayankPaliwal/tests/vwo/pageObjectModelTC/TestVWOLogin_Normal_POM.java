package com.mayankPaliwal.tests.vwo.pageObjectModelTC;

import com.mayankPaliwal.pages.pageObjectModel.vwo.normalPOM.DashBoardPage;
import com.mayankPaliwal.pages.pageObjectModel.vwo.normalPOM.FreetrialPage;
import com.mayankPaliwal.pages.pageObjectModel.vwo.normalPOM.LoginPage;
import com.mayankPaliwal.utils.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class TestVWOLogin_Normal_POM {


    //  D

    // L
    // we put the locators code in LofinPage in main file

    // V  - Assertions

    @Owner("Mayank Paliwal")
    @Description("Verify that with the invalid credentials and verifying the error message")
    @Test
    public void test_login_negative_vwo() {

        // Driver manager code  --- > D
        WebDriver driver = new ChromeDriver();

        // Page class code [POM code ]  ---> L
        LoginPage loginPage = new LoginPage(driver);
        String err_msg = loginPage.loginWithInvalidCreds(PropertiesReader.readKey("invalid_username"), PropertiesReader.readKey("invalid_password"));


        // Assertions  --->  V

        assertThat(err_msg).isNotEmpty().isNotNull().isNotBlank();
        Assert.assertEquals(err_msg, PropertiesReader.readKey("error_msg"));


        driver.quit();
    }


    @Owner("Mayank Paliwal")
    @Description("Verify login with valid credentials and user will redirect to dashboard page")
    @Test
    public void test_login_positive_vwo() {
        // Driver manager code  --- > D
        WebDriver driver = new ChromeDriver();
        try {
            // Page class code [POM code ]  ---> L
            LoginPage loginPage = new LoginPage(driver);
            loginPage.loginWithValidCreds(PropertiesReader.readKey("username"), PropertiesReader.readKey("password"));
            DashBoardPage dashBoardPage = new DashBoardPage(driver);
            String username = dashBoardPage.loggedInUserName();

            assertThat(username).isNotBlank().isNotEmpty();
            Assert.assertEquals(username, PropertiesReader.readKey("expected_username"));

        } catch (Exception e) {
            System.out.println(" something occured wrong" + e);
        } finally {
            driver.quit();
        }


    }


    @Owner("Mayank Paliwal")
    @Description("Verify that with the invalid credentials and verifying the error message")
    @Test
    public void test_Free_Trial_page() {


        WebDriver driver = new ChromeDriver();

        FreetrialPage freeTrialPage = new FreetrialPage(driver);
        String err = freeTrialPage.trialPageEnterDetailsInvalid(PropertiesReader.readKey("username"));


        assertThat(err).isNotEmpty().isNotNull().isNotBlank();
        Assert.assertEquals(err, PropertiesReader.readKey("trailPage_err"));

        driver.quit();
    }

}
