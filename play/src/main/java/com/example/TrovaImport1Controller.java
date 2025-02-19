package com.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class TrovaImport1Controller  {

    // Dichiarazione dei ToggleButton per le risposte
    @FXML
    private ToggleButton R1;  // Risposta 1
    @FXML
    private ToggleButton R2;  // Risposta giusta
    @FXML
    private ToggleButton R3;  // Risposta 3

    // Pulsanti per azioni successive
    @FXML
    private Button SE;  // Pulsante per una funzione non specificata
    @FXML
    private Button SC;  // Pulsante per una funzione non specificata

    @FXML
    private Button INVIO;  // Pulsante per inviare la risposta

   @FXML
    private Label rislabel;
    
    // Barra di progresso, creata ma non utilizzata direttamente
    ProgressBar ProgressoI = new ProgressBar();

    // Variabili per il controllo della selezione delle risposte
    Boolean check = false;  // Flag per determinare se una risposta è selezionata
    Boolean checkInvio = false;  // Flag per determinare se la risposta è stata inviata
    String t = null;  // Memorizza la risposta selezionata
    String s = null;  // Variabile non utilizzata direttamente nel codice

    // Metodo per incrementare il progresso
    public void increaseProgressI() throws Exception {
        App.increaseProgressI();  // Incremente il progresso (chiamata al metodo di App)
    }

    // Metodo per gestire la selezione della risposta 1
    @FXML
    protected void selectAnswer(ActionEvent e) throws IOException {
        // Se la risposta 1 è selezionata e non è stata premuta prima (check == false e t == null)
        if (R1.isSelected() && !check && t == null) {
            check = true;
            R2.setDisable(true);  // Disabilita le altre risposte
            R3.setDisable(true);
            t = R1.getText();  // Memorizza il testo della risposta selezionata

            System.out.println("Pulsante1 premuto on " + check);  // Log per il debug
        } 
        // Se la risposta 1 è già selezionata e il valore di t corrisponde al suo testo
        else if (R1.isSelected() && check && t.equals(R1.getText())) {
            check = false;
            R2.setDisable(false);  // Riabilita le risposte
            R3.setDisable(false);
            t = null;  // Reset della selezione
            System.out.println("Pulsante1 premuto off " + check + " " + t);  // Log per il debug
        }
    }

    // Metodo per gestire la selezione della risposta 2
    @FXML
    protected void selectAnswer2(ActionEvent e) throws IOException {
        // Se la risposta 2 è selezionata e non è stata selezionata prima (check == false e t == null)
        if (R2.isSelected() && !check && t == null) {
            check = true;
            R1.setDisable(true);  // Disabilita le altre risposte
            R3.setDisable(true);
            t = R2.getText();  // Memorizza il testo della risposta selezionata

            System.out.println("Pulsante2 premuto on " + check);  // Log per il debug
        } 
        // Se la risposta 2 è selezionata nuovamente, disabilita la selezione
        else if (R2.isSelected() && check && t.equals(R2.getText())) {
            check = false;
            R1.setDisable(false);  // Riabilita le risposte
            R3.setDisable(false);
            t = null;  // Reset della selezione
            System.out.println("Pulsante2 premuto off " + check + " " + t);  // Log per il debug
        }
    }

    // Metodo per gestire la selezione della risposta 3
    @FXML
    protected void selectAnswer3(ActionEvent e) throws IOException {
        // Se la risposta 3 è selezionata e non è stata selezionata prima (check == false e t == null)
        if (R3.isSelected() && !check && t == null) {
            check = true;
            R1.setDisable(true);  // Disabilita le altre risposte
            R2.setDisable(true);
            t = R3.getText();  // Memorizza il testo della risposta selezionata

            System.out.println("Pulsante3 premuto on " + check);  // Log per il debug
        } 
        // Se la risposta 3 è selezionata nuovamente, disabilita la selezione
        else if (R3.isSelected() && check && t.equals(R3.getText())) {
            check = false;
            R1.setDisable(false);  // Riabilita le risposte
            R2.setDisable(false);
            t = null;  // Reset della selezione
            System.out.println("Pulsante3 premuto off " + check + " " + t);  // Log per il debug
        }
    }

    // Metodo per salvare e uscire dal livello corrente
    @FXML
    protected void SalvaEdEsci(ActionEvent e) throws Exception {
        // Lettura dei file per ottenere i dati degli utenti e dell'accesso
        Scanner scf = new Scanner(new File("utenti.txt"));
        Scanner scf2 = new Scanner(new File("Accesso.txt"));
        PrintWriter pw = new PrintWriter(new FileWriter("utentiSalvataggiI.txt", true));
        PrintWriter pwBar = new PrintWriter(new FileWriter("ProgressoBarI.txt", true));
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

            // Salva lo stato dell'utente nel file di salvataggio
            pw.println(ri.get(0) + " " + "es1I");
            pw.close();  // Chiude il file di salvataggio
            App.increaseProgressI();  // Incrementa il progresso
            pwBar.println(o + " " + "0.33");  // Aggiorna la barra di progresso
            pwBar.close();  // Chiude il file della ProgressBar
            App.setRoot("home");  // Torna alla schermata principale
        } else {
            App.setRoot("home");  // Torna alla schermata principale se la risposta è errata
        }

        // Chiude gli oggetti Scanner
        scf.close();
        scf2.close();
    }

    // Metodo per inviare la risposta e confermare la selezione
    @FXML
    protected void invioRisposta(ActionEvent e) {
        // Se la risposta giusta (R2) è selezionata
        if (R2.isSelected()) {
            checkInvio = true;  // Imposta il flag per segnare che la risposta è stata inviata
            rislabel.setText("Rispsota Corretta!! ");
            System.out.println("Risposta confermata: " + R2.getText());  // Log per il debug
        } else {
            checkInvio = false;  // Imposta il flag se la risposta non è valida o non selezionata
            rislabel.setText("Rispsota Sbagliata ");
            System.out.println("Risposta non valida o non selezionata.");  // Log per il debug
        }
    }

    // Metodo per salvare i progressi e continuare al prossimo livello
    @FXML
    protected void SalvaEContinua(ActionEvent e) throws Exception {
        // Lettura dei file per ottenere i dati degli utenti e dell'accesso
        Scanner scf = new Scanner(new File("utenti.txt"));
        Scanner scf2 = new Scanner(new File("Accesso.txt"));
        PrintWriter pw = new PrintWriter(new FileWriter("utentiSalvataggiI.txt", true));
        PrintWriter pwBar = new PrintWriter(new FileWriter("ProgressoBarI.txt", true));
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

            // Salva lo stato dell'utente nel file di salvataggio
            pw.println(ri.get(0) + " " + "es1I");
            App.increaseProgressI();  // Incrementa il progresso
            pwBar.println(o + " " + "0.33");  // Aggiorna la barra di progresso
            pwBar.close();  // Chiude il file della ProgressBar
            pw.close();  // Chiude il file di salvataggio
            App.setRoot("trovaimport2");  // Passa al prossimo livello
            App.conta++;  // Incrementa il contatore per il prossimo livello
        }

        // Chiude gli oggetti Scanner
        scf.close();
        scf2.close();
    }
}
