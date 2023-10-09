package org.app.autotests.tests;

import org.app.autotests.pages.HomePage;
import org.app.autotests.pages.LoginPage;
import org.app.autotests.utils.BaseTest;
import org.testng.annotations.*;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class AuthorizationTests extends BaseTest {

    private LoginPage loginPage;
    private HomePage homePage;

    @BeforeClass
    public void setUp() {
        super.setUp();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    @Test(description = "Попытка войти без заполнения полей")
    public void testLoginWithoutEnteringFields() {
        // Попытка войти без заполнения полей
        loginPage.clickLoginButton();

        // Проверка: Валидационные сообщения для полей Логин и Пароль должны быть видимы
        assertTrue(loginPage.errorMsgIsDisplayed("Введены неверные данные"));

        // Отображается старница авторизации
        assertTrue(loginPage.isLoginPageDisplayed());
    }

    @Test(description = "Попытка войти с некорректным логином")
    public void testLoginWithInvalidLogin() {
        // Попытка войти с некорректным логином
        loginPage.login("Login@123", "Password");

        // Проверка: Валидационные сообщения для поля Логин
        assertTrue(loginPage.errorMsgIsDisplayed("Введены неверные данные"));

        // Отображается старница авторизации
        assertTrue(loginPage.isLoginPageDisplayed());
    }

    @Test(description = "Попытка войти с некорректным паролем")
    public void testLoginWithInvalidPassword() {
        // Попытка войти с некорректным паролем
        loginPage.login("Login", "Password@123");

        // Проверка: Валидационные сообщения для поля Пароль
        assertTrue(loginPage.errorMsgIsDisplayed("Введены неверные данные"));

        // Отображается старница авторизации
        assertTrue(loginPage.isLoginPageDisplayed());
    }

    @Test(description = "Успешная авторизация")
    public void testLoginWithValidCredentials() {
        // Успешная авторизация
        loginPage.login("Login", "Password");

        // Произошел переход на страницу "Вход в Alfa-Test выполнен"
        assertTrue(homePage.labelIsDisplayed());
    }

    @Test(description = "Проверка маскирования пароля")
    public void testPasswordMasking() {
        // Ввести корректный логин в поле "Логин"
        loginPage.inputLoginAndPassword("Login", "Password");

        // Проверить, что в поле "Пароль" символы маскируются символом '•'
        assertTrue(loginPage.isPasswordMasked());

        // Нажать на значок, чтобы сделать символы видимыми
        loginPage.clickOnShowPasswordButton();

        // Проверить, что символы стали видимыми
        assertFalse(loginPage.isPasswordMasked());

        // Снова нажать на значок, чтобы маскировать символы
        loginPage.clickOnShowPasswordButton();

        // Проверить, что символы снова стали скрытыми
        assertTrue(loginPage.isPasswordMasked());
    }
}
