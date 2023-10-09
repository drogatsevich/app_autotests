package org.app.autotests.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {

    protected AndroidDriver<AndroidElement> driver;

    /**
     * Инициализация Андроид драйвера
     */
    public void initializeAndroidDriver() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", TestConfig.PLATFORM_NAME);
        caps.setCapability("deviceName", TestConfig.DEVICE_NAME);
        caps.setCapability("appPackage", TestConfig.APP_PACKAGE); // пакет приложения
        caps.setCapability("appActivity", TestConfig.APP_ACTIVITY); // активность приложения
        caps.setCapability("automationName", TestConfig.AUTOMATION_NAME);
        caps.setCapability("uiautomator2ServerLaunchTimeout", TestConfig.UIAUTOMATOR_2_SERVER_LAUNCH_TIMEOUT);
        caps.setCapability("app", TestConfig.APP);

        try {
            driver = new AndroidDriver<>(new URL(TestConfig.APPIUM_SERVER_URL), caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to initialize Appium driver");
        }
    }

    /**
     * Закрыть драйвер
     */
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    /**
     * Получить драйвер
     *
     * @return AndroidDriver<AndroidElement>
     */
    public AndroidDriver<AndroidElement> getDriver() {
        if (driver == null) {
            initializeAndroidDriver();
        }
        return driver;
    }
}
