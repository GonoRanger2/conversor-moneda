package servicio;

import com.google.gson.Gson;
import modelos.MonedaRecord;

import javax.imageio.IIOException;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;

public class ConsultaApi {
    public String API_KEY;
    private final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    public ConsultaApi(){
        try {
            Properties props = new Properties();
            props.load(new FileInputStream( "config.properties"));
            this.API_KEY = props.getProperty("api.key");
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de configuración: " + e.getMessage());
        }
    }
public MonedaRecord buscarTasas(String monedaBase){
    URI direccion = URI.create(BASE_URL + API_KEY + "/latest/" + monedaBase);
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
            .uri(direccion)
            .GET()
            .build();
    try {
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() != 200) {
            System.out.println("Error de conexión o API: Código " + response.statusCode());
            return null;
        }
        return new Gson().fromJson(response.body(), MonedaRecord.class);
    }catch (IOException | InterruptedException e) {
        System.err.println("Error al obtener la respuesta de la API: " + e.getMessage());
    }return null;
}
}
