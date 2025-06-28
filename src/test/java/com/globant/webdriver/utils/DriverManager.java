package com.globant.webdriver.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Utility class for managing the Appium driver for Android tests.
 * <p>
 * Provides a method to create and return an instance of {@link AppiumDriver} configured with Android-specific options.
 */
public class DriverManager {

    /**
     * Returns an instance of {@link AppiumDriver} configured for Android testing.
     * <p>
     * This method initializes the driver with the necessary options such as device name, app path, package, and activity.
     *
     * @return an instance of {@link AppiumDriver} for Android tests
     */
    public static AppiumDriver getDriver() {
        UiAutomator2Options options = AndroidOptions.getAndroidOptions();
        try {
            return new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
