package com.mayankPaliwal.tests.vwo.pageObjectModelTC;

import com.mayankPaliwal.base.CommonToAllTest;
import com.mayankPaliwal.driver.DriverManager;
import com.mayankPaliwal.pages.pageObjectModel.vwo.improvedPOM.DashBoardPage;
//import com.mayankPaliwal.pages.pageObjectModel.vwo.improvedPOM.FreetrialPage;
import com.mayankPaliwal.pages.pageObjectModel.vwo.improvedPOM.LoginPage;
import com.mayankPaliwal.utils.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestVWOLogin_Prop_improved_POM extends CommonToAllTest {


    //  D

    // L
    // we put the locators code in LofinPage in main file

    // V  - Assertions

    private static final Logger logger = LogManager.getLogger(TestVWOLogin_Prop_improved_POM.class);

    @Owner("Mayank Paliwal")
    @Description("Verify that with the invalid credentials and verifying the error message")
    @Test
    public void test_login_negative_vwo() {

        logger.info("This is starting of the test case login woth negative ");

        // Driver manager code  --- > D

        // Page class code [POM code ]  ---> L
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        String err_msg = loginPage.login_with_Invalid_creds(PropertiesReader.readKey("invalid_username"), PropertiesReader.readKey("invalid_password"));

        // Assertions  --->  V

        logger.info("This is assertions for invalid creds");
        assertThat(err_msg).isNotEmpty().isNotNull().isNotBlank();
        Assert.assertEquals(err_msg, PropertiesReader.readKey("error_msg"));



    }


    @Owner("Mayank Paliwal")
    @Description("Verify login with valid credentials and user will redirect to dashboard page")
    @Test
    public void test_login_positive_vwo() {
        // Driver manager code  --- > D

        logger.info("This is starting of login with valid creds");
        try {
            // Page class code [POM code ]  ---> L
            LoginPage loginPage = new LoginPage(DriverManager.getDriver());
            loginPage.login_with_valid_creds(PropertiesReader.readKey("username"), PropertiesReader.readKey("password"));
            DashBoardPage dashBoardPage = new DashBoardPage(DriverManager.getDriver());
            String username = dashBoardPage.loggedInUserName();

            assertThat(username).isNotBlank().isNotEmpty();
            Assert.assertEquals(username, PropertiesReader.readKey("expected_username"));

        } catch (Exception e) {
            System.out.println(" something occured wrong" + e);
        }


    }


//    @Owner("Mayank Paliwal")
//    @Description("Verify that with the invalid credentials and verifying the error message")
//    @Test
//    public void test_Free_Trial_page() {
//
//        logger.info("This is trial page ");
//
//        FreetrialPage freeTrialPage = new FreetrialPage(DriverManager.getDriver());
//        String err = freeTrialPage.trialPageEnterDetailsInvalid(PropertiesReader.readKey("username"));
//
//        logger.info("This is trial page Assertions ");
//        assertThat(err).isNotEmpty().isNotNull().isNotBlank();
//        Assert.assertEquals(err, PropertiesReader.readKey("trailPage_err"));
//
//
//    }

}
