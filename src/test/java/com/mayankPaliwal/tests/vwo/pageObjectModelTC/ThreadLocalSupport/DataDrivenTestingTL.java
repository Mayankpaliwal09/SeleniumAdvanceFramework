package com.mayankPaliwal.tests.vwo.pageObjectModelTC.ThreadLocalSupport;

import com.mayankPaliwal.base.CommonToAllTest;
import com.mayankPaliwal.base.CommonToAllThreadLocal;
import com.mayankPaliwal.driver.DriverManager;
import com.mayankPaliwal.driver.DriverManagerTL;
import com.mayankPaliwal.listeners.ScreenshotListners;
import com.mayankPaliwal.pages.pageObjectModel.vwo.ThreadLocal.LoginPagethreadLocal;
import com.mayankPaliwal.pages.pageObjectModel.vwo.improvedPOM.LoginPage;
import com.mayankPaliwal.utils.PropertiesReader;
import com.mayankPaliwal.utilsExcel.UtilExcel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Listeners(ScreenshotListners.class)
public class DataDrivenTestingTL extends CommonToAllThreadLocal {
    private static final Logger logger = LogManager.getLogger(DataDrivenTestingTL.class);

    @Test(dataProvider = "getData")
    public void Invalid_login(String user , String pwd){
        logger.info("This is starting of the test case login woth negative ");

        // Driver manager code  --- > D

        // Page class code [POM code ]  ---> L
        LoginPagethreadLocal loginPagethreadLocal = new LoginPagethreadLocal();
        String err_msg = loginPagethreadLocal.login_with_Invalid_creds(user,pwd);

        // Assertions  --->  V

        logger.info("This is assertions for invalid creds");
        assertThat(err_msg).isNotEmpty().isNotNull().isNotBlank();
        Assert.assertEquals(err_msg, PropertiesReader.readKey("error_msg"));


    }

    @DataProvider(name = "getData" , parallel = true)
    public Object[][] getData(){
        return UtilExcel.getDataFromExcel("Sheet1");
    }
}
