package org.app.autotests.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private static final String ERROR_TEMPLATE = "android.widget.TextView[text = '%s']";

    // Локаторы элементов на странице
    private By usernameField = By.xpath("//android.widget.EditText[@resource-id = 'com.alfabank.qapp:id/etUsername']");
    private By passwordField = By.xpath("//android.widget.EditText[@resource-id = 'com.alfabank.qapp:id/etPassword']");
    private By loginButton = By.xpath("//android.widget.Button[@resource-id = 'com.alfabank.qapp:id/btnConfirm']");
    private By showPasswordButton = By.xpath("//android.widget.ImageButton[@resource-id = 'com.alfabank.qapp:id/text_input_end_icon']");

    public LoginPage(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    /**
     * Метод для ввода имени пользователя
     *
     * @param username
     */
    public void enterUsername(String username) {
        AndroidElement usernameElement = driver.findElement(usernameField);
        typeText(usernameElement, username);
    }

    /**
     * Метод для ввода пароля
     *
     * @param password
     */
    public void enterPassword(String password) {
        AndroidElement passwordElement = driver.findElement(passwordField);
        typeText(passwordElement, password);
    }

    /**
     * Метод для нажатия кнопки входа
     */
    public void clickLoginButton() {
        AndroidElement loginButtonElement = driver.findElement(loginButton);
        click(loginButtonElement);
    }

    /**
     * Проверка пароля на маскированность
     *
     * @return Boolean
     */
    public Boolean isPasswordMasked() {
        return Boolean.valueOf(driver.findElement(passwordField).getAttribute("password"));
    }


    /**
     * Метод для выполнения входа
     *
     * @param username
     * @param password
     */
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

    /**
     * Метод для ввода логина и пароля
     *
     * @param username
     * @param password
     */
    public void inputLoginAndPassword(String username, String password) {
        enterUsername(username);
        enterPassword(password);
    }

    /**
     * Проверяет отображения сообщение о ошибке
     *
     * @param msg
     * @return Boolean
     */
    public Boolean errorMsgIsDisplayed(String msg) {
        String locator = String.format(ERROR_TEMPLATE, msg);
        return isElementDisplayed(By.cssSelector(locator), 15L);
    }

    /**
     * Отображение пароля
     */
    public void clickOnShowPasswordButton() {
        AndroidElement showPasswordElement = driver.findElement(showPasswordButton);
        click(showPasswordElement);
    }


    /**
     * Метод для проверки, находится ли пользователь на странице входа
     *
     * @return Boolean
     */
    public Boolean isLoginPageDisplayed() {
        return isElementDisplayed(usernameField) &&
                isElementDisplayed(passwordField) &&
                isElementDisplayed(loginButton);
    }
}
