import java.util.Map;

/**
 * Record que representa la estructura de la respuesta JSON de la API.
 * Mapea la moneda base y las tasas de conversión.
 */
public record TasaDeCambio(
        String base_code,
        Map<String, Double> conversion_rates
) {
    // Nota: Los nombres de los campos deben coincidir con las claves del JSON (ej. conversion_rates).
    // Los Records son inmutables y no necesitan getters/setters explícitos.
}