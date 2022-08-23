package main;

import io.qameta.allure.Description;
import main.pages.GooglePage;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CloudFlarePageTests extends BaseTest {

  private GooglePage googlePage = new GooglePage(driver);
  private SoftAssertions assertions = new SoftAssertions();

  @Test
  public void someTest() {
    googlePage.loadPage();
    googlePage.acceptTerms();

    googlePage.setSearchValue("some search");
    googlePage.clickSearchField();

//    List<String> dropDownElements = googlePage.getDropDownValues();

    assertions.assertThat(googlePage.getDropDownValues()).contains("as;dha;sdhaskj;dh");
    assertions.assertThat(googlePage.getDropDownValues()).contains("some search engines");
    assertions.assertThat(googlePage.getDropDownValues()).contains("some search");
    assertions.assertThat(googlePage.getDropDownValues()).contains("some popular search engines");
    assertions.assertThat(googlePage.getDropDownValues()).contains("some examples of search engine");
    assertions.assertThat(googlePage.getDropDownValues()).contains("lknasdnlkanklsdlkn");

    assertions.assertAll();
  }

  @Test
  @Description("blah blah description")
  public void staleElementReferenceTest() {
    try {
      googlePage.loadPage();
      googlePage.acceptTerms();

      WebElement googleLogo = googlePage.getGoogleLogo();
      googleLogo.click();

      driver.navigate().refresh();

      googleLogo.click();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test(dataProvider = "SearchProvider")
  public void TestNGDataProvider(String dataInput, String dataInputTwo) {
    System.out.println(dataInputTwo + ":" + dataInput);
  }

  @DataProvider(name = "SearchProvider")
  public Object[][] getDataFromDataprovider() {
    return new Object[][]
        {
            {"test1", "Guru99"},
            {"test2", "Krishna"},
            {"test3", "Bhupesh"}
        };
  }
}
