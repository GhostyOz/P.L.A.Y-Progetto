
package com.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.io.PrintWriter;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.function.UnaryOperator;


public class log_inController{
    @FXML
    private Button BottoneIndietro;
    @FXML
    private  Button BottoneAccesso;
    @FXML
   private  TextField nomeTesto;
    @FXML
    private TextField passwordTesto;
   
    public static String u;
    public static String s = null;
    @FXML
    //metodo per caricare la pagina sign_up in caso non si sia creato l'utente
    protected void switchToSignUp(ActionEvent e) throws IOException{
        App.setRoot("sign_up");
    }

      private StringBuilder passwordBuffer = new StringBuilder(); // Stores the actual password
    @FXML
    public void initialize() {
        // Create a TextFormatter to mask the password field
        UnaryOperator<TextFormatter.Change> filter = change -> {
            if (change.isAdded()) {
                String addedText = change.getText();
                passwordBuffer.append(addedText); // Add to the real password
                change.setText("*".repeat(addedText.length())); // Mask the added text
            } else if (change.isDeleted()) {
                int length = passwordBuffer.length();
                if (length > 0) {
                    passwordBuffer.delete(length - 1, length); // Remove the last character
                }
            }
            return change; // Apply the modified change
          };
          TextFormatter<String> formatter = new TextFormatter<>(filter);
        passwordTesto.setTextFormatter(formatter);
        }
        //String password1 = passwordBuffer.toString();
    
    @FXML
    //metodo per carciare la schermata home 
    protected void switchToHome(ActionEvent e) throws Exception{
        s = nomeTesto.getText()+" "+passwordBuffer.toString();
        PrintWriter pw = new PrintWriter("Accesso.txt");
        ArrayList<String>S = new ArrayList<>();
        Scanner scf = new Scanner(new File("utenti.txt"));
        //verifico che l'utente sia stato effettivamente creato, altrimenti non apre la pagina home 
        while (scf.hasNextLine()) {
            String riga = scf.nextLine(); // leggo la riga 
            S.add(riga); 
        }
        for (String r : S) {
            if(r.equals(s)){
              String R[]=  r.split(" ");
              pw.println(R[0]); // scrivo la riga sul file Accesso
              pw.close();
                App.setRoot("home");//carico la schermata di home
                

            }else{
                
            }
                 
        }
    
        scf.close();
    }
    
       
    
   
}