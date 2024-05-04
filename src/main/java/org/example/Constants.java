package org.example;

import org.openqa.selenium.By;

public class Constants {
    public static class Urls{
        public static final String HOMEPAGE = "https://do.pstu.ru/";
        public static final By USERNAME = By.id("username");
        public static final By PASSWORD = By.id("password");
        public static final By SIGNIN_BY = By.id("kc-login");
        public static final By LOGIN_BY = By.xpath("//a[contains(text(),'Вход')]");
        public static By FIND_COURSE_BY = By.xpath("//a[contains(text(),'Мои курсы')]");
        public static final By WAIT_FIRST_COURSE = By.cssSelector("div[class='card dashboard-card']");
        public static final By CLICK_FIRST_COURSE = By.cssSelector("div[class='card dashboard-card'] a");
        public static final By FIND_PERSONAL_ACCOUNT = By.xpath("//a[contains(text(),'Личный кабинет')]");
        public static final By CLICK_BUTTON_FOR_NEXT = By.cssSelector("li[class='page-item'] a");
        public static final By FIND_ICON = By.cssSelector("div[class='dropdown show']");
        public static final By ClICK_ICON = By.cssSelector("div[class='dropdown show'] a");
        public static final By FIND_ITEMS_FOR_LIST = By.cssSelector(".carousel-item.active a");
        public static final By CLICK_EXIT = By.xpath("//a[contains(text(),'Выход')]");
        public static final By CONFIRM_EXIT = By.cssSelector("div[class='form-group']");
        public static final By ERROR_LOGIN = By.cssSelector("div[id='kc-form-wrapper'] span");
    }
    public static class TimeOutVariable{
        public static final int IMPLICIT_WAIT = 10;
        public static final int EXPLICIT_WAIT = 10;
    }
}
