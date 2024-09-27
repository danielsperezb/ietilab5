# Codelab: Unit Testing

## Pruebas Unitarias en Spring Boot con Java

### Objetivos de Aprendizaje
- Implementar pruebas unitarias para el servicio de reporte del clima con Spring Boot y Java.
- Ejecutar y verificar pruebas unitarias en Spring Boot.

### Temas Principales
- Pruebas Unitarias.
- JUnit.
- Spring Boot.
- Mockito.

---

### Codelab 🧪
🗣️ _"Oigo y olvido. Veo y aprendo. Hago y entiendo."_ - Confucio

---

### Parte 1: Configurando el Entorno Weather API

1. **Descarga e importa el proyecto de la API de Reporte del Clima en IntelliJ IDEA.**
2. **Crea una cuenta en [OpenWeatherMap](https://home.openweathermap.org/users/sign_up) y genera una API KEY.**
3. **Reemplaza el valor de tu API key en la variable `API_KEY` del archivo `WeatherReportService.java`.**
4. **Ejecuta y prueba el proyecto para entender su funcionamiento.**
5. **Ejecuta los tests creados de ejemplo en la clase `WeatherApplicationTests` y verifica que todas las pruebas pasen.**

### Parte 2: Implementando Unit Tests

1. **Lee y comprende la documentación oficial de [Mockito](https://site.mockito.org/) para entender cómo funciona y cómo usarlo.**
2. **Implementa los Unit Test necesarios para probar los siguientes componentes:**
   - `WeatherReportController`
   - `WeatherReportService`

---

### Instrucciones para Ejecutar el Proyecto

1. Clona este repositorio:

   ```bash
   git clone https://github.com/tu_usuario/tu_repositorio.git
   cd tu_repositorio



![image](https://github.com/user-attachments/assets/a56118e1-deea-4c92-8aff-dde863d5b035)

![image](https://github.com/user-attachments/assets/e928a355-0ce7-4ec0-8c24-b11f5a1a5b4d)

Nota:

El mock no es necesario cuando estás probando la interacción con una API real, como en tu ejemplo con el servicio en localhost. Si tu objetivo es probar cómo tu aplicación interactúa con datos reales y confirmar que todo funciona correctamente con la API externa, entonces no deberías usar mocks. En ese caso, quieres una prueba que haga una llamada real a la API y verifique los datos.

