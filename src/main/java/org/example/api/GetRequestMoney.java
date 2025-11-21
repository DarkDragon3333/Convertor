package org.example.api;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.time.Duration;

public class GetRequestMoney {
    public String HttpRequest(String start_cur, String destination_cur) throws IOException, InterruptedException {
        String cur = "currencies=" + start_cur;
        String base_cur = "base_currency=" + destination_cur;

        BufferedReader readApi = new BufferedReader(
                new FileReader(String.valueOf(Path.of(".\\data_res\\api_key.txt")))
        );
        String url = readApi.readLine() + cur + "&" + base_cur;

        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .connectTimeout(Duration.ofSeconds(10))
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Accept", "application/json")
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            System.err.println("Ошибка: " + response.body());
            return cur;
        }

        return response.body();
    }


}
