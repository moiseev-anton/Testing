package seminar04.test;

import org.junit.jupiter.api.Test;
import seminar04.weather.WeatherReporter;
import seminar04.weather.WeatherService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class TestWeather {
    @Test
    public void testWeatherReporter(){
        WeatherService mockWeatherService = mock(WeatherService.class);
        when(mockWeatherService.getCurrentTemperature()).thenReturn(25);

        WeatherReporter weatherReporter = new WeatherReporter(mockWeatherService);
        String result = weatherReporter.generateReport();
        assertThat(result).isEqualTo("Текущая температура: 25 градусов.");
        verify(mockWeatherService, times(1)).getCurrentTemperature();
    }
}
