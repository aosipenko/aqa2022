package main.container;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;
import org.openqa.selenium.safari.SafariOptions;

public class BrowserOptionsFactory {

  private final static BrowserOptionsFactory instance = new BrowserOptionsFactory();

  private BrowserOptionsFactory() {
  }

  public static BrowserOptionsFactory getInstance() {
    return instance;
  }

  public AbstractDriverOptions getOptions(String browserName) {
    switch (browserName) {
      case "Firefox":
        return getFFOptions();
      case "Chrome":
        return getChromeOptions();
      case "Edge":
        return getEdgeOptions();
      default:
        return new SafariOptions();
    }
  }

  private ChromeOptions getChromeOptions() {
    Map<String, String> mobileEmulation = new HashMap<>();
    mobileEmulation.put("deviceName", "Nexus 5");
    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.addArguments("start-maximized");
    chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
    return new ChromeOptions();
  }

  private FirefoxOptions getFFOptions() {
    return new FirefoxOptions();
  }

  private EdgeOptions getEdgeOptions() {
    return new EdgeOptions();
  }

}
