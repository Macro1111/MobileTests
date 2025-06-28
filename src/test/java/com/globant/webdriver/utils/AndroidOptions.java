package com.globant.webdriver.utils;

import io.appium.java_client.android.options.UiAutomator2Options;

/**
 * Utility class for configuring Android-specific Appium options.
 * <p>
 * Provides a static method to generate and configure {@link UiAutomator2Options}
 * for initializing the Appium driver with the required device and app settings.
 */
public class AndroidOptions {

    /**
     * Returns a configured instance of {@link UiAutomator2Options} for the test device and app.
     *
     * @return a {@link UiAutomator2Options} object with device name, app path, package, and activity set.
     */
    public static UiAutomator2Options getAndroidOptions() {
        return new UiAutomator2Options()
                .setDeviceName("RF8R70KZATW")
                .setApp("C:\\Users\\Marcos\\IdeaProjects\\Globant\\MobileTests\\src\\test\\resources\\android.wdio.native.app.v1.0.8.apk")
                .setAppPackage("com.wdiodemoapp")
                .setAppActivity(".MainActivity");
    }
}
