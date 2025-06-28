package com.globant.webdriver.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

/**
 * Screen representing the Login and Sign up functionality in the WEBDRIVER I/O application.
 * <p>
 * Provides methods to interact with the login and sign-up forms, including switching between
 * the two forms, submitting credentials, and handling alert dialogs.
 */
public class LoginScreen extends BaseScreen{

    /**
     * Title element for the Login / Sign up form.
     * This title is displayed when the login or sign-up form is visible.
     */
    @AndroidFindBy(uiAutomator = "text(\"Login / Sign up Form\")")
    private WebElement loginSignUpTitle;

    /** Tab element for switching to the Sign up form. */
    @AndroidFindBy(uiAutomator = "text(\"Sign up\")")
    private WebElement signUpTab;

    /** Tab element for switching to the Login form. */
    @AndroidFindBy(uiAutomator = "text(\"Login\").instance(0)")
    private WebElement loginTab;

    /** Input field for the email address. */
    @AndroidFindBy(accessibility = "input-email")
    private WebElement emailInput;

    /** Input field for the password. */
    @AndroidFindBy(accessibility = "input-password")
    private WebElement passwordInput;

    /** Input field for repeating the password (used in sign-up). */
    @AndroidFindBy(accessibility = "input-repeat-password")
    private WebElement repeatPasswordInput;

    /** Button to submit the sign-up form. */
    @AndroidFindBy(uiAutomator = "text(\"SIGN UP\")")
    private WebElement signUpButton;

    /** Button to submit the login form. */
    @AndroidFindBy(uiAutomator = "text(\"LOGIN\")")
    private WebElement loginButton;

    /** Title element for alert dialogs. */
    @AndroidFindBy(id = "android:id/alertTitle")
    private WebElement alertTitle;

    /** OK button for alert dialogs. */
    @AndroidFindBy(id = "android:id/button1")
    private WebElement OKButton;

    /**
     * Constructor that initializes the LoginScreen with the provided Appium driver.
     *
     * @param driver instance of {@link AppiumDriver} to interact with the app.
     */
    public LoginScreen(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Performs the Signup action by filling out the form and submitting it.
     *
     * @param username the email address to use for sign up.
     * @param password the password to use for sign up.
     */
    public void signUp(String username, String password) {
        selectLogin();
        signUpTab.click();
        emailInput.sendKeys(username);
        passwordInput.sendKeys(password);
        repeatPasswordInput.sendKeys(password);
        signUpButton.click();
    }

    /**
     * Performs the Login action by filling out the form and submitting it.
     *
     * @param username the email address to use for login.
     * @param password the password to use for login.
     */
    public void login(String username, String password) {
        selectLogin();
        loginTab.click();
        emailInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    /**
     * Retrieves the text of the alert dialog title and closes the dialog.
     *
     * @return the text of the alert dialog title.
     */
    public String getAlertTitle() {
        String isAlertDisplayed = alertTitle.getText();
        OKButton.click();
        return isAlertDisplayed;
    }

    /**
     * Checks if the Login / Sign up title is displayed on the screen.
     *
     * @return true if the Login / Sign up title is displayed, false otherwise.
     */
    public boolean isLoginSignUpTitleDisplayed() {
        return loginSignUpTitle.isDisplayed();
    }
}
