package com.globant.webdriver.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

/**
 * Screen representing the Drag and Drop functionality in the WEBDRIVER I/O application.
 * <p>
 * Provides methods to interact with elements specific to the Drag and Drop feature,
 * such as verifying the presence of the drag and drop title.
 */
public class DragScreen extends BaseScreen{

    /** Title element for the Drag and Drop section. */
    @AndroidFindBy(uiAutomator = "text(\"Drag and Drop\")")
    private WebElement dragAndDropTitle;

    /**
     * Constructor that initializes the DragScreen with the provided Appium driver.
     * Uses PageFactory to initialize the elements annotated with @AndroidFindBy.
     *
     * @param driver instance of {@link AppiumDriver} to interact with the app.
     */
    public DragScreen(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Checks if the Drag and Drop title is displayed on the screen.
     *
     * @return true if the Drag and Drop title is displayed, false otherwise.
     */
    public boolean isDragAndDropTitleDisplayed() {
        return dragAndDropTitle.isDisplayed();
    }
}
