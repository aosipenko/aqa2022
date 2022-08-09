package main.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TelenorPage extends BasePage {

  private final static String URL = "https://telenor.se/";

  public TelenorPage(WebDriver driver) {
    super(driver, URL);
  }

  public void scrollToFooter() {
    scrollToElement(driver.findElement(By.className("page-footer__bottom-bar")));
  }
}
