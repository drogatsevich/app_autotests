package org.app.autotests.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static ConfigReader instance;
    private Properties properties;

    private ConfigReader() {
        properties = new Properties();
        try {
            FileInputStream inputStream = new FileInputStream("config.properties");
            properties.load(inputStream);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ConfigReader getInstance() {
        if (instance == null) {
            instance = new ConfigReader();
        }
        return instance;
    }

    public String getDeviceName() {
        return properties.getProperty("device.name");
    }

    public String getAppPackage() {
        return properties.getProperty("app.package");
    }

    public String getAppActivity() {
        return properties.getProperty("app.activity");
    }

    public String getAppiumServerUrl() {
        return properties.getProperty("appium.server.url");
    }

    public String getPlatformName() {
        return properties.getProperty("platform.name");
    }

    public String getAutomationName() {
        return properties.getProperty("automation.name");
    }

    public String getUiAutomator2ServerLaunchTimeout() {
        return properties.getProperty("uiautomator2.server.launch.timeout");
    }

    public String getAppPath() {
        return properties.getProperty("app.path");
    }
}
