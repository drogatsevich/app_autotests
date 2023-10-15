package org.app.autotests.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class BaseTest {

    protected AndroidDriver<AndroidElement> driver;

    public void setUp() {
        DriverManager.getInstance().initializeAndroidDriver();
        driver = DriverManager.getInstance().getDriver();
    }

    @AfterClass
    public void tearDown() {
        DriverManager.getInstance().quitDriver();
    }

    /**
     * Закрыть приложение после каждого теста
     */
    @AfterMethod
    public void resetApp() {
        driver.resetApp();
    }
}
