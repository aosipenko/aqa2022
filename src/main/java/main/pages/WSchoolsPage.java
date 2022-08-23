package main.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WSchoolsPage extends BasePage {

    private final static String url = "https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_height_width";

    private IFrameElements iFrameElements;

    public WSchoolsPage(WebDriver driver) {
        super(driver, url);
    }

    public void acceptCookies() {
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("accept-choices"))).click();
    }

    public WebElement getRightSideContent() {
        return driver.findElement(By.id("iframeResult"));
    }

    public IFrameElements swicthToContentRight() {
        driver.switchTo().frame(driver.findElement(By.id("iframeResult")));
        return iFrameElements;
    }

    public IFrameElements getiFrameElements() {
        return iFrameElements;
    }


    public class IFrameElements {
        private WebDriver driver;

        public IFrameElements(WebDriver driver) {
            this.driver = driver;
        }

        public WebElement getIframeInner() {
            return driver.findElement(By.xpath("//*[@title='Iframe Example']"));
        }
    }
}
