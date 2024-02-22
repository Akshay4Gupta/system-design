package designPatterns.observerPattern.UberCli;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;

public class WaitingUser {
    Map<String, Queue<User>> waitingUser;
    DriverAvailability driverAvailability;

    WaitingUser() {
        waitingUser = new HashMap<>();
    }

    void setDriverAvailability(DriverAvailability driverAvailability) {
        this.driverAvailability = driverAvailability;
    }

    void addUserInWaitingList(User user) {
        if (!waitingUser.containsKey(user.currentCity)) {
            waitingUser.put(user.currentCity, new LinkedList<>());
        }
        Driver driver =
                driverAvailability.isDriverAvailable(user.currentCity);
        if (Objects.nonNull(driver)) {
            System.out.println(user.userId + " assigned to the driver: "
                    + driver.driverId + " in city " + user.currentCity);
            return;
        }
        System.out.println("user " + user.userId + " entered the waiting list");

        waitingUser.get(user.currentCity).add(user);
    }

    User isUserAvailable(String cityName) {
        if (!waitingUser.containsKey(cityName)) return null;
        Queue<User> q = waitingUser.get(cityName);
        if (q.isEmpty()) return null;

        return q.remove();
    }
}
