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
            String evidentText = sc.nextLine();
            System.out.println("Podaj przesunięcie: ");

            int shift = sc.nextInt();
            sc.nextLine();
            System.out.println("Zaszystowany tekst : ");
            System.out.println(cesarCypher(evidentText, shift));

            System.out.println("Podaj tekst zaszyfrowaniy (do odszyfrowania): ");
            String cypherText = sc.nextLine();
            System.out.println("Podaj przesunięcie: ");

            shift = sc.nextInt();
            System.out.println("Tekst po deszyfracji : ");
            System.out.println(cesarDeCypher(cypherText, shift));
        } catch (InputMismatchException ex) {
            System.out.println("Podano błędny typ parametru przesunięcia - powinna to być liczba całkowita");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
