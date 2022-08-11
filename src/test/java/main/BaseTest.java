package main;

import main.container.ClientDriverFacade;
import org.openqa.selenium.WebDriver;

public abstract class BaseTest {

  protected final static WebDriver driver = ClientDriverFacade.getInstance().getDriver();
}
