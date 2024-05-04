package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Scripts {
    @Test
    public void testNGGoogle() {
        WebDriver driver = new ChromeDriver(); // Запуск браузера

        driver.get("https://testng.org/"); // Переходим на веб-страницу
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2)); // Неявное ожидание

        // Явное ожидание заголовка страницы
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> d.getTitle().startsWith("TestNG"));

        System.out.println("Title: " + driver.getTitle());

        // Явное ожидание видимости элемента содержания
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toc")));

        // Поиск и вывод списка ссылок содержания (Table of Contents)
        List<WebElement> tocLinks = driver.findElements(By.cssSelector("#toc ul li a"));
        System.out.println("Список названий ссылок содержания (Table of Contents):");
        for (WebElement tocLink : tocLinks) {
            System.out.println(tocLink.getAttribute("textContent"));
        }
        // через css селекторы
//         WebElement firstTocLink = tocLinks.get(6);
//         firstTocLink.click();
        // через xpath
        WebElement firstTocLink = driver.findElement(By.xpath("//div[@id='toc']//ul//li[3]//a"));
        firstTocLink.click();

        //driver.quit(); // Закрываем браузер
    }
    @Test
    public void testNGEdge() {
        WebDriver driver = new EdgeDriver();

        driver.get("https://testng.org/"); // Переходим на веб-страницу
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2)); // Неявное ожидание

        // Явное ожидание заголовка страницы
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> d.getTitle().startsWith("TestNG"));

        System.out.println("Title: " + driver.getTitle());

        // Явное ожидание видимости элемента содержания
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toc")));

        // Поиск и вывод списка ссылок содержания (Table of Contents)
        List<WebElement> tocLinks = driver.findElements(By.cssSelector("#toc ul li a"));
        System.out.println("Список названий ссылок содержания (Table of Contents):");
        for (WebElement tocLink : tocLinks) {
            System.out.println(tocLink.getAttribute("textContent"));
        }
        // через css селекторы
//         WebElement firstTocLink = tocLinks.get(6);
//         firstTocLink.click();
        // через xpath
        WebElement firstTocLink = driver.findElement(By.xpath("//div[@id='toc']//ul//li[3]//a"));
        firstTocLink.click();

        driver.quit(); // Закрываем браузер
    }
    @Test
    public void Trade59Google(){
        WebDriver driver = new ChromeDriver();

        driver.get("https://trade59.ru/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2)); // Неявное ожидание

        // Явное ожидание заголовка страницы
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> d.getTitle().startsWith("Интернет"));

        System.out.println("Title: " + driver.getTitle());

        // Явное ожидание видимости элементов каталога
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("menu-top")));

        // Поиск и вывод списка элементов каталога
        List<WebElement> mainmenus = driver.findElements(By.cssSelector(".main_menu"));
        System.out.println("Список элементов главного меню:");
        for (WebElement item : mainmenus) {
            System.out.println(item.getAttribute("textContent"));
        }

        // через css селекторы
//        WebElement firctClink = mainmenus.get(6);
//        firctClink.click();

        // через xpath
        WebElement firctClink = driver.findElement(By.xpath("//div[@class='menu-top']//a[3]"));
        firctClink.click();

        driver.quit(); // Закрываем браузер
    }
    @Test
    public void Trade59Edge(){
        WebDriver driver = new EdgeDriver();

        driver.get("https://trade59.ru/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2)); // Неявное ожидание

        // Явное ожидание заголовка страницы
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> d.getTitle().startsWith("Интернет"));

        System.out.println("Title: " + driver.getTitle());

        // Явное ожидание видимости элементов каталога
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("menu-top")));

        // Поиск и вывод списка элементов каталога
        List<WebElement> mainmenus = driver.findElements(By.cssSelector(".main_menu"));
        System.out.println("Список элементов главного меню:");
        for (WebElement item : mainmenus) {
            System.out.println(item.getAttribute("textContent"));
        }

        // через css селекторы
//        WebElement firctClink = mainmenus.get(6);
//        firctClink.click();

        // через xpath
        WebElement firctClink = driver.findElement(By.xpath("//div[@class='menu-top']//a[3]"));
        firctClink.click();

        driver.quit(); // Закрываем браузер
    }
    @Test
    public void PstuGoogle(){
        WebDriver driver = new ChromeDriver();

        driver.get("https://pstu.ru/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2)); // Неявное ожидание

        // Явное ожидание заголовка страницы
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> d.getTitle().startsWith("Пермский"));

        System.out.println("Title: " + driver.getTitle());

        // Явное ожидание видимости элементов каталога
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("target_groups_contaner")));

        // Поиск и вывод списка элементов каталога
        List<WebElement> mainmenus = driver.findElements(By.cssSelector(".target_groups ul li a"));
        System.out.println("Список элементов главного меню:");
        for (WebElement item : mainmenus) {
            System.out.println(item.getAttribute("textContent"));
        }

        // через css селекторы
//        WebElement firctClink = mainmenus.get(4);
//        firctClink.click();

        // через xpath
        WebElement firstTocLink = driver.findElement(By.xpath("//div[@class='target_groups']//ul//li[3]//a"));
        firstTocLink.click();

        driver.quit(); // Закрываем браузер
    }
    @Test
    public void PstuEdge(){
        WebDriver driver = new EdgeDriver();

        driver.get("https://pstu.ru/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2)); // Неявное ожидание

        // Явное ожидание заголовка страницы
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> d.getTitle().startsWith("Пермский"));

        System.out.println("Title: " + driver.getTitle());

        // Явное ожидание видимости элементов каталога
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("target_groups_contaner")));

        // Поиск и вывод списка элементов каталога
        List<WebElement> mainmenus = driver.findElements(By.cssSelector(".target_groups ul li a"));
        System.out.println("Список элементов главного меню:");
        for (WebElement item : mainmenus) {
            System.out.println(item.getAttribute("textContent"));
        }

        // через css селекторы
//        WebElement firctClink = mainmenus.get(4);
//        firctClink.click();

        // через xpath
        WebElement firctLink = driver.findElement(By.xpath("//div[@class='target_groups']//ul//li[3]//a"));
        firctLink.click();

        driver.quit(); // Закрываем браузер
    }
}