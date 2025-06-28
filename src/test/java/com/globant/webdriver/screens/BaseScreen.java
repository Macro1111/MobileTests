package com.globant.webdriver.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


/**
 * Base screen that centralizes navigation between the main sections of the WEBDRIVER I/O application.
 * <p>
 * Provides methods to access different screens through the bottom menu,
 * making navigation logic reusable and maintainable across tests.
 * Each method returns the corresponding screen, allowing fluent chaining in test flows.
 */
public class BaseScreen {

    /** Appium driver used to interact with the application. */
    protected AppiumDriver driver;

    /** Menu element to access the Webview section. */
    @AndroidFindBy(uiAutomator = "text(\"Webview\")")
    private WebElement webviewSection;

    /** Menu element to access the Login section. */
    @AndroidFindBy(uiAutomator = "text(\"Login\")")
    private WebElement loginSection;

    /** Menu element to access the Forms section. */
    @AndroidFindBy(uiAutomator = "text(\"Forms\")")
    private WebElement formsSection;

    /** Menu element to access the Swipe section. */
    @AndroidFindBy(uiAutomator = "text(\"Swipe\")")
    private WebElement swipeSection;

    /** Menu element to access the Drag section. */
    @AndroidFindBy(uiAutomator = "text(\"Drag\")")
    private WebElement dragSection;

    /**
     * Constructor that initializes the BaseScreen with the provided Appium driver.
     * Uses PageFactory to initialize the elements annotated with @AndroidFindBy.
     *
     * @param driver instance of {@link AppiumDriver} to interact with the app.
     */
    public BaseScreen(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    /**
     * Selects the Webview section from the bottom menu and returns the corresponding screen.
     *
     * @return instance of {@link WebviewScreen}
     */
    public WebviewScreen selectWebview() {
        webviewSection.click();
        return new WebviewScreen(driver);
    }

    /**
     * Selects the Login section from the bottom menu and returns the corresponding screen.
     *
     * @return instance of {@link LoginScreen}
     */
    public LoginScreen selectLogin(){
        loginSection.click();
        return new LoginScreen(driver);
    }

    /**
     * Selects the Forms section from the bottom menu and returns the corresponding screen.
     *
     * @return instance of {@link FormsScreen}
     */
    public FormsScreen selectForms() {
        formsSection.click();
        return new FormsScreen(driver);
    }

    /**
     * Selects the Swipe section from the bottom menu and returns the corresponding screen.
     *
     * @return instance of {@link SwipeScreen}
     */
    public SwipeScreen selectSwipe() {
        swipeSection.click();
        return new SwipeScreen(driver);
    }

    /**
     * Selects the Drag section from the bottom menu and returns the corresponding screen.
     *
     * @return instance of {@link DragScreen}
     */
    public DragScreen selectDrag() {
        dragSection.click();
        return new DragScreen(driver);
    }

}
