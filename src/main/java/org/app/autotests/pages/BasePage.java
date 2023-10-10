package org.app.autotests.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected AndroidDriver<AndroidElement> driver;
    private WebDriverWait wait;

    public BasePage(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }


    /**
     * Метод для ожидания видимости элемента на экране
     *
     * @param element
     */
    protected void waitForVisibility(AndroidElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Метод для клика по элементу
     *
     * @param element
     */
    protected void click(AndroidElement element) {
        waitForVisibility(element);
        element.click();
    }

    /**
     * Метод для ввода текста в поле ввода
     *
     * @param element
     * @param text
     */
    protected void typeText(AndroidElement element, String text) {
        waitForVisibility(element);
        element.sendKeys(text);
    }

    /**
     * Метод для получения текста элемента
     *
     * @param element
     * @return String
     */
    protected String getText(AndroidElement element) {
        waitForVisibility(element);
        return element.getText();
    }


    /**
     * Метод для проверки наличия элемента на экране
     *
     * @param by
     * @return Boolean
     */
    protected Boolean isElementDisplayed(By by) {
        try {
            return driver.findElement(by).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Метод для проверки наличия элемента на экране
     * @param by
     * @param timeOutInSeconds
     * @return Boolean
     */
    public Boolean isElementDisplayed(By by, Long timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return driver.findElement(by).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}