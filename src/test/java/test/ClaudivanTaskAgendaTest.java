package test;

import infra.AppWrapper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import logic.MainPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.stream.Stream;

public class ClaudivanTaskAgendaTest {
    private final String FIRST_ELEMENT = "(//android.widget.RelativeLayout[@resource-id=\"com.android.settings:id/preference_text_layout\"])[1]";
    private final String AUTO_ROTATE_ELEMENT_XPATH = "//android.widget.ListView[@resource-id=\"android:id/list\"]/android.widget.LinearLayout[9]";
    private final String AUTO_ROTATE_TOGGLE = "//android.widget.LinearLayout[@content-desc=\"פועל\"]";
    private final String DISPLAY_SETTINGS = "//android.widget.ListView[@resource-id='com.android.settings:id/list']/android.widget.LinearLayout[7]/android.widget.LinearLayout";
    private final String AUTO_BRIGHTNESS_SWITCH = "com.android.settings:id/switchWidget";
    private final String SEARCH_ID = "com.android.settings:id/search";
    private final String SEARCH_INPUT_ID = "com.android.settings:id/mc_search_edit";
    private AppiumDriver driver;
    private AppWrapper appWrapper;
    private MainPage mainPage;
    @BeforeEach
    public void setup() {
        System.out.println("Setting up AndroidSettingsTests");
        try {
            this.appWrapper = new AppWrapper();
            this.driver = this.appWrapper.getDriver();
            System.out.println("Driver state after getting from AppWrapper: " + driver);
            mainPage = new MainPage((AndroidDriver) driver);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterEach
    public void teardown() {
        appWrapper.quitDriver();
    }

    @Test
    public void checkClickPlusBtn(){
        mainPage.clickPlusBtn();
    }


    @Test
    public void changeAutoBrightness() {
        WebElement display = driver.findElement(By.xpath(DISPLAY_SETTINGS));
        display.click();
        WebElement autoBrightnessSwitch = driver.findElement(By.id(AUTO_BRIGHTNESS_SWITCH));
        autoBrightnessSwitch.click();
        assert (autoBrightnessSwitch.isEnabled());
    }

    @Test
    public void searchSetting() {
        WebElement searchLogo = driver.findElement(By.id(SEARCH_ID));
        searchLogo.click();
        WebElement searchInput = driver.findElement(By.id(SEARCH_INPUT_ID));
        searchInput.clear();
        searchInput.sendKeys("תצוגה ובהירות");
        WebElement result = driver.findElement(By.id("com.android.settings:id/title"));
        result.click();
        assert (driver.findElement(By.id(AUTO_BRIGHTNESS_SWITCH)).isDisplayed());
    }

    @ParameterizedTest
    @MethodSource("searchKeysProvider")
    void goTo(String key) {
        WebElement searchLogo = driver.findElement(By.id(SEARCH_ID));
        searchLogo.click();
        WebElement searchInput = driver.findElement(By.id(SEARCH_INPUT_ID));
        searchInput.clear();
        searchInput.sendKeys(key);
        WebElement result = driver.findElement(By.id("com.android.settings:id/title"));
        result.click();
        assert (driver.findElement(By.xpath("//android.widget.TextView[@text='" + key + "']")).isDisplayed());

    }

    private static Stream<String> searchKeysProvider() {
        return Stream.of("תצוגה ובהירות", "עוד");
    }

}
