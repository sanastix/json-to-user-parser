package org.example;

import org.junit.jupiter.api.Test;

import static junit.framework.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MapperTests {

    @Test
    void testInitialData() {
        String rawString = """
                {
                  "name": "Serhii",
                  "year": 30,
                  "isAdmin": false
                }
                """;
        User user = SanaMapper.readFromString(rawString, User.class);
        assertNotNull(user);
        assertEquals("Serhii", user.getName());
        assertEquals(30, user.getYear());
        assertFalse(user.isAdmin());
    }

    @Test
    void testEmptyInput() {
        String rawString = "{}";
        User user = SanaMapper.readFromString(rawString, User.class);
        assertNotNull(user);
        assertNull(user.getName());
        assertEquals(0, user.getYear());
        assertFalse(user.isAdmin());
    }

    @Test
    void testInvalidInput() {
        String rawString = "{name: 'Serhii', year: 30.5, isAdmin: no}";
        assertThrows(IllegalArgumentException.class, () -> SanaMapper.readFromString(rawString, User.class));
    }

    @Test
    void testPartialInput() {
        String rawString = """
                {
                  "name": "Serhii"
                }
                """;
        User user = SanaMapper.readFromString(rawString, User.class);

        assertNotNull(user);
        assertEquals("Serhii", user.getName());
        assertEquals(0, user.getYear());
        assertFalse(user.isAdmin());
    }

    @Test
    void testAdditionalInput() {
        String rawString = """
                {
                  "name": "Serhii",
                  "year": 30,
                  "isAdmin": false,
                  "additionalField": "additionalValue"
                }
                """;
        User user = SanaMapper.readFromString(rawString, User.class);
        assertNotNull(user);
        assertEquals("Serhii", user.getName());
        assertEquals(30, user.getYear());
        assertFalse(user.isAdmin());
    }

}
