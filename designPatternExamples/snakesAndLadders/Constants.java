package snakesAndLadders;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Constants {
    public static final int NUMBER_OF_PLAYERS;
    public static final int BOARD_SIZE;
    public static final int NUMBER_OF_SNAKES;
    public static final int NUMBER_OF_LADDERS;
    public static final int NUMBER_OF_DIES;
    public static final int MOVEMENT_STRATEGY;

    static {
        String content = readJsonFile("./src/snakesAndLadders/config.json");

        Map<String, Object> jsonMap = parseJson(content);

        NUMBER_OF_PLAYERS = (int) jsonMap.get("N");
        BOARD_SIZE = (int) jsonMap.get("BS");
        NUMBER_OF_SNAKES = (int) jsonMap.get("S");
        NUMBER_OF_LADDERS = (int) jsonMap.get("L");
        NUMBER_OF_DIES = (int) jsonMap.get("D");
        MOVEMENT_STRATEGY = (int) jsonMap.get("MS");
    }

    public static int DEFAULT_STARTING_POSITION = 1;
    public static int DEFAULT_DICE_FACES = 6;

    private static String readJsonFile(String fileName) {
        StringBuilder content = new StringBuilder();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                content.append(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Error reading JSON file: " + e.getMessage());
        }
        return content.toString();
    }

    private static Map<String, Object> parseJson(String content) {
        content = content.replaceAll("\\s", ""); // Remove whitespaces

        Map<String, Object> jsonMap = new HashMap<>();

        String[] pairs = content.substring(1, content.length() - 1).split(",");
        for (String pair : pairs) {
            String[] keyValue = pair.split(":");

            String key = keyValue[0].replaceAll("\"", "");
            String value = keyValue[1];

            if (value.contains("\"")) {
                jsonMap.put(key, value.replaceAll("\"", ""));
            } else {
                jsonMap.put(key, Integer.parseInt(value));
            }
        }

        return jsonMap;
    }
}
