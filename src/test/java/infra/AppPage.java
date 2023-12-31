package infra;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AppPage {

    protected AppiumDriver driver;

    // Constructor
    public AppPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    // Common functions

    // Click on an element
    protected void clickElement(WebElement element) {
        element.click();
    }

    // Send text to an input field
    protected void sendTextToElement(WebElement element, String text) {
        element.sendKeys(text);
    }

    // Get text from an element
    protected String getTextFromElement(WebElement element) {
        return element.getText();
    }

    // Check if an element is displayed
    protected boolean isElementDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    // Perform a generic wait (you can replace it with WebDriverWait as needed)
    protected void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
