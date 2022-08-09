package main;

import main.container.ClientDriverFacade;
import main.container.OperatorDriverFacade;
import main.pages.GooglePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class GooglePageTest {
  private final WebDriver clientDriver = ClientDriverFacade.getInstance().getDriver();
  private final WebDriver operatorDriver = OperatorDriverFacade.getInstance().getDriver();
  private final GooglePage googlePage = new GooglePage(clientDriver);

  @BeforeEach
  public void resetPage() {
    clientDriver.get("about:blank");
  }

  @Test
  public void dropDownTest() {
    googlePage.loadPage();
    googlePage.acceptTerms();

    googlePage.setSearchValue("twitter");
    googlePage.clickSearchField();

    validateDropdownContent(googlePage, "Twitter Inc.", true);
    validateDropdownContent(googlePage, "twitter stock", true);
    validateDropdownContent(googlePage, "twitter elon musk", true);
    validateDropdownContent(googlePage, "twitter non existent", false);
  }

  @Test
  public void googleSearchTest() {
    googlePage.loadPage();
    googlePage.acceptTerms();
    googlePage.search("twitter");
    Assertions.assertTrue(googlePage.hasSearchResultPresent("https://twitter.com"), "Search is present on page");
  }

  private void validateDropdownContent(GooglePage googlePage, String value, boolean isPresent) {
    Assertions.assertEquals(isPresent, googlePage.dropDownContains(value),
        String.format("Failed to find record '%s' in search bar dropdown", value));
  }
}
