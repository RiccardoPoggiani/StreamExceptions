package poggiani_streamexception;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class UsingInputStream {
    
    public static void usingScanner() {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Inserisci una riga di testo (usando Scanner): ");
            String x = input.nextLine();
            System.out.println("Valore inserito con Scanner: " + x);
        } catch (Exception e) {
            System.err.println("Si è verificato un errore in lettura con Scanner: " + e.getMessage());
        }
    }
    
    public static void usingBufferedReader() {
        
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        
        try{ 
            System.out.print("Inserisci una riga di testo (usando BufferedReader): ");
            String x = input.readLine();
            System.out.println("Valore inserito con BufferedReader: " + x);
        } catch (IOException e) {
            System.err.println("Si è verificato un errore in lettura con BufferedReader: " + e.getMessage());
        }
        
        try{ 
            input.close();
        } catch (IOException e) {
            System.err.println("Si è verificato un errore in scrittura: " + e.getMessage());
        }
        
    }
    
}
