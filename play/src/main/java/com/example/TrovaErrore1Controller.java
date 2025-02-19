package com.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class TrovaErrore1Controller  { 

    // Dichiarazione dei ToggleButton che rappresentano le risposte
    @FXML
    private  ToggleButton R4;  // Risposta 4
    @FXML
    private  ToggleButton R1;  // Risposta 1
    @FXML
    private  ToggleButton R2;  // Risposta giusta
    @FXML
    private  ToggleButton R3;  // Risposta 3

    // Pulsanti per ulteriori azioni (es. uscita e invio)
    @FXML
    private  Button SE;  // Pulsante per una funzione non specificata
    @FXML
    private  Button SC;  // Pulsante per una funzione non specificata

    // Etichetta per visualizzare il risultato (corretto/errato)
    @FXML
    private Label label;

    // Pulsante per inviare la risposta
    @FXML
    private  Button INVIO;

    // Creazione della ProgressBar (non utilizzata direttamente nel codice)
    ProgressBar Progresso = new ProgressBar();

    // Variabili di stato per gestire le selezioni e il controllo del flusso
    Boolean check = false; // Variabile per determinare se una risposta è stata selezionata
    Boolean checkInvio = false; // Variabile per verificare se la risposta è stata inviata
    String t = null; // Memorizza la risposta selezionata
    String s = null; // Variabile per operazioni future (non utilizzata direttamente nel codice)

    // Metodo che incrementa il progresso
    public void increaseProgress() throws Exception {
        App.increaseProgress();  // Aumenta il progresso
    }

    // Metodo per gestire la selezione della risposta 1 (ToggleButton R1)
    @FXML
    protected void selectAnswer(ActionEvent e) throws IOException {
        // Se la risposta 1 è selezionata e non è stata selezionata precedentemente (check == false e t == null)
        if (R1.isSelected() && !check && t == null) {
            check = true;
            R2.setDisable(true);  // Disabilita le altre risposte
            R3.setDisable(true);
            R4.setDisable(true);
            t = R1.getText();  // Memorizza il testo della risposta selezionata

            System.out.println("Pulsante1 premuto on " + check);  // Log per il debug
        } 
        // Se la risposta 1 è selezionata nuovamente, disabilita la selezione
        else if (R1.isSelected() && check && t.equals(R1.getText())) {
            check = false;
            R2.setDisable(false);  // Riabilita le risposte
            R3.setDisable(false);
            R4.setDisable(false);
            t = null;  // Reset della selezione
            System.out.println("Pulsante1 premuto off " + check + " " + t);  // Log per il debug
        }
    }

    // Metodo per gestire la selezione della risposta 2 (ToggleButton R2)
    @FXML
    protected void selectAnswer2(ActionEvent e) throws IOException {
        if (R2.isSelected() && !check && t == null) {
            check = true;
            R1.setDisable(true);  // Disabilita le altre risposte
            R3.setDisable(true);
            R4.setDisable(true);
            t = R2.getText();  // Memorizza il testo della risposta selezionata

            System.out.println("Pulsante2 premuto on " + check);  // Log per il debug
        } else if (R2.isSelected() && check && t.equals(R2.getText())) {
            check = false;
            R1.setDisable(false);  // Riabilita le risposte
            R3.setDisable(false);
            R4.setDisable(false);
            t = null;  // Reset della selezione
            System.out.println("Pulsante2 premuto off " + check + " " + t);  // Log per il debug
        }
    }

    // Metodo per gestire la selezione della risposta 3 (ToggleButton R3)
    @FXML
    protected void selectAnswer3(ActionEvent e) throws IOException {
        if (R3.isSelected() && !check && t == null) {
            check = true;
            R1.setDisable(true);  // Disabilita le altre risposte
            R2.setDisable(true);
            R4.setDisable(true);
            t = R3.getText();  // Memorizza il testo della risposta selezionata

            System.out.println("Pulsante3 premuto on " + check);  // Log per il debug
        } else if (R3.isSelected() && check && t.equals(R3.getText())) {
            check = false;
            R1.setDisable(false);  // Riabilita le risposte
            R2.setDisable(false);
            R4.setDisable(false);
            t = null;  // Reset della selezione
            System.out.println("Pulsante3 premuto off " + check + " " + t);  // Log per il debug
        }
    }

    // Metodo per gestire la selezione della risposta 4 (ToggleButton R4)
    @FXML 
    protected void selectAnswer4(ActionEvent e) throws IOException {
        if (R4.isSelected() && !check && t == null) {
            check = true;
            R1.setDisable(true);  // Disabilita le altre risposte
            R2.setDisable(true);
            R3.setDisable(true);
            t = R4.getText();  // Memorizza il testo della risposta selezionata

            System.out.println("Pulsante4 premuto on " + check);  // Log per il debug
        } else if (R4.isSelected() && check && t.equals(R4.getText())) {
            check = false;
            R1.setDisable(false);  // Riabilita le risposte
            R2.setDisable(false);
            R3.setDisable(false);
            t = null;  // Reset della selezione
            System.out.println("Pulsante4 premuto off " + check);  // Log per il debug
        }
    }

    // Metodo che gestisce l'invio della risposta e la visualizzazione del risultato
    @FXML
    protected void invioRisposta(ActionEvent e) throws Exception {
        checkInvio = true;  // Setta il flag per verificare se la risposta è stata inviata
        // Se la risposta giusta (R2) è selezionata, visualizza "RISPOSTA ESATTA"
        if (R2.isSelected())
            label.setText("RISPOSTA ESATTA"); 
        // Se una risposta errata (R1, R3, R4) è selezionata, mostra il tipo di errore
        else if (R1.isSelected() || R3.isSelected() || R4.isSelected()) {
            if (R1.isSelected())
                label.setText("RISPOSTA ERRATA 1"); 
            if (R3.isSelected())
                label.setText("RISPOSTA ERRATA 3"); 
            if (R4.isSelected())
                label.setText("RISPOSTA ERRATA 4"); 
        }
    }

    // Metodo che salva i progressi e chiude l'applicazione
    @FXML 
    protected void SalvaEdEsci(ActionEvent e ) throws Exception {
        // Creazione degli oggetti Scanner per leggere i file e PrintWriter per scrivere i dati
        Scanner scf = new Scanner(new File("utenti.txt"));
        Scanner scf2 = new Scanner(new File("Accesso.txt"));
        PrintWriter pw = new PrintWriter(new FileWriter("utentiSalvataggi.txt", true));
        PrintWriter pwBar = new PrintWriter(new FileWriter("ProgressoBar.txt", true));
        String o = null;  // Memorizza l'utente corrente
        ArrayList<String> Righe = new ArrayList<>();  // Lista per memorizzare gli utenti dal file
        ArrayList<String> ri = new ArrayList<>();  // Lista per memorizzare l'utente corrente

        // Se la risposta giusta (R2) è selezionata
        if (R2.isSelected()) {
            // Aggiunge gli utenti dal file "utenti.txt"
            while (scf.hasNextLine()) {
                String s = scf.nextLine();
                String[] S = s.split(" ");
                Righe.add(S[0]);  // Memorizza il nome dell'utente
            }
            // Aggiunge l'utente corrente dal file "Accesso.txt"
            while (scf2.hasNextLine()) {
                o = scf2.nextLine();
                ri.add(o);  // Memorizza l'utente corrente
            }

            // Se l'utente corrente è presente nella lista degli utenti
            if (Righe.contains(ri.get(0)))
                System.out.println(ri.get(0));  // Log per il debug

            // Scrive lo stato dell'utente nel file di salvataggi
            pw.println(ri.get(0) + " " + "es1");
            pw.close();  // Chiude il file di salvataggi
            App.increaseProgress();  // Incrementa il progresso dell'utente
            pwBar.println(o + " " + "0.33");  // Aggiorna la ProgressBar
            pwBar.close();  // Chiude il file della ProgressBar
            App.setRoot("home");  // Torna alla schermata principale
        } else {
            App.setRoot("home");  // Torna alla schermata principale se la risposta è errata
        }

        // Chiude gli oggetti Scanner
        scf.close();
        scf2.close();
    }

    // Metodo che salva i progressi e continua al prossimo livello
    @FXML 
    protected void SalvaEContinua(ActionEvent e ) throws Exception {
        // Creazione degli oggetti Scanner per leggere i file e PrintWriter per scrivere i dati
        Scanner scf = new Scanner(new File("utenti.txt"));
        Scanner scf2 = new Scanner(new File("Accesso.txt"));
        PrintWriter pw = new PrintWriter(new FileWriter("utentiSalvataggi.txt", true));
        PrintWriter pwBar = new PrintWriter(new FileWriter("ProgressoBar.txt", true));
        String o = null;  // Memorizza l'utente corrente
        ArrayList<String> Righe = new ArrayList<>();  // Lista per memorizzare gli utenti dal file
        ArrayList<String> ri = new ArrayList<>();  // Lista per memorizzare l'utente corrente

        // Se la risposta giusta (R2) è selezionata e la risposta è stata inviata
        if (R2.isSelected() && checkInvio == true) {
            // Aggiunge gli utenti dal file "utenti.txt"
            while (scf.hasNextLine()) {
                String s = scf.nextLine();
                String[] S = s.split(" ");
                Righe.add(S[0]);  // Memorizza il nome dell'utente
            }
            // Aggiunge l'utente corrente dal file "Accesso.txt"
            while (scf2.hasNextLine()) {
                o = scf2.nextLine();
                ri.add(o);  // Memorizza l'utente corrente
            }

            // Se l'utente corrente è presente nella lista degli utenti
            if (Righe.contains(ri.get(0)))
                System.out.println(ri.get(0));  // Log per il debug

            // Scrive lo stato dell'utente nel file di salvataggi
            pw.println(ri.get(0) + " " + "es1");
            App.increaseProgress();  // Incrementa il progresso dell'utente
            pwBar.println(o + " " + "0.33");  // Aggiorna la ProgressBar
            pwBar.close();  // Chiude il file della ProgressBar
            pw.close();  // Chiude il file di salvataggi
            App.setRoot("trova_errore2");  // Passa alla schermata successiva (esercizio 2)
        }

        // Chiude gli oggetti Scanner
        scf.close();
        scf2.close();
    }
}
