import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Clase responsable de consultar la API de tasas de cambio.
 */
public class ConsultaTasaCambio {
    // La clave ahora solo se define aquí.
    private static final String API_KEY = "b19a1a76e81afe9609f11ca2";
    // BASE_URL solo debe contener la parte fija de la dirección.
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    /**
     * Consulta la API y devuelve un objeto TasaDeCambio con las tasas.
     * @param monedaBase El código de la moneda base (ej. "USD").
     * @return Objeto TasaDeCambio con las tasas de conversión.
     * @throws RuntimeException Si ocurre un error de red o de parseo.
     */
    public TasaDeCambio buscarTasas(String monedaBase) {
        // CONSTRUCCIÓN CORRECTA: BASE_URL + API_KEY + /latest/ + monedaBase
        // Ejemplo de URL construida: https://v6.exchangerate-api.com/v6/b19a1a76e81afe9609f11ca2/latest/USD
        URI direccion = URI.create(BASE_URL + API_KEY + "/latest/" + monedaBase);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String jsonResponse = response.body();

            // Usamos Gson para mapear el JSON (String) al objeto TasaDeCambio.
            Gson gson = new Gson();
            return gson.fromJson(jsonResponse, TasaDeCambio.class);

        } catch (IOException | InterruptedException e) {
            System.err.println("❌ Error de red al consultar la API: " + e.getMessage());
            // Se mantiene el lanzamiento de excepción para detener la ejecución si falla.
            throw new RuntimeException("Error al consultar la API. Verifique su conexión y clave.", e);
        } catch (JsonSyntaxException e) {
            System.err.println("❌ Error de formato JSON. La API pudo haber cambiado o la clave es incorrecta.");
            throw new RuntimeException("Error al procesar la respuesta de la API.", e);
        }
    }
}
