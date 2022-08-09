package main.pages;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    protected WebDriver driver;
    private String url;

    public BasePage(WebDriver driver, String url) {
        this.driver = driver;
    }

    public void loadPage() {
        driver.get(url);
    }
}