package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.example.Constants.TimeOutVariable.*;
import static org.example.Constants.Urls.*;


public class HomePage{
    public static void main(String[] args) throws Exception{
        WebDriver driver = new ChromeDriver();

        driver.get(HOMEPAGE);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT)); // Неявное ожидание

        getTitle(driver);

        login(driver, "nezhdanovad10", "tiMeisup2023@");

        firstCourse(driver);

        print(getMainMemu(driver));

        personalAccount(driver);

        exit(driver, IMPLICIT_WAIT);

        driver.quit();
    }
    // метод для входа в аккаунт
    public static String login(WebDriver driver, String username, String password){
        // явное ожидание
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
        // нажимаем на вход
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(LOGIN_BY));
        loginButton.click();
        driver.findElement(USERNAME).sendKeys(username); // вводим логин
        driver.findElement(PASSWORD).sendKeys(password); // вводим пароль

        driver.findElement(SIGNIN_BY).click(); // нажимаем на вход

        return username;
    }
    // метод, который получает название сайта
    public static void getTitle(WebDriver driver){
        System.out.println("Заголовок сайта: " + driver.getTitle());
    }
    // метод, с помощью которого заходит на курс
    public static void firstCourse(WebDriver driver) throws Exception{
        // явное ожидание
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
        // Попытка найти и нажать на вкладку "Мои курсы"
        try {
            WebElement findCourse = wait.until(ExpectedConditions.elementToBeClickable(FIND_COURSE_BY));
            findCourse.click();
        } catch (Exception e) {
            throw new ErrorPage("Не удалось перейти");
        }
        // подождем, пока страница загрузится после нажатия на "Мои курсы"
        wait.until(ExpectedConditions.visibilityOfElementLocated(WAIT_FIRST_COURSE));

        // найдем первый курс и кликнем по нему
        WebElement firstCourse = driver.findElement(CLICK_FIRST_COURSE);
        firstCourse.click();
    }
    // метод, который заходит во вкладку "Личный кабинет"
    public static void personalAccount(WebDriver driver) throws Exception{
        // явное ожидание
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
        try {
            // находим вкладку "Личный кабинет" и кликаем на нее
            WebElement clickAccount = wait.until(ExpectedConditions.elementToBeClickable(FIND_PERSONAL_ACCOUNT));
            clickAccount .click();
        }catch (Exception e){
            throw new ErrorPage("Не удалось перейти");
        }
        // нажимаем на стрелочку дальше в "Недавно посещенные курсы"
        driver.findElement(CLICK_BUTTON_FOR_NEXT).click();
    }
    // метод, с помощью которого выводит список из элементов главного меню
    public static List<WebElement> getMainMemu(WebDriver driver){
        // явное ожидание
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
        // нажимаем на иконку пользователя
        wait.until(ExpectedConditions.visibilityOfElementLocated(FIND_ICON));
        driver.findElement(ClICK_ICON).click();
        // лист для хранения элементов главного меню
        List<WebElement> mainmenus = driver.findElements(FIND_ITEMS_FOR_LIST);

        //возвращаем лист
        return mainmenus;
    }
    // метод, с помощью которого осуществляется выход из аккаунта
    public static String exit(WebDriver driver, int time) throws Exception{
        // явное ожидание
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
        // нажимаем на иконку пользователя
        wait.until(ExpectedConditions.visibilityOfElementLocated(FIND_ICON));
        driver.findElement(ClICK_ICON).click();
        // находим кнопку выхода и кликаем по ней
        WebElement exitButton = wait.until(ExpectedConditions.elementToBeClickable(CLICK_EXIT));
        exitButton.click();
        driver.findElement(CONFIRM_EXIT).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
        if (time < 10){
            throw new ErrorExit("Ожидание меньше 10 секунд");
        }

        return driver.getCurrentUrl();
    }
    // метод для вывода элементов списка в консоль
    public static void print(List<WebElement> arr){
        System.out.println("Список элементов главного меню:");
        for (WebElement item : arr) {
            System.out.println(item.getText());
        }
    }
    public static boolean errorOfLogin(WebDriver driver, By errorLocator) throws Exception{
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
            WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(errorLocator));
            if (error.getText().equals("Неправильное имя пользователя или пароль.")) {
                throw new ErrorLogin("Вы ввели неверный пароль или логин");
            }
            return false; // Ошибка не обнаружена
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("Сообщение об ошибке не найдено.");
            return true; // Ошибка обнаружена
        }
    }
    public static class ErrorLogin extends Exception {
        public ErrorLogin(String message){
            super(message);
        }
    }
    public static class ErrorPage extends Exception {
        public ErrorPage(String message){
            super(message);
        }
    }
    public static class ErrorExit extends Exception {
        public ErrorExit(String message){
            super(message);
        }
    }
}