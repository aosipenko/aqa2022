package main;

import io.github.bonigarcia.wdm.WebDriverManager;
import main.container.ClientDriverFacade;
import main.pages.TelenorPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {


  public static void main(String... args) throws InterruptedException {
    WebDriverManager.chromedriver().setup();
    WebDriver chrome = new ChromeDriver();

    TelenorPage telenorPage = new TelenorPage(chrome);
    telenorPage.loadPage();

    telenorPage.scrollToFooter();

    ClientDriverFacade.getInstance();
  }

  public void someTest(){

  }
}