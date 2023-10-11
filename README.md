# Тестовый проект

## Установка и настройка

Прежде чем запустить тесты, вам понадобится:

1. Установить Java Development Kit (JDK) 8 версии.
2. Установить Maven.
3. Установить Appium Server и настроить его.
4. Установить Android SDK и настроить эмулятор или физическое устройство.

После этого:

1. Клонируйте репозиторий: `git clone`
2. Отредактируйте файл config.properties, указав настройки для Appium, Android и приложения.
3. Запустите тесты: `mvn clean test`
4. Отчет: `target\surefire-reports\index.html`
