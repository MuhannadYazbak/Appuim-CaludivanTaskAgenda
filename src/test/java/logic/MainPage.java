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
    private final String HAMBURGER_MENU_ID = "com.claudivan.taskagenda:id/hamburguer";
    private WebElement plusBtn;
   private WebElement popUpList;
   private WebElement menu;
   private HamburgerMenu hamburgerMenu;
   private AboutPage aboutPage;

    public MainPage(AndroidDriver driver) {
        super(driver);
        this.plusBtn = driver.findElement(By.id(PLUS_BUTTON_ID));
        this.menu = driver.findElement(By.id(HAMBURGER_MENU_ID));
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
}
