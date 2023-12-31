package logic;

import infra.AppPage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage extends AppPage {
    private final String PLUS_BUTTON_ID = "com.claudivan.taskagenda:id/btNovoEvento";
    private final String POP_UP_LIST_ID = "android:id/select_dialog_listview";
    private WebElement plusBtn;
   private WebElement popUpList;

    public MainPage(AndroidDriver driver) {
        super(driver);
        this.plusBtn = driver.findElement(By.id(PLUS_BUTTON_ID));
    }
    public void clickPlusBtn(){
        this.plusBtn.click();
    }
    public boolean checkPoPUpList() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust the timeout as needed
        this.popUpList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(POP_UP_LIST_ID)));
        return popUpList.isDisplayed();
    }
}
