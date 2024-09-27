package org.adaschool.Weather;

import org.adaschool.Weather.data.WeatherReport;
import org.adaschool.Weather.service.WeatherReportService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WeatherApplicationTests {

	@Autowired
	private WeatherReportService weatherReportService;

	@Test
	void testGetWeatherReportService() {
		// Llamada real al servicio, el cual llamará a la API en localhost
		WeatherReport report = weatherReportService.getWeatherReport(20.0, 10.0);

		// Verifica que el servicio devuelve la temperatura y humedad correctas
		// Estos valores deberían coincidir con lo que devuelve tu API en localhost
		assertEquals(0, report.getTemperature());
		assertEquals(93, report.getHumidity());
	}

	@Test
	void contextLoads() {
		// Verifica que el contexto de Spring se carga correctamente
	}
}
