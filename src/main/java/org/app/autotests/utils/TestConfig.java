package org.app.autotests.utils;

public class TestConfig {
    public static final String DEVICE_NAME = ConfigReader.getInstance().getDeviceName();
    public static final String APP_PACKAGE = ConfigReader.getInstance().getAppPackage();
    public static final String APP_ACTIVITY = ConfigReader.getInstance().getAppActivity();
    public static final String APPIUM_SERVER_URL = ConfigReader.getInstance().getAppiumServerUrl();
    public static final String PLATFORM_NAME = ConfigReader.getInstance().getPlatformName();
    public static final String AUTOMATION_NAME = ConfigReader.getInstance().getAutomationName();
    public static final String UIAUTOMATOR_2_SERVER_LAUNCH_TIMEOUT = ConfigReader.getInstance().getUiAutomator2ServerLaunchTimeout();
    public static final String APP = ConfigReader.getInstance().getAppPath();

}