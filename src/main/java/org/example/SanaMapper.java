package org.example;

public class SanaMapper {

    public static User readFromString(String rawString, Class<User> userClass) {
        rawString = rawString.trim().replaceAll("[{}\"]", "");
        if (rawString.isEmpty()) return new User(null, 0, false);

        String[] rows = rawString.split(",");
        if (rows.length != 3) System.out.print("Invalid format for User entity");

        String name = null;
        int year = 0;
        boolean isAdmin = false;

        for (String row : rows) {
            String[] parts = row.split(":");
            if (parts.length != 2) System.out.print("Invalid format for key-value");

            String key = parts[0].trim();
            String value = parts[1].trim();

            try {
                switch (key) {
                    case "name":
                        name = value;
                        break;
                    case "year":
                        year = Integer.parseInt(value);
                        break;
                    case "isAdmin":
                        isAdmin = Boolean.parseBoolean(value);
                        break;
                    default:
                        System.out.print("Unknown data: " + key);
                }
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Invalid format for field: " + key);
            }
        }

        return new User(name, year, isAdmin);
    }
}
