Principal	Configuración y Ejecución	Contiene el método main. Se encarga de iniciar la aplicación y manejar el bucle principal del menú para interactuar con el usuario.

ConversorMoneda	Interfaz de Usuario (Menú)	Contiene el método exibirMenu() (como se ve en tu imagen). Gestiona la entrada del usuario (Scanner) y la lógica de selección de las opciones del menú.

ConsultaTasaCambio	Consumo de la API	Usa HttpClient, HttpRequest y HttpResponse para realizar la solicitud a la API de tasas de cambio (ExchangeRate-API). Su método principal recibe el código de la moneda base (ej. USD) y devuelve la respuesta JSON como un String.

TasaDeCambio	Manejo de JSON y Datos	Una clase Record o POJO (Plain Old Java Object) para mapear los datos JSON relevantes (usando Gson). Debe tener atributos para la moneda base y un Map (o un objeto anidado) para almacenar los códigos de moneda y sus respectivas tasas de conversión (ej. "ARS": 890.5).

CalculadoraConversiones	Lógica de Conversión	Contiene la lógica de negocio. Su método principal recibe el monto a convertir, la tasa de cambio de origen y la tasa de cambio de destino, y calcula el valor final de la conversión.
