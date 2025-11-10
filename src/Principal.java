/**
 * Clase de ejecución principal para el Conversor de Monedas.
 * Inicializa y lanza la aplicación.
 */
public class Principal {
    public static void main(String[] args) {
        //
        System.out.println("*************************************************");
        System.out.println("       INICIANDO APLICACIÓN CONVERSOR DE MONEDAS");
        System.out.println("*************************************************");

        ConversorMoneda app = new ConversorMoneda();
        app.ejecutar();
    }
}
