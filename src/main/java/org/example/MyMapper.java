package org.example;

import java.lang.reflect.Field;

public class MyMapper {

    public static <T> T readFromString(String rawString, Class<T> initialClass) {
        rawString = rawString.trim().replaceAll("[{}\"]", "");
        String[] parts = rawString.split(",");
        T instance;

        try {
            instance = initialClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Cannot create instance of class " + initialClass.getName(), e);
        }

        for (String part : parts) {
            String[] keyValue = part.split(":");
            if (keyValue.length != 2) {
                throw new IllegalArgumentException("Invalid key-value pair: " + part);
            }

            String key = keyValue[0].trim();
            String value = keyValue[1].trim();
            try {
                Field field = initialClass.getDeclaredField(key);
                field.setAccessible(true);

                if (field.getType() == int.class) {
                    field.set(instance, Integer.parseInt(value));
                } else if (field.getType() == boolean.class) {
                    field.set(instance, Boolean.parseBoolean(value));
                } else if (field.getType() == String.class) {
                    field.set(instance, value);
                } else {
                    throw new RuntimeException("Unsupported field type: " + field.getType());
                }
            } catch (NoSuchFieldException e) {
                System.out.println("Unknown field: " + key);
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Cannot access field: " + key, e);
            }
        }

        return instance;
    }

}