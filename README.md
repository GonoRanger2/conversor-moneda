# 🪙 Conversor de Monedas - Challenge Alura / Oracle Next Education

![Static Badge](https://img.shields.io/badge/Status-Completado-green)
![Static Badge](https://img.shields.io/badge/Java-17-orange)
![Static Badge](https://img.shields.io/badge/API-ExchangeRate-blue)

Bienvenido al **Conversor de Monedas**, una herramienta de consola diseñada para obtener tasas de cambio en tiempo real y realizar conversiones precisas entre diferentes divisas globales.

---

## 🚀 Características

* **Tasas Reales:** Conexión directa con la API de [ExchangeRate-API](https://www.exchangerate-api.com/).
* **Interfaz Limpia:** Menú interactivo por consola fácil de usar.
* **Soporte Multidivisa:** Conversiones entre USD, BRL, ARS, COP, y más.
* **Precisión Matemática:** Cálculos automáticos basados en las tasas más recientes del mercado.

---

## 🛠️ Tecnologías y Requisitos

Este proyecto fue desarrollado utilizando el siguiente stack tecnológico:

* **Lenguaje:** [Indica tu lenguaje, ej. Java 17]
* **API de Tasas:** ExchangeRate-API (v6)
* **Librerías:** [Ej. Gson para el mapeo de JSON]
* **Herramientas:** Git, GitHub, [IDE, ej: IntelliJ IDEA / VS Code]

---

## 📖 Funcionamiento y Lógica

La aplicación interactúa con el usuario a través de la terminal siguiendo este flujo:

1. El usuario selecciona la opción deseada desde el menú principal.
2. La aplicación solicita la cantidad de dinero a convertir.
3. El programa envía una solicitud HTTP a la API de ExchangeRate.
4. Se procesa el JSON recibido y se aplica la fórmula de conversión:

   $$\text{Monto Convertido} = \text{Monto Original} \times \text{Tasa de Cambio}$$

5. Se muestra el resultado con el símbolo de la moneda correspondiente.

---

## ⚙️ Instalación y Configuración

Para ejecutar este conversor de divisas localmente, sigue estos pasos:

1.  **Clona este repositorio:**
    ```bash
    git clone [https://github.com/tu-usuario/nombre-del-repo.git](https://github.com/tu-usuario/nombre-del-repo.git)
    ```
2.  **Configura tu API Key:**
    * Regístrate en [ExchangeRate-API](https://www.exchangerate-api.com/).
    * Inserta tu clave en la clase correspondiente dentro de la variable `API_KEY`.
3.  **Compila y Ejecuta:**
    ```bash
    [Comando de ejecución, ej: java -cp bin Principal o python main.py]
    ```

---

## 🤝 Contribuciones

Siéntete libre de realizar un *fork* del proyecto, proponer mejoras o informar de errores abriendo un *issue*. ¡Toda contribución es bienvenida!

---