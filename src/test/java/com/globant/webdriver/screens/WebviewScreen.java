package com.globant.webdriver.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

/**
 * Screen representing the Webview functionality in the WEBDRIVER I/O application.
 * <p>
 * Provides methods to interact with the webview component, such as checking if it is displayed.
 */
public class WebviewScreen extends BaseScreen{

    /** WebView element that represents the web content displayed in the application. */
    @AndroidFindBy(uiAutomator = "className(\"android.webkit.WebView\")")
    private WebElement webViewClass;

    /**
     * Constructor that initializes the WebviewScreen with the provided Appium driver.
     * Uses PageFactory to initialize the elements annotated with @AndroidFindBy.
     *
     * @param driver instance of {@link AppiumDriver} to interact with the app.
     */
    public WebviewScreen(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Checks if the WebView is displayed on the screen.
     *
     * @return true if the WebView is displayed, false otherwise.
     */
    public boolean isWebViewDisplayed() {
        return webViewClass.isDisplayed();
    }
}
