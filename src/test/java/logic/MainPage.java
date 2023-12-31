package logic;

import infra.AppPage;
import infra.TestContext;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MainPage extends AppPage {
    private final String PLUS_BUTTON_ID = "com.claudivan.taskagenda:id/btNovoEvento";
    private final String POP_UP_LIST_ID = "android:id/select_dialog_listview";
    private final String HAMBURGER_MENU_ID = "com.claudivan.taskagenda:id/hamburguer";
    private final String RIGHT_ARROW_ID = "com.claudivan.taskagenda:id/ibtAvancar";
    private final String LEFT_ARROW_ID = "com.claudivan.taskagenda:id/ibtRetroceder";
    private final String DATE_TITLE_ID = "com.claudivan.taskagenda:id/tvVisor";
    private final String EVENT_ALERT_ID = "com.claudivan.taskagenda:id/btEventosSemana";
    private WebElement plusBtn;
   private WebElement popUpList;
   private WebElement menu;
   private WebElement rightArrow;
   private WebElement leftArrow;
   private WebElement dateTitle;
   private WebElement eventsAlert;
   private HamburgerMenu hamburgerMenu;
   private AboutPage aboutPage;
   private String title;
   private String alert;


    public MainPage(AndroidDriver driver) {
        super(driver);
        this.plusBtn = driver.findElement(By.id(PLUS_BUTTON_ID));
        this.menu = driver.findElement(By.id(HAMBURGER_MENU_ID));
        this.rightArrow = driver.findElement(By.id(RIGHT_ARROW_ID));
        this.leftArrow = driver.findElement(By.id(LEFT_ARROW_ID));
        this.dateTitle = driver.findElement(By.id(DATE_TITLE_ID));
        this.title = dateTitle.getText();
    }
    public void clickPlusBtn(){
        this.plusBtn.click();
    }
    public boolean checkPoPUpList() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust the timeout as needed
        this.popUpList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(POP_UP_LIST_ID)));
        return popUpList.isDisplayed();
    }
    public void OpenHamburgerMenu(){
        menu.click();
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        hamburgerMenu = new HamburgerMenu(driver);
    }
    public boolean checkHamburgerMenuOpened(){
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return hamburgerMenu.getAbout().isDisplayed();
    }
    public void goToAbout(){
        hamburgerMenu.getAbout().click();
        aboutPage = new AboutPage(driver);
    }
    public boolean checkAbout(){
        return aboutPage.checkAbout();
    }

    public void clickRightArrow(){
        rightArrow.click();
    }
    public void clickLeftArrow(){
        leftArrow.click();
    }
    public boolean checkChangedTitle(){
        return (!title.equals(dateTitle.getText()));
    }
    public boolean checkPending(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.eventsAlert = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(EVENT_ALERT_ID)));
        this.alert = eventsAlert.getText();
        System.out.println(alert);
        return (eventsAlert.isDisplayed());
    }
}
