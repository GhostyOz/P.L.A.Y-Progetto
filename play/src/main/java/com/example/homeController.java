package com.example;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Button;
import java.util.*;
import java.io.*;

public class homeController {
   @FXML
   private Button CambiaAccount; // Bottone per cambiare account
   @FXML 
   private Button BottoneEs1;   // Bottone per il primo esercizio
   @FXML 
   private Button BottoneEs2;   // Bottone per il secondo esercizio
   @FXML 
   private Button BottoneEs3;   // Bottone per il terzo esercizio
   @FXML
   private ProgressBar Progresso;  // Barra di progresso per il primo esercizio
   @FXML
   private ProgressBar ProgressoI; // Barra di progresso per il secondo esercizio
   @FXML
   private ProgressBar ProgressoII; // Barra di progresso per il terzo esercizio
   public Scanner scf1; // Scanner per leggere il file "Accesso.txt"
   public Scanner scf2; // Scanner per leggere i file di salvataggio esercizi dell'utente

   // Metodo che gestisce il passaggio alla pagina degli esercizi "Trova l'errore"
   public void switchToTrovaErrore(ActionEvent e) throws IOException{
       // scf1 carica il nome dell'utente che ha effettuato l'accesso dal file "Accesso.txt"
       scf1 = new Scanner (new File("Accesso.txt")); 
       // scf2 carica i dati degli esercizi completati dall'utente dal file "utentiSalvataggi.txt"
       scf2 = new Scanner(new File("utentiSalvataggi.txt"));
       
       // HashMap che associa ogni utente agli esercizi che ha completato
       HashMap<String,String> UtentiEsercizi = new HashMap<>();
       String s = null; // Variabile che memorizza il nome dell'utente caricato dal file "Accesso.txt"
       
       // Carica il nome dell'utente dal file "Accesso.txt"
       while(scf1.hasNextLine())
           s = scf1.nextLine(); 

       // Riempie l'HashMap con i dati presenti nel file "utentiSalvataggi.txt"
       while(scf2.hasNextLine()){
           String S = scf2.nextLine(); 
           String[]Sv = S.trim().split(" "); 
           if (Sv.length == 2) { 
               UtentiEsercizi.put(Sv[0], Sv[1]); 
           } else {
               System.out.println("La stringa errore è :  " + S); // Gestione errore se la stringa non è formattata correttamente
           }
       }

       // Se l'utente è presente nella mappa, seleziona la pagina da aprire in base agli esercizi completati
       if (UtentiEsercizi.containsKey(s)) {
           String valoreCorrente = UtentiEsercizi.get(s);

           // Verifica il valore associato all'utente e apre la pagina corrispondente
           if (valoreCorrente.equals("es1")) {
               App.setRoot("trova_errore2"); // Se l'utente ha completato "es1", apre "trova_errore2"
           } 
           if (valoreCorrente.equals("es2")) {
               App.setRoot("trova_errore3"); // Se l'utente ha completato "es2", apre "trova_errore3"
           }
           if (valoreCorrente.equals("es3")) {
               App.setRoot("es1Superato"); // Se l'utente ha completato "es3", apre "es1Superato"
           }
       } else { // Se l'utente non ha completato nessun esercizio, apre la pagina del regolamento
           App.setRoot("regolamento");
       }
   }

