package com.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;
import java.util.*;

public class App extends Application {

    // dichiarazione degli oggetti utilizzabili su più pagine 
    public static int conta = 0;  // Conta un valore intero (forse il numero di sessioni o eventi)
    public static Utente u;  // Oggetto Utente (probabilmente per rappresentare un utente nel sistema)
    private static double progress = 0.00;  // Progresso per una barra di progresso (probabilmente la progress bar di "Trova")
    private static double progressI = 0.00;  // Progresso per un'altra barra di progresso (probabilmente la progress bar di "TrovaImport")
    private static double progressII = 0.00;  // Un altro progresso, potrebbe essere una terza barra di progresso
    private static Scene scene;  // La scena di JavaFX
    public static Scanner scf;  // Scanner per leggere dai file (per la gestione dei progressi)

    @Override
    // Funzione adibita al caricamento delle pagine
    public void start(Stage stage) throws IOException {
        // Carica la pagina "SignOrLog.fxml" e imposta la scena di dimensioni 640x480
        scene = new Scene(loadFXML("SignOrLog"), 640, 480);
        stage.setScene(scene);  // Imposta la scena per la finestra
        stage.setTitle("P.L.A.Y");  // Titolo della finestra
        stage.show();  // Mostra la finestra
    }

    // Funzione per cambiare il contenuto della scena, caricando una nuova pagina FXML
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));  // Cambia la radice della scena
    }

    // Funzione privata che carica il file FXML e lo restituisce come oggetto Parent
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();  // Carica e restituisce la pagina FXML
    }

    // Funzione per incrementare il progresso della prima barra di progresso
    public static void increaseProgress() {
        progress += 0.33;  // Incrementa il progresso di 0.33
        if (progress > 1) {
            progress = 1.0;  // Limita il progresso al massimo del 100%
        }
    }

    // Funzione per ottenere il valore del progresso della barra di progresso "Trova"
    public static double getProgress(String o) throws Exception {
        HashMap<String, String> progressi = new HashMap<>();  // Mappa per memorizzare i progressi degli utenti
        scf = new Scanner(new File("ProgressoBar.txt"));  // Legge il file che contiene i progressi

        while (scf.hasNextLine()) {
            String s = scf.nextLine();
            String[] sv = s.split(" ");  // Dividi ogni riga in due parti
            if (sv.length >= 2)
                progressi.put(sv[0], sv[1]);  // Metti il nome utente e il progresso nella mappa
        }

        // Se la mappa contiene il nome utente specificato, verifica il progresso
        if (progressi.containsKey(o)) {
            String progresso = progressi.get(o);  // Ottieni il valore del progresso per l'utente
            if (progresso.equals("0.33")) {
                progress = Double.parseDouble(progresso);  // Imposta il valore di progress
            } else if (progresso.equals("0.66")) {
                progress = Double.parseDouble(progresso);  // Imposta il valore di progress
            } else if (progresso.equals("0.99")) {
                progress = Double.parseDouble(progresso) + 0.01;  // Incrementa leggermente il progresso
            }
        }
        else{
            progress =0.0;
        }
        return progress;  // Ritorna il valore del progresso
    }

    // Funzione per incrementare il progresso della seconda barra di progresso (TrovaImport)
    public static void increaseProgressI() {
        progressI += 0.33;  // Incrementa il progresso di 0.33
        if (progressI > 1) {
            progressI = 1.0;  // Limita il progresso al massimo del 100%
        }
    }

    // Funzione per ottenere il valore del progresso della barra di progresso "TrovaImport"
    public static double getProgressI(String o) throws Exception {
        HashMap<String, String> progressi = new HashMap<>();  // Mappa per memorizzare i progressi degli utenti
        scf = new Scanner(new File("ProgressoBarI.txt"));  // Legge il file che contiene i progressi di TrovaImport

        while (scf.hasNextLine()) {
            String s = scf.nextLine();
            String[] sv = s.split(" ");  // Dividi ogni riga in due parti
            if (sv.length >= 2)
                progressi.put(sv[0], sv[1]);  // Metti il nome utente e il progresso nella mappa
        }

        // Se la mappa contiene il nome utente specificato, verifica il progresso
        if (progressi.containsKey(o)) {
            String progresso = progressi.get(o);  // Ottieni il valore del progresso per l'utente
            if (progresso.equals("0.33")) {
                progressI = Double.parseDouble(progresso);  // Imposta il valore di progress
            } else if (progresso.equals("0.66")) {
                progressI = Double.parseDouble(progresso);  // Imposta il valore di progress
            } else if (progresso.equals("0.99")) {
                progressI = Double.parseDouble(progresso) + 0.01;  // Incrementa leggermente il progresso
            }
        }
        else{
            progressI=0.0;
        }
        return progressI;  // Ritorna il valore del progresso

    }

    // Funzione per incrementare il progresso della terza barra di progresso
    public static void increaseProgressII() {
        progressII += 0.33;  // Incrementa il progresso di 0.33
        if (progressII > 1) {
            progressII = 1.0;  // Limita il progresso al massimo del 100%
        }
    }

    // Funzione per ottenere il valore del progresso della barra di progresso "TrovaImportII"
    public static double getProgressII(String o) throws Exception {
        HashMap<String, String> progressi = new HashMap<>();  // Mappa per memorizzare i progressi degli utenti
        scf = new Scanner(new File("ProgressoBarII.txt"));  // Legge il file che contiene i progressi di TrovaImportII

        while (scf.hasNextLine()) {
            String s = scf.nextLine();
            String[] sv = s.split(" ");  // Dividi ogni riga in due parti
            if (sv.length >= 2)
                progressi.put(sv[0], sv[1]);  // Metti il nome utente e il progresso nella mappa
        }

        // Se la mappa contiene il nome utente specificato, verifica il progresso
        if (progressi.containsKey(o)) {
            String progresso = progressi.get(o);  // Ottieni il valore del progresso per l'utente
            if (progresso.equals("0.33")) {
                progressII = Double.parseDouble(progresso);  // Imposta il valore di progress
            } else if (progresso.equals("0.66")) {
                progressII = Double.parseDouble(progresso);  // Imposta il valore di progress
            } else if (progresso.equals("0.99")) {
                progressII = Double.parseDouble(progresso) + 0.01;  // Incrementa leggermente il progresso
            }
        }
        else{
            progressII =0.0;
        }
        return progressII;  // Ritorna il valore del progresso
    }

    // Funzione principale che avvia l'applicazione
    public static void main(String[] args) {
        launch();  // Lancio dell'applicazione
    }
}
