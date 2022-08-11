package main;

import java.util.List;
import main.pages.GooglePage;
import org.testng.annotations.Test;

public class GooglePageTest extends BaseTest {
  private final GooglePage googlePage = new GooglePage(driver);

  public void resetPage() {
    driver.get("about:blank");
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

  public void googleSearchTest(String searchValue, String validationValue) {
    googlePage.loadPage();
    googlePage.acceptTerms();

    googlePage.search(searchValue);
//    Assertions.assertTrue(googlePage.hasSearchResultPresent(validationValue), "Searched value was not present!");
  }

  @Test
  public void streamTest(int desiredLength) {
    List<String> arrayList =
        List.of("aapjaljk", "lkasdlkhasdlkjasdlkhb", "c", "daposkpoamsdpjapsd", "asdasdasdlkmklmlkmlkmlsdmflksdlfk");

    arrayList.stream().map(s -> s.length()).filter(l -> l >= 10).anyMatch(l -> l == desiredLength);
  }

  private void validateDropdownContent(GooglePage googlePage, String value, boolean isPresent) {
//    Assertions.assertEquals(isPresent, googlePage.dropDownContains(value),
//        String.format("Failed to find record '%s' in search bar dropdown", value));
  }

  public static void cleanUP() {
    driver.quit();
  }
}
