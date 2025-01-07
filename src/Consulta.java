import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class Consulta {

    Conversor convetirMoneda(double totalAConvertir , String monedaActual, String monedaAconvertir ){

        var myURI = URI.create("https://v6.exchangerate-api.com/v6/9868f4649491b030a4e759df/pair/"+ monedaActual + "/" + monedaAconvertir ) ;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(myURI)
                .build();
        HttpResponse<String> response = null;
        try {
           response = client
                    .send(request , HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new Gson().fromJson(response.body(), Conversor.class);
    }

}
