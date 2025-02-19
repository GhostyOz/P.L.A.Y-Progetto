package com.example;

import java.io.File;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Button;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;

public class ınfoAggiunteController {

    // Metodo per aprire un file specificato dal percorso passato come parametro
    public void OpenFile(String filePath) throws IOException{
        // Crea un oggetto File con il percorso fornito
        File file = new File(filePath);
        
        // Verifica se il file esiste
        if (file.exists()) {
            // Su macOS, usa il comando "open" per aprire il file
            new ProcessBuilder("open", file.getAbsolutePath()).start();
        } else {
            // Se il file non esiste, stampa un messaggio di errore
            System.out.println("File does not exist: " + file.getAbsolutePath());
        }
    }

    // Metodo per aprire il file "ArrayList.pdf" dalla risorsa
    public void OpenArrayList() throws IOException{
        // Ottiene il URL della risorsa "ArrayList.pdf" dal class loader
        URL resource = getClass().getClassLoader().getResource("ArrayList.pdf");
        if (resource != null) {
            // Decodifica il percorso URL per gestire gli spazi e i caratteri speciali
            String decodedPath = URLDecoder.decode(resource.getPath(), "UTF-8");

            // Stampa il percorso decodificato per il debug
            System.out.println("Decoded Resource path: " + decodedPath);

            // Chiama il metodo OpenFile con il percorso decodificato come stringa
            OpenFile(decodedPath);
        } else {
            // Se la risorsa non è trovata, stampa un messaggio di errore
            System.out.println("Resource not found: ArrayList.pdf");
        }
    }

    // Metodo per aprire il file "FileActions.pdf" dalla risorsa
    public void OpenFileReader() throws IOException{
        // Ottiene il URL della risorsa "FileActions.pdf" dal class loader
        URL resource = getClass().getClassLoader().getResource("FileActions.pdf");
        if (resource != null) {
            // Decodifica il percorso URL per gestire gli spazi e i caratteri speciali
            String decodedPath = URLDecoder.decode(resource.getPath(), "UTF-8");

            // Stampa il percorso decodificato per il debug
            System.out.println("Decoded Resource path: " + decodedPath);

            // Chiama il metodo OpenFile con il percorso decodificato come stringa
            OpenFile(decodedPath);
        } else {
            // Se la risorsa non è trovata, stampa un messaggio di errore
            System.out.println("Resource not found: FileActions.pdf");
        }
    }

    // Metodo per aprire il file "Ricorsione.pdf" dalla risorsa
    public void OpenRicorsione() throws IOException{
        // Ottiene il URL della risorsa "Ricorsione.pdf" dal class loader
        URL resource = getClass().getClassLoader().getResource("Ricorsione.pdf");
        if (resource != null) {
            // Decodifica il percorso URL per gestire gli spazi e i caratteri speciali
            String decodedPath = URLDecoder.decode(resource.getPath(), "UTF-8");

            // Stampa il percorso decodificato per il debug
            System.out.println("Decoded Resource path: " + decodedPath);

            // Chiama il metodo OpenFile con il percorso decodificato come stringa
            OpenFile(decodedPath);
        } else {
            // Se la risorsa non è trovata, stampa un messaggio di errore
            System.out.println("Resource not found: Ricorsione.pdf");
        }
    }

    // Metodo per aprire il file "Matrici.pdf" dalla risorsa
    public void OpenMatrici() throws IOException{
        // Ottiene il URL della risorsa "Matrici.pdf" dal class loader
        URL resource = getClass().getClassLoader().getResource("Matrici.pdf");
        if (resource != null) {
            // Decodifica il percorso URL per gestire gli spazi e i caratteri speciali
            String decodedPath = URLDecoder.decode(resource.getPath(), "UTF-8");

            // Stampa il percorso decodificato per il debug
            System.out.println("Decoded Resource path: " + decodedPath);

            // Chiama il metodo OpenFile con il percorso decodificato come stringa
            OpenFile(decodedPath);
        } else {
            // Se la risorsa non è trovata, stampa un messaggio di errore
            System.out.println("Resource not found: Matrici.pdf");
        }
    }

    // Metodo per aprire il file "Array.pdf" dalla risorsa
    public void OpenArray() throws IOException{
        // Ottiene il URL della risorsa "Array.pdf" dal class loader
        URL resource = getClass().getClassLoader().getResource("Array.pdf");
        if (resource != null) {
            // Decodifica il percorso URL per gestire gli spazi e i caratteri speciali
            String decodedPath = URLDecoder.decode(resource.getPath(), "UTF-8");

            // Stampa il percorso decodificato per il debug
            System.out.println("Decoded Resource path: " + decodedPath);

            // Chiama il metodo OpenFile con il percorso decodificato come stringa
            OpenFile(decodedPath);
        } else {
            // Se la risorsa non è trovata, stampa un messaggio di errore
            System.out.println("Resource not found: Array.pdf");
        }
    }

    // Metodo per aprire il file "Scanner.pdf" dalla risorsa
    public void OpenScanner() throws IOException{
        // Ottiene il URL della risorsa "Scanner.pdf" dal class loader
        URL resource = getClass().getClassLoader().getResource("Scanner.pdf");
        if (resource != null) {
            // Decodifica il percorso URL per gestire gli spazi e i caratteri speciali
            String decodedPath = URLDecoder.decode(resource.getPath(), "UTF-8");

            // Stampa il percorso decodificato per il debug
            System.out.println("Decoded Resource path: " + decodedPath);

            // Chiama il metodo OpenFile con il percorso decodificato come stringa
            OpenFile(decodedPath);
        } else {
            // Se la risorsa non è trovata, stampa un messaggio di errore
            System.out.println("Resource not found: Scanner.pdf");
        }
    }

    // Metodo che gestisce il passaggio alla pagina "home"
    public void switchToHome(ActionEvent e) throws Exception{
        App.setRoot("home"); // Cambia la root dell'applicazione alla schermata "home"
    }

}
