package main.pages;

import io.qameta.allure.Step;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GooglePage extends BasePage {

  private final static String PAGE_URL = "https://google.com/";

  public GooglePage(WebDriver driver) {
    super(driver, PAGE_URL);
  }

  public void search(String searchValue) {
    WebElement element = driver.findElement(By.name("q"));
    element.clear();
    element.sendKeys(searchValue);
    element.sendKeys(Keys.RETURN);
  }

  public void setSearchValue(String searchValue) {
    WebElement element = driver.findElement(By.name("q"));
    element.clear();
    element.sendKeys(searchValue);
  }

  public void clickSearchField() {
    WebElement element = driver.findElement(By.name("q"));
    element.click();
  }

  public boolean hasSearchResultPresent(String searchResult) {
    List<WebElement> cites = driver.findElements(By.tagName("cite"));
    boolean result = false;
    for (WebElement citeElement : cites) {
      if (citeElement.getText().contains(searchResult)) {
        result = true;
      }
    }
    return result;
  }

  public boolean dropDownContains(String value) {
    return driver.findElements(By.xpath("//*[@role='listbox']//li")).stream()
        .map(WebElement::getText).anyMatch(text -> text.contains(value));
  }

  public List<String> getDropDownValues() {
    return driver.findElements(By.xpath("//*[@role='listbox']//li")).stream()
        .map(WebElement::getText).collect(Collectors.toList());
  }

  public WebElement getGoogleLogo() {
    return driver.findElement(By.xpath("//img[@alt='Google']"));
  }

  @Step("Accept temrs and conditions if possible")
  public void acceptTerms() {
    List<WebElement> buttons = driver.findElements(By.tagName("button"));
    if (buttons.size() >= 3) {
      buttons.get(3).sendKeys(Keys.RETURN);
    }
  }
}