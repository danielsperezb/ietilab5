package org.adaschool.Weather;

import org.adaschool.Weather.data.WeatherApiResponse;
import org.adaschool.Weather.data.WeatherApiResponse.Main;
import org.adaschool.Weather.data.WeatherReport;
import org.adaschool.Weather.service.WeatherReportService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WeatherApplicationTests {

	@MockBean
	private RestTemplate restTemplate;

	@InjectMocks
	private WeatherReportService weatherReportService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testGetWeatherReportService() {
		// Crear una instancia simulada del objeto WeatherApiResponse
		WeatherApiResponse mockApiResponse = new WeatherApiResponse();
		WeatherApiResponse.Main mockMain = new WeatherApiResponse.Main();

		// Simulamos que la API devuelve una temperatura de 0 y una humedad de 93
		mockMain.setTemperature(0);  // Temperatura
		mockMain.setHumidity(93);    // Humedad

		// Configurar el objeto mockApiResponse
		mockApiResponse.setMain(mockMain);

		// Simulamos la respuesta de restTemplate
		when(restTemplate.getForObject(anyString(), eq(WeatherApiResponse.class))).thenReturn(mockApiResponse);

		// Llamada al servicio con coordenadas simuladas
		WeatherReport report = weatherReportService.getWeatherReport(20.0, 10.0);

		// Verificamos que la temperatura y humedad son las esperadas
		assertEquals(0, report.getTemperature());
		assertEquals(93, report.getHumidity());

		// Verifica que restTemplate fue invocado correctamente
		verify(restTemplate, times(1)).getForObject(anyString(), eq(WeatherApiResponse.class));
	}


	@Test
	void contextLoads() {
		// Verifica que el contexto de Spring se carga correctamente
	}
}
