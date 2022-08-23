package main.api;

import io.restassured.RestAssured;
import io.restassured.response.ResponseBody;

public class UserControllerInterface {

    public ResponseBody createUser() {
        return RestAssured.post("https://our.user.host.com/create/user").body();
    }

    public ResponseBody getUser(String userId) {
        return RestAssured.get(String.format("https://our.user.host.com/find/%s", userId)).body();
    }
}
