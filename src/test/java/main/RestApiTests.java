package main;

import main.api.UserControllerInterface;
import main.pages.GooglePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RestApiTests extends BaseTest {

    private GooglePage googlePage = new GooglePage(driver);

    @Test
    public void baseApiTest() {
        UserControllerInterface userControllerInterface = new UserControllerInterface();
        String userId = userControllerInterface.createUser().prettyPrint();
        Assert.assertNotNull(userControllerInterface.getUser(userId));

        driver.quit();
    }

    private class SomeDTO {
        private String id;
        private String name;
    }
}
