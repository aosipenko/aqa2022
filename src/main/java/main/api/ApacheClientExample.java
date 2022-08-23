package main.api;

import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.support.ClassicRequestBuilder;

import java.io.IOException;

public class ApacheClientExample {

    private final CloseableHttpClient httpClient = HttpClients.createDefault();

    public HttpEntity makeGetCall() throws IOException {

        ClassicRequestBuilder.post("")
                .setEntity("{\"name\":\"test_name\"}")
                .addHeader("asd", "asd")
                .build();

        ClassicHttpRequest request = ClassicRequestBuilder
                .get("https://google.com")
                .addHeader("user-agent", "MOzilla")
                .addHeader("user-auth", "asdasd")
                .build();

        return httpClient.execute(request).getEntity();
    }
}
