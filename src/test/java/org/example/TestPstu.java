package org.example;

import org.testng.annotations.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.example.Constants.TimeOutVariable.IMPLICIT_WAIT;
import static org.example.Constants.Urls.*;


public class TestPstu {
    protected WebDriver driver;
    private final String username = "nezhdanovad10";
    private final String password = "tiMeisup2023@";

    @BeforeMethod (alwaysRun = true)
    public void openMainPage () {
        driver = new ChromeDriver();
        driver.get(HOMEPAGE);
    }

    @AfterMethod (alwaysRun = true)
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
    @Test (groups = "positive")
    public void testLoginPositive(){
        String actualResult;
        String expectedResult = username;

        actualResult = HomePage.login(driver, username, password);

        Assert.assertEquals(actualResult, expectedResult);
    }
    @Test (expectedExceptions= {HomePage.ErrorLogin.class}, groups = "negative")
    public void testLoginNegative() throws Exception{
        String usernameError = "nezhdanovad10";
        String passwordError = "tiMeisup2023";

        HomePage.login(driver, usernameError, passwordError);
        HomePage.errorOfLogin(driver, ERROR_LOGIN);
    }
    @Test (groups = "positive")
    public void testFirstCoursePositive() throws Exception{
        HomePage.login(driver, username, password);
        String expectedResult = "https://do.pstu.ru/course/view.php?id=363";
        String actualResult;

        HomePage.firstCourse(driver);

        actualResult = driver.getCurrentUrl();

        Assert.assertEquals(actualResult, expectedResult);
    }
    @Test (expectedExceptions= {HomePage.ErrorPage.class}, groups = "negative")
    public void testFirstCourseNegative() throws Exception{
        HomePage.firstCourse(driver);
    }
    @Test (groups = "positive")
    public void testGetMainMenu(){
        HomePage.login(driver, username, password);
        List<WebElement> actualElements = HomePage.getMainMemu(driver);
        List<String> actualResult = new ArrayList<>();
        List<String> expectedResult = Arrays.asList(
                "О пользователе", "Оценки", "Календарь", "Сообщения",
                "Личные файлы", "Отчеты", "Настройки", "Язык", "Выход"
        );

        // Преобразование веб-элементов в строки
        for (WebElement element : actualElements) {
            actualResult.add(element.getText());
        }

        Assert.assertEquals(actualResult, expectedResult);
    }
    @Test (groups = "positive")
    public void testExitPositive() throws Exception{
        String actualResult;
        String expectedResult = HOMEPAGE;
        HomePage.login(driver, username, password);

        HomePage.exit(driver, IMPLICIT_WAIT);

        actualResult = driver.getCurrentUrl();

        Assert.assertEquals(actualResult, expectedResult);
    }
    @Test(expectedExceptions = {HomePage.ErrorExit.class}, groups = "negative")
    public void testExitNegative() throws Exception {
        HomePage.login(driver, username, password);

        HomePage.exit(driver, 2);
    }
    @Test (expectedExceptions = {HomePage.ErrorPage.class}, groups = "negative")
    public void testPersonalAccountNegative() throws Exception{
        HomePage.personalAccount(driver);
    }
}