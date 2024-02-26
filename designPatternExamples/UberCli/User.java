package designPatternExamples.UberCli;

public class User {
    String currentCity;
    String userId;

    User(String cityName, String userId) {
        this.userId = userId;
        this.currentCity = cityName;
    }

    String getCurrentCity() {
        return this.currentCity;
    }
    String getUserId() {
        return this.userId;
    }
}
