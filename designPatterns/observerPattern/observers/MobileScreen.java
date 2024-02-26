package designPatterns.observerPattern.observers;

import designPatterns.observerPattern.Display;
import designPatterns.observerPattern.ObserverScreen;
import designPatterns.observerPattern.WeatherStation;
import designPatterns.observerPattern.dto.WeatherData;

public class MobileScreen implements ObserverScreen, Display {
    WeatherStation station;
    WeatherData weatherData;

    public MobileScreen(WeatherStation station) {
        this.station = station;
    }

    @Override
    public void updateScreen() {
        this.weatherData = station.getWeatherData();
    }

    @Override
    public void display() {
        System.out.println("mobile screen data is : " + weatherData.getTemperature() + weatherData.geSiUnit());
    }
}