   // Metodo che gestisce il passaggio alla pagina degli esercizi "Trova Import"
   public void switchToTrovaImport(ActionEvent e) throws IOException{
       scf1 = new Scanner (new File("Accesso.txt")); 
       scf2 = new Scanner(new File("utentiSalvataggiI.txt")); // Carica i salvataggi degli esercizi "Trova Import"
       
       HashMap<String,String> UtentiEsercizi = new HashMap<>();
       String s = null;

       while(scf1.hasNextLine())
           s = scf1.nextLine(); 

       // Riempie l'HashMap con i dati del file "utentiSalvataggiI.txt"
       while(scf2.hasNextLine()){
           String S = scf2.nextLine(); 
           String[]Sv = S.trim().split(" "); 
           if (Sv.length == 2) { 
               UtentiEsercizi.put(Sv[0], Sv[1]); 
           }
       }

       // Se l'utente ha completato degli esercizi, seleziona la pagina da aprire
       if (UtentiEsercizi.containsKey(s)) {
           String valoreCorrente = UtentiEsercizi.get(s);

           if (valoreCorrente.equals("es1I")) {
               App.setRoot("trovaimport2"); // Se l'utente ha completato "es1I", apre "trovaimport2"
           } 
           if (valoreCorrente.equals("es2I")) {
               App.setRoot("trovaimport3"); // Se l'utente ha completato "es2I", apre "trovaimport3"
           }
           if (valoreCorrente.equals("es3I")) {
               App.setRoot("es2Superato"); // Se l'utente ha completato "es3I", apre "es2Superato"
           }
       } else { // Se l'utente non ha completato nessun esercizio, apre la pagina iniziale "trovaImportInit"
           App.setRoot("trovaImportInit");
       }
       scf1.close(); // Chiude lo scanner
   }

   // Metodo che inizializza la pagina, impostando i progressi delle barre di progresso
   public void initialize() throws Exception{
    scf1 = new Scanner (new File("Accesso.txt")); 
    String s = null ;

    while(scf1.hasNextLine())
         s = scf1.nextLine(); 

    // Aggiorna le barre di progresso in base ai progressi dell'utente
    Progresso.setProgress(App.getProgress(s));
    ProgressoI.setProgress(App.getProgressI(s));
    ProgressoII.setProgress(App.getProgressII(s));
}

   // Metodo che gestisce il passaggio alla pagina degli esercizi "Riordina Codice"
   public void switchToRiordinaCodice(ActionEvent e) throws IOException{
       scf1 = new Scanner (new File("Accesso.txt")); 
       scf2 = new Scanner(new File("utentiSalvataggiII.txt")); // Carica i salvataggi degli esercizi "Riordina Codice"
       
       HashMap<String,String> UtentiEsercizi = new HashMap<>();
       String s = null;

       while(scf1.hasNextLine())
           s = scf1.nextLine(); 

       // Riempie l'HashMap con i dati del file "utentiSalvataggiII.txt"
       while(scf2.hasNextLine()){
           String S = scf2.nextLine(); 
           String[]Sv = S.trim().split(" "); 
           if (Sv.length == 2) { 
               UtentiEsercizi.put(Sv[0], Sv[1]); 
           }
       }

       // Se l'utente ha completato degli esercizi, seleziona la pagina da aprire
       if (UtentiEsercizi.containsKey(s)) {
           String valoreCorrente = UtentiEsercizi.get(s);

           if (valoreCorrente.equals("es1II")) {
               App.setRoot("riordina_codice2"); // Se l'utente ha completato "es1II", apre "riordina_codice2"
           } 
           if (valoreCorrente.equals("es2II")) {
               App.setRoot("riordina_codice3"); // Se l'utente ha completato "es2II", apre "riordina_codice3"
           }
           if (valoreCorrente.equals("es3II")) {
               App.setRoot("es2Superato"); // Se l'utente ha completato "es3II", apre "es2Superato"
           }
       } else { // Se l'utente non ha completato nessun esercizio, apre la pagina iniziale "riordina_codiceInit"
           App.setRoot("riordina_codiceInit");
       }
   }

   // Metodo per passare alla pagina con informazioni aggiuntive
   public void switchToInfoAggiunte(ActionEvent e) throws IOException{
       App.setRoot("InfoAggiunte");
   }

   // Metodo per passare alla pagina di login
   public void switchToLogIn(ActionEvent e) throws IOException{
   
       App.setRoot("log_in");
   }
}
