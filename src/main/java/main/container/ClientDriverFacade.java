package main.container;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ClientDriverFacade {

  private final static ClientDriverFacade instance = new ClientDriverFacade();

  private final WebDriver driver;

  private ClientDriverFacade() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver((ChromeOptions) BrowserOptionsFactory.getInstance().getOptions("Chrome"));
  }

  public static ClientDriverFacade getInstance() {
    return instance;
  }

  public WebDriver getDriver() {
    return driver;
  }

  public void takeScreenshot(String fileName) throws IOException {
    File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    // Now you can do whatever you need to do with it, for example copy somewhere
    File screenShot = new File(fileName + ".png");
    //clean up if file exists
    if (screenShot.exists()) {
      screenShot.delete();
    }
    FileUtils.copyFile(scrFile, screenShot);
  }
}
