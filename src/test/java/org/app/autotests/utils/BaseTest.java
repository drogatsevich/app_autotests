package org.app.autotests.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class BaseTest {

    private DriverManager driverManager = new DriverManager();

    protected AndroidDriver<AndroidElement> driver;

    public void setUp() {
        driverManager.initializeAndroidDriver();
        driver = driverManager.getDriver();
    }

    @AfterClass
    public void tearDown() {
        driverManager.quitDriver();
    }

    @AfterMethod
    public void resetApp() {
        // Закрыть приложение после каждого теста
        driver.resetApp();
    }
}
