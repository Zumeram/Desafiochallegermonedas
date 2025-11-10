import java.util.Scanner;

/**
 * Clase principal que gestiona el menú y la lógica de interacción con el usuario.
 */
public class ConversorMoneda {
    private final Scanner teclado;
    private final ConsultaTasaCambio consulta;
    private TasaDeCambio tasaCambio; // Almacenamos las tasas obtenidas.

    // Definición de las conversiones disponibles: {opcion, monedaOrigen, monedaDestino}
    // NOTA: La API siempre da tasas USD->X, la conversión X->Y se calcula a partir de eso.
    private static final String[][] CONVERSIONES = {
            {"1", "USD", "ARS", "Dólar", "Peso argentino"},
            {"2", "ARS", "USD", "Peso argentino", "Dólar"},
            {"3", "USD", "BRL", "Dólar", "Real brasileño"},
            {"4", "BRL", "USD", "Real brasileño", "Dólar"},
            {"5", "USD", "CLP", "Dólar", "Peso chileno"},
            {"6", "CLP", "USD", "Peso chileno", "Dólar"},
    };

    public ConversorMoneda() {
        this.teclado = new Scanner(System.in);
        this.consulta = new ConsultaTasaCambio();

        System.out.println("Cargando tasas de cambio (Base: USD)...");
        try {
            // Se asume que la API de la clave de prueba siempre retorna USD como base.
            this.tasaCambio = consulta.buscarTasas("USD");
            System.out.println("✅ Tasas cargadas exitosamente.");
        } catch (RuntimeException e) {
            System.err.println("⚠️ No se pudo inicializar la aplicación. " + e.getMessage());
            this.tasaCambio = null; // Marcar como fallido.
        }
    }

    /**
     * Muestra el menú y gestiona la selección del usuario en un bucle.
     */
    public void ejecutar() {
        if (tasaCambio == null) {
            System.out.println("La aplicación no puede continuar sin tasas de cambio.");
            return;
        }

        String opcion;
        do {
            exibirMenu();
            opcion = teclado.nextLine();

            if (opcion.equals("7")) {
                System.out.println("\n¡Gracias por usar el Conversor de Monedas! Adiós.");
                break;
            }

            realizarConversion(opcion);

        } while (true);
    }

    /**
     * Imprime el menú de opciones en la consola. (Similar a tu imagen)
     */
    private void exibirMenu() {
        String menu = """
            \n***************************************************
            Sea bienvenido/a al Conversor de Moneda =>
            
            1) Dólar (USD) ==> Peso argentino (ARS)
            2) Peso argentino (ARS) ==> Dólar (USD)
            3) Dólar (USD) ==> Real brasileño (BRL)
            4) Real brasileño (BRL) ==> Dólar (USD)
            5) Dólar (USD) ==> Peso chileno (CLP)
            6) Peso chileno (CLP) ==> Dólar (USD)
            7) Salir
            
            Elija una opción válida:
            ***************************************************
            """;
        System.out.print(menu);
    }

    /**
     * Realiza la lógica de conversión para la opción seleccionada.
     */
    private void realizarConversion(String opcion) {
        try {
            int indice = Integer.parseInt(opcion) - 1;
            if (indice < 0 || indice >= CONVERSIONES.length) {
                System.out.println("❌ Opción no válida. Por favor, elija un número del 1 al 7.");
                return;
            }

            String codigoOrigen = CONVERSIONES[indice][1];
            String codigoDestino = CONVERSIONES[indice][2];
            String nombreOrigen = CONVERSIONES[indice][3];
            String nombreDestino = CONVERSIONES[indice][4];

            if (!tasaCambio.conversion_rates().containsKey(codigoOrigen) || !tasaCambio.conversion_rates().containsKey(codigoDestino)) {
                System.out.println("⚠️ Error: Una de las monedas seleccionadas no está disponible en las tasas actuales de la API.");
                return;
            }

            System.out.printf("Ingrese el valor en %s (%s) que desea convertir: ", nombreOrigen, codigoOrigen);
            double monto = Double.parseDouble(teclado.nextLine());

            // Tasa de origen y destino respecto a la base (USD)
            double tasaOrigen = tasaCambio.conversion_rates().get(codigoOrigen);
            double tasaDestino = tasaCambio.conversion_rates().get(codigoDestino);

            // Calculo: (Monto / TasaOrigen) * TasaDestino
            // Ejemplo: 100 ARS -> USD. TasaARS (890). TasaUSD (1). -> (100 / 890) * 1 = 0.112 USD
            double resultado = (monto / tasaOrigen) * tasaDestino;

            System.out.printf("\n✔️ El valor de %.2f %s (%s) equivale a %.2f %s (%s).\n",
                    monto, nombreOrigen, codigoOrigen,
                    resultado, nombreDestino, codigoDestino);

        } catch (NumberFormatException e) {
            System.out.println("❌ Entrada no válida. Por favor, ingrese un número para la opción o el monto.");
        } catch (Exception e) {
            System.out.println("❌ Ocurrió un error inesperado: " + e.getMessage());
        }
    }
}
