package infra;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.http.HttpClient;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class AppWrapper {

    private AppiumDriver driver;

    public AppWrapper() throws MalformedURLException {
        DesiredCapabilities capabilities = readCapabilities("config.json");
        String appiumServerUrl = readAppiumServerUrl("config.json");
        initializeDriver(capabilities, appiumServerUrl);
    }

    public AppiumDriver getDriver() {
        return driver;
    }

    private void initializeDriver(DesiredCapabilities capabilities, String appiumServerUrl) {
        try {
            System.out.println("Before initializing driver");
            driver = new AndroidDriver(new URL(appiumServerUrl), capabilities);
            System.out.println("Driver state after initializing DesiredCapabilities: " + driver);
        } catch (MalformedURLException e) {
            System.out.println("Error initializing driver: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private DesiredCapabilities readCapabilities(String configFile) {
        try (InputStream inputStream = new FileInputStream(configFile)) {
            org.json.JSONObject jsonConfig = new org.json.JSONObject(new String(inputStream.readAllBytes()));
            org.json.JSONObject desiredCapabilitiesJson = jsonConfig.getJSONObject("desiredCapabilities");
            return new DesiredCapabilities(desiredCapabilitiesJson.toMap());
        } catch (Exception e) {
            throw new RuntimeException("Failed to read capabilities from the config file.", e);
        }
    }

    private String readAppiumServerUrl(String configFile) {
        try (InputStream inputStream = new FileInputStream(configFile)) {
            org.json.JSONObject jsonConfig = new org.json.JSONObject(new String(inputStream.readAllBytes()));
            return jsonConfig.getString("appiumServerUrl");
        } catch (Exception e) {
            throw new RuntimeException("Failed to read Appium server URL from the config file.", e);
        }
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
