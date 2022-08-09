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
        .until(ExpectedConditions.presenceOfElementLocated(CloudFlareObjects.COOKIES_TITLE.getSelector()));
  }

  public void waitForCookiesToDisappear() {
    new WebDriverWait(driver, Duration.ofSeconds(1))
        .until(ExpectedConditions.invisibilityOfElementLocated(CloudFlareObjects.COOKIES_TITLE.getSelector()));
  }

  public void acceptCookies() {
    clickElement(CloudFlareObjects.ACCEPT_COOKIES_BTN);
//    new WebDriverWait(driver, Duration.ofSeconds(5))
//        .until(ExpectedConditions.elementToBeClickable(CloudFlareObjects.ACCEPT_COOKIES_BTN.getSelector())).click();
  }

  public void logIn() {
    driver.findElement(CloudFlareObjects.LOG_IN_BTN.getSelector()).click();
  }

  public WebElement waitForLoginForm() {

    return new WebDriverWait(driver, Duration.ofSeconds(5))
        .until(ExpectedConditions.presenceOfElementLocated(CloudFlareObjects.EMAIL.getSelector()));
  }

  public WebElement waitForPasswordForm() {
    return new WebDriverWait(driver, Duration.ofSeconds(5))
        .until(ExpectedConditions.presenceOfElementLocated(CloudFlareObjects.PASSWORD.getSelector()));
  }

  // Given click COOKIES_TITLE
  public enum CloudFlareObjects implements IClickable {
    COOKIES_TITLE(By.id("onetrust-policy-title"), false),
    ACCEPT_COOKIES_BTN(By.id("onetrust-accept-btn-handler"), false),
    LOG_IN_BTN(By.linkText("Log In"), true),
    EMAIL(By.id("email"), false),
    PASSWORD(By.id("password"), false);

    private By selector;
    private boolean clickWithKeyboard;

    CloudFlareObjects(By selector, boolean clickWithKeyboard) {
      this.selector = selector;
      this.clickWithKeyboard = clickWithKeyboard;
    }

    public By getSelector() {
      return selector;
    }

    public boolean isClickWithKeyboard() {
      return clickWithKeyboard;
    }
  }
}
