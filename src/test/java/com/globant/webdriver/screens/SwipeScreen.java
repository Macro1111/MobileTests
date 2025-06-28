package com.globant.webdriver.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

/**
 * Screen representing the Swipe functionality in the WEBDRIVER I/O application.
 * <p>
 * Provides methods to interact with swipeable cards and to scroll within the Swipe section,
 * such as swiping left on cards and scrolling to specific elements.
 */
public class SwipeScreen extends BaseScreen{

    /**
     * Title element for the Swipe section.
     * This title is displayed when the swipe functionality is active.
     */
    @AndroidFindBy(uiAutomator = "text(\"Swipe horizontal\")")
    private WebElement swipeHorizontalTitle;

    /** Card element labeled "FULLY OPEN SOURCE". */
    @AndroidFindBy(uiAutomator = "text(\"FULLY OPEN SOURCE\")")
    private WebElement gitHubCard;

    /** Card element labeled "GREAT COMMUNITY". */
    @AndroidFindBy(uiAutomator = "text(\"GREAT COMMUNITY\")")
    private WebElement communityCard;

    /** Card element labeled "JS.FOUNDATION". */
    @AndroidFindBy(uiAutomator = "text(\"JS.FOUNDATION\")")
    private WebElement jsFoundationCard;

    /** Card element labeled "SUPPORT VIDEOS". */
    @AndroidFindBy(uiAutomator = "text(\"SUPPORT VIDEOS\")")
    private WebElement supportVideosCard;

    /** Card element labeled "EXTENDABLE". */
    @AndroidFindBy(uiAutomator = "text(\"EXTENDABLE\")")
    private WebElement extendableCard;

    /** Card element labeled "COMPATIBLE". */
    @AndroidFindBy(uiAutomator = "text(\"COMPATIBLE\")")
    private WebElement compatibleCard;

    /** Group element containing sections */
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.ViewGroup\").instance(16)")
    private WebElement groupSections;

    /**
     * Element that indicates the user has found a hidden message.
     * This element is displayed when the user scrolls to the end of the Swipe section.
     */
    @AndroidFindBy(uiAutomator = "text(\"You found me!!!\")")
    private WebElement youFoundMe;

    /**
     * Constructor that initializes the SwipeScreen with the provided Appium driver.
     * Uses PageFactory to initialize the elements annotated with @AndroidFindBy.
     *
     * @param driver instance of {@link AppiumDriver} to interact with the app.
     */
    public SwipeScreen(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Checks if the Swipe horizontal title is displayed on the screen.
     *
     * @return true if the title is displayed, false otherwise.
     */
    public boolean isSwipeHorizontalTitleDisplayed() {
        return swipeHorizontalTitle.isDisplayed();
    }

    /**
     * Swipes left from the GitHub card to the Community card.
     *
     * @return true if the Community card is displayed and the GitHub card is invisible, false otherwise.
     */
    public boolean swipeLeftGitHubCard() {
        return swipeLeftCard(gitHubCard,communityCard);
    }

    /**
     * Swipes left from the Community card to the JS Foundation card.
     *
     * @return true if the JS Foundation card is displayed and the Community card is invisible, false otherwise.
     */
    public boolean swipeLeftCommunityCard() {
        return swipeLeftCard(communityCard, jsFoundationCard);
    }

    /**
     * Swipes left from the JS Foundation card to the Support Videos card.
     *
     * @return true if the Support Videos card is displayed and the JS Foundation card is invisible, false otherwise.
     */
    public boolean swipeLeftJsFoundationCard() {
        return swipeLeftCard(jsFoundationCard, supportVideosCard);
    }

    /**
     * Swipes left from the Support Videos card to the Extendable card.
     *
     * @return true if the Extendable card is displayed and the Support Videos card is invisible, false otherwise.
     */
    public boolean swipeLeftSupportVideosCard() {
        return swipeLeftCard(supportVideosCard, extendableCard);
    }

    /**
     * Swipes left from the Extendable card to the Compatible card.
     *
     * @return true if the Compatible card is displayed and the Extendable card is invisible, false otherwise.
     */
    public boolean swipeLeftExtendableCard() {
        return swipeLeftCard(extendableCard, compatibleCard);
    }

    /**
     * Scrolls to the "You found me!!!" element and checks if it is displayed.
     *
     * @return true if the "You found me!!!" element is displayed, false otherwise.
     */
    public boolean scrollToFundMe() {
        scrollToYouFoundMe(compatibleCard, groupSections);
        return youFoundMe.isDisplayed();
    }

    /**
     * Performs a left swipe gesture on the given element.
     *
     * @param element the card element to swipe left.
     */
    public void swipeLeft(WebElement element) {
        int startX = element.getLocation().getX() + (element.getSize().getWidth() / 2);
        int startY = element.getLocation().getY() + (element.getSize().getHeight() / 2);
        int endX = element.getLocation().getX();

        PointerInput pointer = new PointerInput(PointerInput.Kind.TOUCH, "pointer");
        Sequence sequence = new Sequence(pointer, 0)
                .addAction(pointer.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY))
                .addAction(pointer.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(pointer.createPointerMove(Duration.ofMillis(200), PointerInput.Origin.viewport(), endX, startY))
                .addAction(pointer.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(List.of(sequence));
    }

    /**
     * Swipes left from the start card to the end card and verifies the transition.
     *
     * @param startCard the card to swipe from.
     * @param endCard the card to swipe to.
     * @return true if the end card is displayed and the start card is invisible, false otherwise.
     */
    public boolean swipeLeftCard(WebElement startCard, WebElement endCard) {
        selectSwipe();
        swipeLeft(startCard);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));

        boolean isStartCardInvisible;
        try {
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofMillis(200));
            isStartCardInvisible = shortWait.until(ExpectedConditions.invisibilityOf(startCard));
        } catch (TimeoutException e) {
            isStartCardInvisible = false;
        }

        return endCard.isDisplayed() && isStartCardInvisible;
    }

    /**
     * Resets the implicit wait timeout to its default value.
     */
    public void resetImplicitWait() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    /**
     * Performs a vertical scroll gesture using two elements as reference points to calculate the initial Y coordinate.
     * Both `elementA` and `elementB` are used to determine the starting Y position for the scroll,
     * allowing the "You found me!!!" element to be revealed on the screen.
     *
     * @param elementA reference element to help calculate the initial Y position.
     * @param elementB another reference element to help calculate the initial Y position.
     */
    public void scrollToYouFoundMe(WebElement elementA, WebElement elementB) {
        int startX = elementA.getLocation().getX() + (elementA.getSize().getWidth() / 2);

        int endYA = elementA.getLocation().getY() + elementA.getSize().getHeight();
        int startYB = elementB.getLocation().getY();

        int offset = (startYB - endYA) * 80 / 100;
        int resultY = endYA + offset;

        int endY = 0;

        PointerInput pointer = new PointerInput(PointerInput.Kind.TOUCH, "pointer");
        Sequence sequence = new Sequence(pointer, 0)
                .addAction(pointer.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, resultY))
                .addAction(pointer.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(pointer.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), startX, endY))
                .addAction(pointer.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(List.of(sequence));
    }


}
