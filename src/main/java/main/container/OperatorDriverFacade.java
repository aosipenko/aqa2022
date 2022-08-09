package main.container;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class OperatorDriverFacade {

  private final static OperatorDriverFacade instance = new OperatorDriverFacade();

  private final WebDriver driver;

  private OperatorDriverFacade() {

    //client.driver = FIREFOX;
    DriverName driverType = DriverName.valueOf(System.getProperty("client.driver"));
    switch (driverType) {
      case EDGE:
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        break;
      default:
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
  }

  public static OperatorDriverFacade getInstance() {
    return instance;
  }

  public WebDriver getDriver() {
    return driver;
  }
}
