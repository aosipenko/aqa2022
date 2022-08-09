package main.pages;

import java.util.List;
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

    public void acceptTerms() {
        List<WebElement> buttons = driver.findElements(By.tagName("button"));
        buttons.get(3).click();
    }
}