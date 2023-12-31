package logic;

import infra.AppPage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PopUpList extends AppPage {
    private final String TODAY_XPATH = "//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Today\"]";
    private final String TOMORROW_XPATH = "//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Tomorrow\"]";
    private final String OTHER_XPATH = "//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Other\"]";
    private WebElement today;
    private WebElement tomorrow;
    private WebElement other;

    public PopUpList(AppiumDriver driver) {
        super(driver);
        this.today = driver.findElement(By.xpath(TODAY_XPATH));
        this.tomorrow = driver.findElement(By.xpath(TOMORROW_XPATH));
        this.other = driver.findElement(By.xpath(OTHER_XPATH));
    }
    public void clickToday(){
        today.click();
    }
    public void clickTomorrow(){
        tomorrow.click();
    }
    public void clickOther(){
        other.click();
    }
    public boolean checkNewEventOpened(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text=\"New event\"]"))).isDisplayed();
    }
}
