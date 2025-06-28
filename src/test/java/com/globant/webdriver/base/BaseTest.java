package com.globant.webdriver.base;
import com.globant.webdriver.utils.DriverManager;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

/**
 * Base class for all tests, providing setup and teardown methods.
 * Initializes the Appium driver and manages implicit waits.
 */
public class BaseTest {

    protected AppiumDriver driver;
    protected SoftAssert softAssert = new SoftAssert();

    /**
     * Sets up the Appium driver and configures implicit wait time before each test method.
     */
    @BeforeMethod
    public void setUp() {
        driver = DriverManager.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    /**
     * Tears down the Appium driver after each test method.
     * Asserts all soft assertions and quits the driver.
     */
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            softAssert.assertAll();
            driver.quit();
        }
    }
}
