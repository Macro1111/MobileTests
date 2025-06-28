package com.globant.webdriver.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

/**
 * Screen representing the Forms section in the WEBDRIVER I/O application.
 * <p>
 * Provides methods to interact with elements specific to the Forms section,
 * such as verifying the presence of the form components title.
 */
public class FormsScreen extends BaseScreen{

    /** Title element for the Form Components section. */
    @AndroidFindBy(uiAutomator = "text(\"Form components\")")
    private WebElement formComponentsTitle;

    /**
     * Constructor that initializes the FormsScreen with the provided Appium driver.
     * Uses PageFactory to initialize the elements annotated with @AndroidFindBy.
     *
     * @param driver instance of {@link AppiumDriver} to interact with the app.
     */
    public FormsScreen(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Checks if the Form Components title is displayed on the screen.
     *
     * @return true if the Form Components title is displayed, false otherwise.
     */
    public boolean isFormComponentsTitleDisplayed() {
        return formComponentsTitle.isDisplayed();
    }
}
