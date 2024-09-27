package org.adaschool.Weather.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.adaschool.Weather.data.WeatherApiResponse;
import org.adaschool.Weather.data.WeatherReport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

class WeatherReportServiceTest {

    String API_KEY = "fa4c6cc9d10844aee962564ee9933af2";
    String API_URL = "https://api.openweathermap.org/data/2.5/weather";

    @Mock
    RestTemplate restTemplate;

    @InjectMocks
    WeatherReportService weatherReportService;

    @BeforeEach
    void setUp() {
        // Inicializar los mocks antes de cada prueba
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetWeatherReport() {
        double latitude = 37.8267;
        double longitude = -122.4233;
        String url = API_URL + "?lat=" + latitude + "&lon=" + longitude + "&appid=" + API_KEY;

        // Configurar el objeto simulado para la respuesta de la API
        WeatherApiResponse weatherApiResponse = new WeatherApiResponse();
        WeatherApiResponse.Main main = new WeatherApiResponse.Main();
        main.setHumidity(92);
        main.setTemperature(0);
        weatherApiResponse.setMain(main);

        // Simular el comportamiento de restTemplate
        when(restTemplate.getForObject(url, WeatherApiResponse.class)).thenReturn(weatherApiResponse);

        // Llamar al método bajo prueba
        WeatherReport weatherReport = weatherReportService.getWeatherReport(latitude, longitude);

        // Validar el resultado esperado
        assertEquals(main.getTemperature(), weatherReport.getTemperature());
        assertEquals(main.getHumidity(), weatherReport.getHumidity());
    }
}
