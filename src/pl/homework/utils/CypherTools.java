package pl.homework.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

public class CypherTools {

    public static final String LETTER_DB_FILE = "cypher.db";
    public static String[] letters;
    public static String[] cypherLetters;

    private static void readDBLetters() throws IOException {
        File file = new File(LETTER_DB_FILE);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line = bufferedReader.readLine();
        letters = line.split(" ");
        bufferedReader.close();
    }

    public static void shiftLetters(int shift) throws IOException {
        readDBLetters();
        cypherLetters = new String[letters.length];
        for (int i = 0; i< letters.length; i++) {
            cypherLetters[i] = letters[(i + shift-1)%letters.length];
        }
    }

    public static String cesarCypher(String evidentText, int shift) throws IOException {
        shiftLetters(shift);
        String[] array = evidentText.toUpperCase().split("");
        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < letters.length; j++) {
                if (letters[j].equals(array[i])) {
                    array[i] = cypherLetters[j];
                    break;
                }
            }
        }
        String cypherText="";
        for (String text: array) {
            cypherText += text;
        }
        return cypherText;
    }

    public static String cesarDeCypher(String cypherText, int shift) throws IOException {
        shiftLetters(shift);
        String[] array = cypherText.toUpperCase().split("");
        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < cypherLetters.length; j++) {
                if (cypherLetters[j].equals(array[i])) {
                    array[i] = letters[j];
                    break;
                }
            }
        }
        String evidentText="";
        for (String text: array) {
            evidentText += text;
        }
        return evidentText;
    }
}
