package org.app.autotests.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

public class HomePage extends BasePage{

    private By labelAlphaBank = By.cssSelector("android.widget.TextView[text^='Вход в Alfa-Test выполнен']");
    public HomePage(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    /**
     * Отображение логотипа
     * @return Boolean
     */
    public Boolean labelIsDisplayed() {
        return isElementDisplayed(labelAlphaBank, 15L);
    }
}
