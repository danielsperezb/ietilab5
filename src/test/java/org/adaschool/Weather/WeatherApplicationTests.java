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
		// Creamos una instancia simulada del objeto WeatherApiResponse según el JSON proporcionado
		WeatherApiResponse mockApiResponse = new WeatherApiResponse();
		WeatherApiResponse.Main mockMain = new WeatherApiResponse.Main();
		mockMain.setTemperature(296.63);  // Temperatura en Kelvin (sin conversión a Celsius)
		mockMain.setHumidity(90);  // Humedad en porcentaje
		mockApiResponse.setMain(mockMain);

		// Mock del comportamiento de restTemplate para devolver la respuesta simulada
		when(restTemplate.getForObject(anyString(), eq(WeatherApiResponse.class))).thenReturn(mockApiResponse);

		// Llamada al servicio con coordenadas simuladas
		WeatherReport report = weatherReportService.getWeatherReport(10.0, 20.0);

		// Verificar que el servicio retorna la temperatura en Kelvin
		assertEquals(296.63, report.getTemperature(), 0.01);
		assertEquals(90, report.getHumidity());

		// Verificar que restTemplate fue invocado correctamente
		verify(restTemplate, times(1)).getForObject(anyString(), eq(WeatherApiResponse.class));
	}

	@Test
	void contextLoads() {
		// Verifica que el contexto de Spring se carga correctamente
	}
}
