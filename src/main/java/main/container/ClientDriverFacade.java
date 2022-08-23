package main.container;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ClientDriverFacade {

    private final static ClientDriverFacade instance = new ClientDriverFacade();

    private final WebDriver driver;

    private ClientDriverFacade() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options());
//        driver = new ChromeDriver();
    }

    public static ClientDriverFacade getInstance() {
        return instance;
    }

    public WebDriver getDriver() {
        return driver;
    }

    private ChromeOptions options() {
//        Map<String, String> mobileEmulation = new HashMap<>();
//        mobileEmulation.put("deviceName", "Nexus 5");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
//        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
        return chromeOptions;
    }
}
