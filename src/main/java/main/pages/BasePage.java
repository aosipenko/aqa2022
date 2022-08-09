package main.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class BasePage {

  protected final WebDriver driver;
  private final String url;

  public BasePage(WebDriver driver, String url) {
    this.driver = driver;
    this.url = url;
  }

  public void loadPage() {
    driver.get(url);
  }

  public void clickElement(IClickable clickable) {

    if (clickable.isClickWithKeyboard()) {
      driver.findElement(clickable.getSelector()).sendKeys(Keys.RETURN);
    } else {
      JSClick(driver.findElement(clickable.getSelector()));
    }
  }

  public void setElementValue(boolean usingManualCleanUp, WebElement element, String value) {
    if (usingManualCleanUp) {
      element.sendKeys(Keys.END);
      for (int i = 0; i < element.getText().length(); i++) {
        element.sendKeys(Keys.BACK_SPACE);
      }
    } else {
      element.clear();
      element.sendKeys(value);
    }
  }

  protected void scrollToElement(WebElement element) {
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
  }

  protected void JSClick(WebElement element) {
    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
  }
}
