package main.container;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ClientDriverFacade {

  private final static ClientDriverFacade instance = new ClientDriverFacade();

  private final WebDriver driver;

  private ClientDriverFacade() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    DesiredCapabilities capabilities = new DesiredCapabilities();
  }

  public static ClientDriverFacade getInstance() {
    return instance;
  }

  public WebDriver getDriver() {
    return driver;
  }
}
