package designPatterns.observerPattern;

import java.util.ArrayList;
import java.util.List;

import designPatterns.observerPattern.dto.WeatherData;

public class WeatherStation implements ObservableStation {
    List<ObserverScreen> screens;
    WeatherData weatherData;

    WeatherStation() {
        screens = new ArrayList<>();
    }

    @Override
    public void addScreen(ObserverScreen screen) {
        screens.add(screen);
    }

    @Override
    public void deleteScreen(ObserverScreen screen) {
        screens.remove(screen);
    }

    @Override
    public void notifyAllScreens() {
        for(ObserverScreen screen: screens) {
            screen.updateScreen();
        }
    }
    
    public WeatherData getWeatherData() {
        return weatherData;
    }

    public void setWeatherData(WeatherData weatherData) {
        this.weatherData = weatherData;
    }
}
