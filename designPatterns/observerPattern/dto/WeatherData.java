package designPatterns.observerPattern.dto;

public class WeatherData {
    int temperature;
    SIUnit unit;

    public WeatherData(int temperature, SIUnit siUnit) {
        this.temperature = temperature;
        this.unit = siUnit;
    }
    public int getTemperature() {
        return temperature;
    }

    public SIUnit geSiUnit() {
        return unit;
    }

    public void setTemperature(int temp) {
        this.temperature = temp;
    }

    public void setSiUnit(SIUnit unit) {
        this.unit = unit;
    }
}
