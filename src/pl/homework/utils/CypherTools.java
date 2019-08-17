package pl.homework.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class CypherTools {

    public static final String LETTER_DB_FILE = "cypher.db";
    public static final int SHIFT_LETTER = 3;
    public static String[] letters;
    public static String[] cypherLetters;

    private static void readDBLetters() throws IOException {
        File file = new File(LETTER_DB_FILE);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line = bufferedReader.readLine();
        letters = line.split(" ");
        bufferedReader.close();
    }

    public static void shiftLetters() throws IOException {
        readDBLetters();
        cypherLetters = new String[letters.length];
        for (int i = 0; i< letters.length; i++) {
            cypherLetters[i] = letters[(i + SHIFT_LETTER-1)%letters.length];
        }
    }

    public static void cesarCypher(String[] array) {
        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < letters.length; j++) {
                if (letters[j].equals(array[i])) {
                    array[i] = cypherLetters[j];
                    break;
                }
            }
        }
        System.out.println("\nZaszyfrowany tekst: ");
        for (String text: array) {
            System.out.print(text);
        }
    }

    public static String[] readText() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj tekst jawny (do zaszyfrowania): ");
        String lineIn = sc.nextLine();
        return lineIn.toUpperCase().split("");
    }
}
