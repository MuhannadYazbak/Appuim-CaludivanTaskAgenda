package logic;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class NewEvent extends AboutPage{
    private final String TITLE_XPATH = "//android.widget.TextView[@text=\"New event\"]";
    private final String SAVE_BUTTON_ID = "com.claudivan.taskagenda:id/item_salvar";
    private final String DESCRIPTION_INPUT_ID = "com.claudivan.taskagenda:id/etDescricao";
    private final String EVENT_TITLE_INPUT_ID = "com.claudivan.taskagenda:id/etTitulo";
    private WebElement title;
    private WebElement saveBtn;
    private WebElement descriptionInput;
    private WebElement eventTitle;
    public NewEvent(AppiumDriver driver) {
        super(driver);
        this.title = driver.findElement(By.xpath(TITLE_XPATH));
        this.saveBtn = driver.findElement(By.id(SAVE_BUTTON_ID));
        this.descriptionInput = driver.findElement(By.id(DESCRIPTION_INPUT_ID));

    }
    private void fillEventTitle(String text){
        eventTitle.clear();
        eventTitle.sendKeys(text);
    }
    private void fillDescription(String text){
        descriptionInput.clear();
        descriptionInput.sendKeys(text);
    }
    private void clickSaveBtn(){
        saveBtn.click();
    }
    public void createEvent(String title, String description){
        fillDescription(description);
        driver.navigate().back();
        this.eventTitle = driver.findElement(By.id(EVENT_TITLE_INPUT_ID));
        fillEventTitle(title);
        clickSaveBtn();
    }
}
