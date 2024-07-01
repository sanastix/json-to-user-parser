package org.example;

import org.junit.jupiter.api.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AppTest {

    @Test
    void testReadFromStringToUser() {
        String rawString = """
                {
                  "name": "Serhii",
                  "year": 30,
                  "isAdmin": false
                }
                """;

        User expectedUser = new User("Serhii", 30, false);
        User actualUser = MyMapper.readFromString(rawString, User.class);

        assertEquals(expectedUser.getName(), actualUser.getName());
        assertEquals(expectedUser.getYear(), actualUser.getYear());
        assertEquals(expectedUser.isAdmin(), actualUser.isAdmin());
    }

    @Test
    void testInvalidField() {
        String rawString = """
                {
                  "name": "Serhii",
                  "year": "invalid_number",
                  "isAdmin": false
                }
                """;

        assertThrows(NumberFormatException.class, () -> MyMapper.readFromString(rawString, User.class));
    }

    @Test
    void testUnknownField() {
        String rawString = """
                {
                  "name": "Serhii",
                  "year": 30,
                  "isAdmin": false,
                  "unknownField": "test"
                }
                """;

        User actualUser = MyMapper.readFromString(rawString, User.class);

        assertEquals("Serhii", actualUser.getName());
        assertEquals(30, actualUser.getYear());
        assertFalse(actualUser.isAdmin());
    }

}
