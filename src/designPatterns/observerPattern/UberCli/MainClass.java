package designPatterns.observerPattern.UberCli;

public class MainClass {
    public static void main(String [] args) {
        WaitingUser user = new WaitingUser();
        DriverAvailability driverAvailability = new DriverAvailability(user);
        user.setDriverAvailability(driverAvailability);

        user.addUserInWaitingList(new User("delhi", "user1"));
        driverAvailability.addDriver(new Driver("delhi", "driver2"));
        driverAvailability.addDriver(new Driver("delhi", "driver1"));
        user.addUserInWaitingList(new User("delhi", "user2"));
    }
}
