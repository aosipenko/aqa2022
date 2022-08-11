package main;

import static org.junit.jupiter.params.provider.Arguments.arguments;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import main.pages.GooglePage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class GooglePageTest extends BaseTest {
  private final GooglePage googlePage = new GooglePage(driver);

  @BeforeEach
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

  @ParameterizedTest
  @MethodSource("searchSources")
  public void googleSearchTest(String searchValue, String validationValue) {
    googlePage.loadPage();
    googlePage.acceptTerms();

    googlePage.search(searchValue);
    Assertions.assertTrue(googlePage.hasSearchResultPresent(validationValue), "Searched value was not present!");
  }

  @Test
  public void streamTest(int desiredLength) {
    List<String> arrayList =
        List.of("aapjaljk", "lkasdlkhasdlkjasdlkhb", "c", "daposkpoamsdpjapsd", "asdasdasdlkmklmlkmlkmlsdmflksdlfk");

    arrayList.stream().map(s -> s.length()).filter(l -> l >= 10).anyMatch(l -> l == desiredLength);
  }

  private void validateDropdownContent(GooglePage googlePage, String value, boolean isPresent) {
    Assertions.assertEquals(isPresent, googlePage.dropDownContains(value),
        String.format("Failed to find record '%s' in search bar dropdown", value));
  }

  private static Stream<Arguments> searchSources() {
    return Stream.of(
        arguments("twitter", "https://twitter.com"),
        arguments("facebook", "https://www.facebook.com"),
        arguments("youtube", "https://google.com")
    );
  }

  @AfterAll
  public static void cleanUP() {
    driver.quit();
  }
}
