package test;

import infra.AppWrapper;
import infra.TestContext;
import infra.TestContextParameterResolver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import logic.MainPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(TestContextParameterResolver.class)
public class ClaudivanTaskAgendaTest {
    private AppiumDriver driver;
    private AppWrapper appWrapper;
    private MainPage mainPage;
    public TestContext context;

    public ClaudivanTaskAgendaTest(TestContext context) {
        this.context = context;
    }

    @BeforeEach
    public void setup() {
        System.out.println("Setting up AndroidSettingsTests");
        try {
            this.appWrapper = new AppWrapper();
            this.driver = this.appWrapper.getDriver();
            context.put("driver", driver);
            System.out.println("Driver state after getting from AppWrapper: " + driver);
            //Arange
            mainPage = new MainPage((AndroidDriver) context.get("driver"));
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
        //Act
        mainPage.clickPlusBtn();
        //Assert
        assertTrue(mainPage.checkPoPUpList());

    }
    @Test
    public void openHamburgerMenu(){
        //Act
        mainPage.OpenHamburgerMenu();
        //Assert
        assertTrue(mainPage.checkHamburgerMenuOpened());
    }

    @Test
    public void goToAbout(){
        //Act
        mainPage.OpenHamburgerMenu();
        mainPage.goToAbout();
        //Assert
        assertTrue(mainPage.checkAbout());
    }
    @ParameterizedTest
    @MethodSource("leftOrRight")
    public void changeWeek(String direction){
        //Act
        if(direction.equals("right"))
        mainPage.clickRightArrow();
        else mainPage.clickLeftArrow();
        //Assert
        assert(mainPage.checkChangedTitle());
    }
    private static Stream<String> leftOrRight(){
        return  Stream.of("left", "right");
    }



}
