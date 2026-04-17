package com.mayankPaliwal.base;

import com.mayankPaliwal.driver.DriverManagerTL;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CommonToAllThreadLocal {

    @BeforeMethod
    public void setUp() {
        DriverManagerTL.init();
    }

    @AfterMethod
    public void tearDown() {
        DriverManagerTL.down();
    }
}
