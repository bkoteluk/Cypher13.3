package pl.homework.app;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static pl.homework.utils.CypherTools.*;

public class CypherTest {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Podaj tekst jawny (do zaszyfrowania): ");
            String lineIn = sc.nextLine();
            System.out.println("Podaj przesunięcie: ");
            try {
               int shift = sc.nextInt();
               shiftLetters(shift);
               cesarCypher(lineIn.toUpperCase().split(""));
            } catch (InputMismatchException ex) {
                System.out.println("Podano błędny typ parametru przesunięcia - powinna to być liczba całkowita");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
