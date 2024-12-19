package poggiani_streamexception;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class UsingInputStream {
    
    public static void readLineWithScanner() {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Inserisci una riga di testo (usando Scanner): ");
            String x = input.nextLine();
            System.out.println("Dato inserito con Scanner: " + x);
        } catch (InputMismatchException e) {
            System.err.println("Errore di tipo di dato in lettura con Scanner: " + e.getMessage());
        } catch (NoSuchElementException e) {
            System.err.println("Nessun elemento disponibile in lettura con Scanner: " + e.getMessage());
        } catch (IllegalStateException e) {
            System.err.println("Lo Scanner è stato chiuso prematuramente: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Si è verificato un errore imprevisto in lettura con Scanner: " + e.getMessage());
        }
    }
    
    public static void readLineWithBufferedReader() {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try { 
            System.out.print("Inserisci una riga di testo (usando BufferedReader): ");
            String x = input.readLine();
            System.out.println("Dato inserito con BufferedReader: " + x);
        } catch (IOException e) {
            System.err.println("Si è verificato un errore in lettura con BufferedReader: " + e.getMessage());
        } finally {
            try { input.close();
                System.out.println("BufferedReader chiuso correttamente.");
            } catch (IOException e) {
                System.err.println("Si è verificato un errore durante la chiusura di BufferedReader: " + e.getMessage());
            }
        }
    }
    
    public static void readIntegerWithScanner() {
        Scanner input = new Scanner(System.in);
        try {
            System.out.print("Inserisci un numero intero: ");
            int x = input.nextInt();
            System.out.println("Numero intero inserito: " + x);
        } catch (InputMismatchException e) {
            System.err.println("Errore, hai inserito un valore non numerico: " + e.getMessage());
        } catch (NoSuchElementException e) {
            System.err.println("Errore, nessun elemento disponibile in lettura: " + e.getMessage());
        } catch (IllegalStateException e) {
            System.err.println("Errore, Scanner chiuso prematuramente: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Si è verificato un errore imprevisto durante la lettura del numero: " + e.getMessage());
        }
    }
    
    public static void readIntegerWithBufferedReader() {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try { 
            System.out.print("Inserisci un numero intero (usando BufferedReader): ");
            String line = input.readLine();
            int x = Integer.parseInt(line);
            System.out.println("Numero intero inserito: " + x);
        } catch (IOException e) {
            System.err.println("Si è verificato un errore in lettura con BufferedReader: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Errore, il valore inserito non è un numero intero: " + e.getMessage());
        } finally {
            try {
                input.close();
                System.out.println("BufferedReader chiuso correttamente.");
            } catch (IOException e) {
                System.err.println("Si è verificato un errore durante la chiusura di BufferedReader: " + e.getMessage());
            }
        }
    }
    
    public static void readFromFileWithBufferedReader(String filePath) {
        try (BufferedReader fileReader = new BufferedReader(new FileReader(filePath))){
            String line;
            while ((line = fileReader.readLine()) != null) {
                System.out.println("Riga letta dal file: " + line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Errore, il file specificato non è stato trovato: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Errore durante la lettura del file con BufferedReader: " + e.getMessage());
        } 
    }
    
    public static void readFromFileWithScanner(String filePath) {
        try (Scanner fileReader = new Scanner(new FileReader(filePath))){
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                System.out.println("Riga letta dal file: " + line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Errore, il file specificato non è stato trovato: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Errore durante la lettura del file con Scanner: " + e.getMessage());
        } 
    }
}
