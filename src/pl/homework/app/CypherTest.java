package pl.homework.app;

import java.io.IOException;
import static pl.homework.utils.CypherTools.*;

public class CypherTest {
    public static void main(String[] args) {
        try {
            shiftLetters();
            cesarCypher(readText());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
