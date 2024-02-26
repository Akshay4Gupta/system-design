package designPatterns.observerPattern;

import designPatterns.observerPattern.dto.SIUnit;
import designPatterns.observerPattern.dto.WeatherData;
import designPatterns.observerPattern.observers.LaptopScreen;
import designPatterns.observerPattern.observers.MobileScreen;

public class Main {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();
        MobileScreen mobileScreen = new MobileScreen(station);
        LaptopScreen laptopScreen = new LaptopScreen(station);

        WeatherData weatherData = new WeatherData(20, SIUnit.C);
        station.setWeatherData(weatherData);
        station.notify();
        mobileScreen.display();
        laptopScreen.display();

        weatherData = new WeatherData(100, SIUnit.F);
        station.setWeatherData(weatherData);
        station.notify();
        mobileScreen.display();
        laptopScreen.display();
    }
}
