package org.example;

public class App 
{
    public static void main( String[] args ) {
        String rawString = """
                {
                  "name": "Serhii",
                  "year": 30,
                  "isAdmin": false
                }
                                """;
        User user = SanaMapper.readFromString(rawString, User.class);
        System.out.println(user);
    }
}
