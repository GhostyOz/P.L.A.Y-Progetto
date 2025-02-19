package com.example;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;

public class RiordinaCodice3controller {

    // Dichiarazione dei pulsanti per l'interfaccia utente
    @FXML
    private Button INVIO; // Pulsante per inviare la risposta
    @FXML
    private Button SE;   // Pulsante per un'azione non specificata nel codice
    @FXML
    private Button SC;   // Pulsante per un'azione non specificata nel codice

    // Dichiarazione delle TextArea per i blocchi di codice
    @FXML
    private TextArea Blocco1; // Blocco di codice 1
    @FXML
    private TextArea Blocco2; // Blocco di codice 2
    @FXML
    private TextArea Blocco3; // Blocco di codice 3
    @FXML
    private TextArea BloccoS1; // Area per il blocco corretto 1
    @FXML
    private TextArea BloccoS2; // Area per il blocco corretto 2
    @FXML
    private TextArea BloccoS3; // Area per il blocco corretto 3

    // Creazione di una ProgressBar (non utilizzata direttamente nel codice)
    ProgressBar ProgressoII = new ProgressBar();

    // Variabili di stato per verificare se l'ordine dei blocchi è corretto
    public boolean isCorrectOrder;
    
    public String bloccos1, bloccos2, bloccos3;

    // Dichiarazione dei file per la gestione degli utenti, accesso, salvataggi e progresso
    public File utentiFile = new File("utenti.txt");
    public File accessoFile = new File("Accesso.txt");
    public File salvataggiFile = new File("utentiSalvataggiII.txt");
    public File progressFile = new File("ProgressoBarII.txt");

    // Metodo per aumentare il progresso (chiama il metodo increaseProgressII dalla classe App)
    public void increaseProgressII() throws Exception {
        App.increaseProgressII();
    }

    // Metodo di inizializzazione chiamato all'avvio della scena
    @FXML
    public void initialize() {
        // Configura le TextArea come sorgenti per il drag-and-drop
        setupGestureSource(Blocco1);
        setupGestureSource(Blocco2);
        setupGestureSource(Blocco3);

        // Configura le TextArea come destinazioni per il drag-and-drop
        setupGestureTarget(BloccoS1);
        setupGestureTarget(BloccoS2);
        setupGestureTarget(BloccoS3);
    }

    // Metodo che configura una TextArea come sorgente per il drag-and-drop
    private void setupGestureSource(final TextArea source) {
        source.setOnDragDetected((MouseEvent event) -> {
            // Inizia un'operazione di drag-and-drop quando l'utente inizia a trascinare
            Dragboard db = source.startDragAndDrop(TransferMode.ANY);
            ClipboardContent content = new ClipboardContent();
            content.putString(source.getText()); // Aggiunge il contenuto del testo della TextArea
            db.setContent(content); // Aggiunge il contenuto al dragboard
            event.consume(); // Consuma l'evento per evitare che venga propagato
        });

        source.setOnDragDone((DragEvent event) -> {
            // Se il drag-and-drop è stato completato con successo, cancella il testo dalla TextArea
            if (event.getTransferMode() == TransferMode.MOVE) {
                source.clear();
            }
            event.consume(); // Consuma l'evento per evitare che venga propagato
        });
    }

    // Metodo che configura una TextArea come destinazione per il drag-and-drop
    private void setupGestureTarget(final TextArea target) {
        target.setOnDragOver((DragEvent event) -> {
            // Se la sorgente non è la stessa destinazione e il dragboard ha una stringa, accetta il trasferimento
            if (event.getGestureSource() != target && event.getDragboard().hasString() && target.getText().isEmpty()) {
                event.acceptTransferModes(TransferMode.COPY_OR_MOVE); // Accetta il trasferimento
            }
            event.consume(); // Consuma l'evento per evitare che venga propagato
        });

        target.setOnDragDropped((DragEvent event) -> {
            Dragboard db = event.getDragboard();
            boolean success = false;

            // Se il dragboard ha una stringa e la TextArea è vuota, imposta il testo della destinazione
            if (db.hasString() && target.getText().isEmpty()) {
                target.setText(db.getString()); // Imposta il testo della destinazione
                success = true;
            }

            event.setDropCompleted(success); // Indica che l'operazione di drop è completata
            event.consume(); // Consuma l'evento per evitare che venga propagato
        });
    }

