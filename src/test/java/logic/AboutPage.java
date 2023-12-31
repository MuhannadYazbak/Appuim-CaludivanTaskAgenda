package logic;

import infra.AppPage;
import infra.TestContext;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AboutPage extends AppPage {
    private final String ABOUT_DIV_XPATH ="//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.LinearLayout";
    private WebElement aboutDiv;
    public AboutPage(AppiumDriver driver) {
        super(driver);
    }
    public boolean checkAbout(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.aboutDiv = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ABOUT_DIV_XPATH)));
        return  aboutDiv.isDisplayed();
    }
}
