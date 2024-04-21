package com.webstaurant_project.base;

import com.webstaurant_project.utilities.ConfigurationReader;
import com.webstaurant_project.utilities.Driver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;


/**
 * Created TestBase class to provide setup and teardown methods to test classes.
 */
public abstract class TestBase {
    /**
     * Method to set up the test environment before each test execution.
     * It navigates to the URL specified in the config.properties file.
     */
    @BeforeClass
    public void setup() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    /**
     * Created method to clean up the test environment after each test execution.
     * It closes the driver instance.
     */
    @AfterClass
    public void tearDown() {
        Driver.closeDriver();
    }
}

