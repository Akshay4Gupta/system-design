package designPatterns.observerPattern.UberCli;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;

public class DriverAvailability {
    Map<String, Queue<Driver>> driverMap;
    WaitingUser waitingUser;

    DriverAvailability(WaitingUser waitingUser) {
        driverMap = new HashMap<>();
        this.waitingUser = waitingUser;
    }

    void addDriver(Driver driver) {
        if (!driverMap.containsKey(driver.cityName)) {
            driverMap.put(driver.cityName, new LinkedList<>());
        }

        User user = waitingUser.isUserAvailable(driver.cityName);
        if (Objects.nonNull(user)) {
            System.out.println(user.userId + " assigned to the driver: "
                    + driver.driverId + " in city " + user.currentCity);
            return;
        }
        System.out.println("driver " + driver.driverId + " entered the waiting list");
        driverMap.get(driver.cityName).add(driver);

    }

    Driver isDriverAvailable(String cityName) {
        if (!driverMap.containsKey(cityName)) return null;
        Queue<Driver> q = driverMap.get(cityName);
        if (q.isEmpty()) return null;

        return q.remove();
    }
}
