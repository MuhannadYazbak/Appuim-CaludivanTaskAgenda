package infra;

import org.json.JSONObject;

import java.io.FileReader;

public class ConfigReader {


    ConfigReader configReader = new ConfigReader();
    JSONObject config = configReader.readConfig("config.json");

    public String getPlatformName() {
        return config.getString("platformName");
    }

    public String getDeviceName() {
        return config.getString("appium:deviceName");
    }

    public String getPlatfomrVersion() {
        return config.getString("appium:platformVersion");
    }

    public String getAutomationName() {
        return config.getString("appium:automationName");
    }

    public String getAppPackage() {
        return config.getString("apium:appPackage");
    }

    public String getappActivity() {
        return config.getString("appium:appActivity");
    }


    public JSONObject readConfig(String filePath) {
        try (FileReader reader = new FileReader(filePath)) {
            // Parse the JSON file
            return new JSONObject(reader);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
