Principal	Configuración y Ejecución	Contiene el método main. Se encarga de iniciar la aplicación y manejar el bucle principal del menú para interactuar con el usuario.
<img width="882" height="530" alt="image" src="https://github.com/user-attachments/assets/3bf47872-150b-441d-a45f-ca62a16f12eb" />

ConversorMoneda	Interfaz de Usuario (Menú)	Contiene el método exibirMenu() (como se ve en tu imagen). Gestiona la entrada del usuario (Scanner) y la lógica de selección de las opciones del menú.
<img width="810" height="616" alt="image" src="https://github.com/user-attachments/assets/2d7b359e-6701-4b75-bdd1-646cc452c871" />

<img width="847" height="538" alt="image" src="https://github.com/user-attachments/assets/25b0f747-b214-437e-946f-2fbf7be24001" />

<img width="885" height="515" alt="image" src="https://github.com/user-attachments/assets/485d5fe3-46cb-4082-a40e-e68e7d8fdf31" />

<img width="937" height="538" alt="image" src="https://github.com/user-attachments/assets/23478892-46e6-4526-b43c-e56dad0068fa" />

<img width="1221" height="539" alt="image" src="https://github.com/user-attachments/assets/72907618-82f3-4103-b5f1-14b44c9e141b" />

<img width="977" height="164" alt="image" src="https://github.com/user-attachments/assets/1c42ebac-7a5a-4453-8542-e515b64181c1" />

ConsultaTasaCambio	Consumo de la API	Usa HttpClient, HttpRequest y HttpResponse para realizar la solicitud a la API de tasas de cambio (ExchangeRate-API). Su método principal recibe el código de la moneda base (ej. USD) y devuelve la respuesta JSON como un String.
<img width="978" height="614" alt="image" src="https://github.com/user-attachments/assets/f540aa90-de5e-408c-991b-0d25aad6db49" />

<img width="1031" height="527" alt="image" src="https://github.com/user-attachments/assets/0ec2ae76-43ae-43f2-bf0d-b8827f904c91" />

<img width="990" height="117" alt="image" src="https://github.com/user-attachments/assets/8f67aa4f-b06d-4a05-8053-cf8c41359f19" />

TasaDeCambio	Manejo de JSON y Datos	Una clase Record o POJO (Plain Old Java Object) para mapear los datos JSON relevantes (usando Gson). Debe tener atributos para la moneda base y un Map (o un objeto anidado) para almacenar los códigos de moneda y sus respectivas tasas de conversión (ej. "ARS": 890.5).
<img width="918" height="379" alt="image" src="https://github.com/user-attachments/assets/7b1a0d77-c1d3-45e0-b5c4-7a9ba9c93f77" />


CalculadoraConversiones	Lógica de Conversión	Contiene la lógica de negocio. Su método principal recibe el monto a convertir, la tasa de cambio de origen y la tasa de cambio de destino, y calcula el valor final de la conversión.
<img width="967" height="620" alt="image" src="https://github.com/user-attachments/assets/2b0cf34a-2085-4792-862b-e512e8aa2e82" />

<img width="942" height="513" alt="image" src="https://github.com/user-attachments/assets/05170d82-782f-45f8-a657-2dc478e6617b" />

<img width="823" height="516" alt="image" src="https://github.com/user-attachments/assets/cb4f072b-8be4-4906-8f4a-db0bc2b811a2" />

<img width="935" height="534" alt="image" src="https://github.com/user-attachments/assets/39955afd-9f8b-4cd2-af53-aa34f00baefb" />

<img width="1237" height="536" alt="image" src="https://github.com/user-attachments/assets/bf4f6617-98cb-4285-b7e8-8ba68c849572" />

<img width="1038" height="206" alt="image" src="https://github.com/user-attachments/assets/8aae3dd0-a2c5-4c20-b0aa-695304ee14e9" />





