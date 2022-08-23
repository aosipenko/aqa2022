package main;

import main.pages.WSchoolsPage;
import org.testng.annotations.Test;

public class WSchoolsTest extends BaseTest {

    WSchoolsPage wSchoolsPage = new WSchoolsPage(driver);

    @Test
    public void findIframetest() {
        wSchoolsPage.loadPage();
        wSchoolsPage.acceptCookies();

        WSchoolsPage.IFrameElements iFrameElements = wSchoolsPage.swicthToContentRight();
        System.out.println(iFrameElements.getIframeInner().isDisplayed());
        driver.switchTo().defaultContent();

        driver.quit();
    }
}
