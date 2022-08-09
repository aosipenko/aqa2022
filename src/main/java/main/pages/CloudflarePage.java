package main.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CloudflarePage extends BasePage {

    private final static String PAGE_URL = "https://www.cloudflare.com/";

    public CloudflarePage(WebDriver driver) {
        super(driver, PAGE_URL);
    }

    public WebElement waitForCookies() {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("onetrust-policy-title")));
    }

    public void waitForCookiesToDisappear() {
        new WebDriverWait(driver, Duration.ofSeconds(1))
                .until(ExpectedConditions.invisibilityOfElementLocated(By.id("onetrust-policy-title")));
    }

    public void acceptCookies() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.id("onetrust-accept-btn-handler"))).click();
    }

    public void logIn() {
        driver.findElement(By.linkText("Log In")).click();
    }

    public WebElement waitForLoginForm() {
        return new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("email")));
    }

    public WebElement waitForPasswordForm() {
        return new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("password")));
    }
}