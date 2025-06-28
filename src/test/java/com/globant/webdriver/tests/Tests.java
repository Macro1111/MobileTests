package com.globant.webdriver.tests;

import com.globant.webdriver.base.BaseTest;
import com.globant.webdriver.screens.BaseScreen;
import com.globant.webdriver.screens.LoginScreen;
import com.globant.webdriver.screens.SwipeScreen;
import com.globant.webdriver.utils.CredentialsFactory.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.globant.webdriver.utils.CredentialsFactory.randomUser;

/**
 * Contains automated UI tests for the WEBDRIVER I/O application.
 * Extends {@link BaseTest} to use shared setup and tearDown.
 */
public class Tests extends BaseTest{

    /**
     * Checks that each section in the bottom menu bar
     * can be accessed and displays the correct screen.
     */
    @Test(priority = 1, testName = "Navigation on the bottom menu bar")
    public void navigationBottomMenuBar(){
        BaseScreen baseScreen = new BaseScreen(driver);
        softAssert.assertTrue(baseScreen.selectWebview().isWebViewDisplayed(), "Webview section is not displayed");
        softAssert.assertTrue(baseScreen.selectLogin().isLoginSignUpTitleDisplayed(), "Login/Sign Up section is not displayed");
        softAssert.assertTrue(baseScreen.selectForms().isFormComponentsTitleDisplayed(), "Form Components section is not displayed");
        softAssert.assertTrue(baseScreen.selectSwipe().isSwipeHorizontalTitleDisplayed(), "Swipe section is not displayed");
        softAssert.assertTrue(baseScreen.selectDrag().isDragAndDropTitleDisplayed(), "Drag and Drop section is not displayed");
    }

    /**
     * Verifies that a new user can sign up successfully,
     * using random credentials and checking for the success alert.
     */
    @Test(priority = 2, testName = "Successful Sign Up")
    public void successfulSignUp(){
        LoginScreen loginScreen = new LoginScreen(driver);
        User user = randomUser();
        loginScreen.signUp(user.email(), user.password());
        Assert.assertEquals(loginScreen.getAlertTitle(), "Signed Up!", "Sign up failed");
    }

    /**
     * Ensures that a registered user can log in with valid credentials
     * and receives the expected success message.
     */
    @Test(priority = 3, testName = "Successful Login")
    public void successfulLogin(){
        LoginScreen loginScreen = new LoginScreen(driver);
        User user = randomUser();
        loginScreen.signUp(user.email(), user.password());
        loginScreen.getAlertTitle();
        loginScreen.login(user.email(), user.password());
        Assert.assertEquals(loginScreen.getAlertTitle(), "Success", "Login failed");
    }

    /**
     * Tests the swipe functionality in the Swipe section by swiping left
     * on several cards and then scrolling to the end of the page to verify
     * that the final element is displayed.
     */
    @Test(priority = 4, testName = "Swipe cards on the Swipe section")
    public void swipeCards() {
        BaseScreen baseScreen = new BaseScreen(driver);

        SwipeScreen swipeScreen = baseScreen.selectSwipe();
        softAssert.assertTrue(swipeScreen.swipeLeftGitHubCard(), "Failed to swipe left on GitHub Card");
        softAssert.assertTrue(swipeScreen.swipeLeftCommunityCard(), "Failed to swipe left on Community Card");
        softAssert.assertTrue(swipeScreen.swipeLeftJsFoundationCard(), "Failed to swipe left on JS Foundation Card");
        softAssert.assertTrue(swipeScreen.swipeLeftSupportVideosCard(), "Failed to swipe left on Support Videos Card");
        softAssert.assertTrue(swipeScreen.swipeLeftExtendableCard(), "Failed to swipe left on Extendable Card");
        swipeScreen.resetImplicitWait();

        softAssert.assertTrue(swipeScreen.scrollToFundMe(), "You Found is not displayed after scrolling");
    }


}
