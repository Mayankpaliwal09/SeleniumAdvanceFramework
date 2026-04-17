package com.mayankPaliwal.tests.vwo.pageObjectModelTC.dataDriven;

import com.mayankPaliwal.base.CommonToAllTest;
import com.mayankPaliwal.driver.DriverManager;
import com.mayankPaliwal.pages.pageObjectModel.vwo.improvedPOM.LoginPage;
import com.mayankPaliwal.utils.PropertiesReader;
import com.mayankPaliwal.utilsExcel.UtilExcel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DataDrivenTesting extends CommonToAllTest {
    private static final Logger logger = LogManager.getLogger(DataDrivenTesting.class);

    @Test(dataProvider = "getData")
    public void Invalid_login(String user , String pwd){
        logger.info("This is starting of the test case login woth negative ");

        // Driver manager code  --- > D

        // Page class code [POM code ]  ---> L
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        String err_msg = loginPage.login_with_Invalid_creds(user,pwd);

        // Assertions  --->  V

        logger.info("This is assertions for invalid creds");
        assertThat(err_msg).isNotEmpty().isNotNull().isNotBlank();
        Assert.assertEquals(err_msg, PropertiesReader.readKey("error_msg"));


    }

    @DataProvider
    public Object[][] getData(){
        return UtilExcel.getDataFromExcel("Sheet1");
    }
}
