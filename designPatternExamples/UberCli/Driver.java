package designPatternExamples.UberCli;

public class Driver {
    String cityName;
    String driverId;

    Driver(String cityName, String driverId) {
        this.driverId = driverId;
        this.cityName = cityName;
    }

    String getCityName() {
        return this.cityName;
    }
    String getDriverId() {
        return this.driverId;
    }
}
