package pl.example.rngcalculator;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class RngRestClient<A> {

    public static String generateRandomNumber(int min, int max) throws IOException {
        try (CloseableHttpClient client = HttpClients.createDefault()) {

            HttpGet request = new HttpGet("https://www.random.org/integers/?num=1&min=" + min
                    + "&max=" + max + "&col=1&base=10&format=plain&rnd=new");

            return client.execute(request, httpResponse ->
                    EntityUtils.toString(httpResponse.getEntity()));


        }
    }
}
