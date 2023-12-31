package logic;

import infra.AppPage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HamburgerMenu extends AppPage {
    private final String ABOUT_ID = "com.claudivan.taskagenda:id/btSobre";
    private final String ALL_EVENTS_ID = "com.claudivan.taskagenda:id/btEventos";
    private final String SETTINGS_ID = "com.claudivan.taskagenda:id/btAjustes";
    private WebElement about;
    private WebElement allEvents;
    private WebElement settings;
    public HamburgerMenu(AppiumDriver driver) {
        super(driver);
        this.about = driver.findElement(By.id(ABOUT_ID));
        this.allEvents = driver.findElement(By.id(ALL_EVENTS_ID));
        this.settings = driver.findElement(By.id(SETTINGS_ID));
    }
    public void clickAbout(){
        about.click();
    }
    public void clickAllEvents(){
        allEvents.click();
    }
    public void clickSettings(){
        settings.click();
    }

    public WebElement getAbout() {
        return about;
    }

    public void setAbout(WebElement about) {
        this.about = about;
    }

    public WebElement getAllEvents() {
        return allEvents;
    }

    public void setAllEvents(WebElement allEvents) {
        this.allEvents = allEvents;
    }

    public WebElement getSettings() {
        return settings;
    }

    public void setSettings(WebElement settings) {
        this.settings = settings;
    }
}
