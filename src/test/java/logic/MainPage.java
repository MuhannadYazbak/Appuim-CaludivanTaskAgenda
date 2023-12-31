package logic;

import infra.AppPage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MainPage extends AppPage {
    private final String PLUS_BUTTON_ID = "com.claudivan.taskagenda:id/btNovoEvento";
    private WebElement plusBtn;
    private AndroidDriver driver;

    public MainPage(AndroidDriver driver) {
        super(driver);
        this.plusBtn = driver.findElement(By.id(PLUS_BUTTON_ID));
    }
    public void clickPlusBtn(){
        plusBtn.click();
    }
}
