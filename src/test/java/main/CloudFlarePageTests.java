package main;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloudFlarePageTests {

  public static WebDriver driver;


  @BeforeEach
  public void preTest() {
    System.out.println("I am ran before each test");
  }

  @Test
  public void cloudFlareAcceptCookiesTest() {
    System.out.println("Here we go to cloud flare and accept cookies");
  }

  @Test
  public void cloudFlareGoToLoginPageTest() {
    System.out.println("Here we go to cloud flare login after accepting cookies");
  }

  @AfterEach
  public void closeTest() {
    System.out.println("I am ran after each test");
  }

  @AfterAll
  public static void closeUp() {
    System.out.println("This is ran once after all");
  }
}