    // Metodo che viene chiamato quando l'utente invia la risposta
    @FXML
    private void invioRisposta(ActionEvent e) throws Exception {
        // Legge i testi dai blocchi e li rimuove gli spazi prima e dopo
        bloccos1 = Blocco2.getText().trim();
        bloccos2 = Blocco1.getText().trim();
        bloccos3 = Blocco3.getText().trim();

        // Verifica se l'ordine dei blocchi è corretto confrontando il testo nelle TextArea
        isCorrectOrder = BloccoS1.getText().trim().equals(bloccos1) &&
                         BloccoS2.getText().trim().equals(bloccos2) &&
                         BloccoS3.getText().trim().equals(bloccos3);

        // Se l'ordine non è corretto, ricarica la scena corrente
        if (!isCorrectOrder)
            App.setRoot("riordina_codice3"); // Rimane sulla scena corrente in caso di ordine errato
    }

    // Metodo che salva i progressi e chiude l'applicazione
    @FXML
    private void SalvaEdEsci(ActionEvent e) throws Exception {
        try (
            Scanner utentiScanner = new Scanner(utentiFile); // Scansione del file degli utenti
            Scanner accessoScanner = new Scanner(accessoFile); // Scansione del file di accesso
            PrintWriter writer = new PrintWriter(new FileWriter(salvataggiFile, true)); // Scrittura nel file di salvataggi
            PrintWriter pwBar = new PrintWriter(new FileWriter(progressFile, true)); // Scrittura nel file di progresso
        ) {
            // Aggiunge gli utenti al ArrayList
            ArrayList<String> utenti = new ArrayList<>();
            while (utentiScanner.hasNextLine()) {
                utenti.add(utentiScanner.nextLine().split(" ")[0]);
            }

            // Legge l'utente corrente dal file di accesso
            String utenteCorrente = accessoScanner.hasNextLine() ? accessoScanner.nextLine() : "";

            // Se l'ordine dei blocchi è corretto e l'utente è presente nel file degli utenti
            if (isCorrectOrder) {
                if (utenti.contains(utenteCorrente)) {
                    writer.println(utenteCorrente + " " + "es3II"); // Salva lo stato dell'utente nel file di salvataggi
                    App.increaseProgressII(); // Incrementa il progresso dell'utente
                    pwBar.println(utenteCorrente + " " + "0.99"); // Salva il progresso nel file del progresso
                    pwBar.close();
                }
                App.setRoot("home"); // Cambia la scena alla home
            } else {
                App.setRoot("home"); // Cambia la scena alla home in caso di ordine errato
            }
        } catch (Exception ex) {
            // Gestione delle eccezioni, stampa l'errore in caso di problemi
            System.err.println("Si è verificato un errore: " + ex.getMessage());
        }
    }

    // Metodo che salva i progressi e continua al prossimo livello
    @FXML
    private void SalvaEContinua(ActionEvent e) throws Exception {
        try (
            Scanner utentiScanner = new Scanner(utentiFile); // Scansione del file degli utenti
            Scanner accessoScanner = new Scanner(accessoFile); // Scansione del file di accesso
            PrintWriter writer = new PrintWriter(new FileWriter(salvataggiFile, true)); // Scrittura nel file di salvataggi
            PrintWriter pwBar = new PrintWriter(new FileWriter(progressFile, true)); // Scrittura nel file di progresso
        ) {
            // Aggiunge gli utenti al ArrayList
            ArrayList<String> utenti = new ArrayList<>();
            while (utentiScanner.hasNextLine()) {
                utenti.add(utentiScanner.nextLine().split(" ")[0]);
            }

            // Legge l'utente corrente dal file di accesso
            String utenteCorrente = accessoScanner.hasNextLine() ? accessoScanner.nextLine() : "";

            // Se l'ordine dei blocchi è corretto e l'utente è presente nel file degli utenti
            if (isCorrectOrder) {
                if (utenti.contains(utenteCorrente)) {
                    writer.println(utenteCorrente + " " + "es3II"); // Salva lo stato dell'utente nel file di salvataggi
                    App.increaseProgressII(); // Incrementa il progresso dell'utente
                    pwBar.println(utenteCorrente + " " + "0.99"); // Salva il progresso nel file del progresso
                    pwBar.close();
                }
                App.setRoot("es3Superato"); // Cambia la scena al prossimo livello
            } else {
                App.setRoot("home"); // Cambia la scena alla home in caso di ordine errato
            }
        } catch (Exception ex) {
            // Gestione delle eccezioni, stampa l'errore in caso di problemi
            System.err.println("Si è verificato un errore: " + ex.getMessage());
        }
    }
}

