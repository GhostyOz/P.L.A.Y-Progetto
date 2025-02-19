package com.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button; 
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.Label;
import java.util.*;
import java.util.function.UnaryOperator;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
public class sign_upController {

    @FXML
    private TextField nomeTesto;
    @FXML
    private TextField passwordTesto; 
    @FXML
    private TextField passwordTesto2; 
    
    @FXML
    private Label label;

    @FXML
    private Button BottoneInvio;
    @FXML
    private Button BottoneLogIn;

private StringBuilder passwordBuffer1 = new StringBuilder(); // Stores the actual password
private StringBuilder passwordBuffer2 = new StringBuilder();
    @FXML
    public void initialize() {
        // Create a TextFormatter to mask text
        UnaryOperator<TextFormatter.Change> filter = change -> {
            if (change.isAdded()) {
                String addedText = change.getText();
                passwordBuffer1.append(addedText); // Add actual input to the buffer
                change.setText("*".repeat(addedText.length())); // Mask the added text
            } else if (change.isDeleted()) {
                int length = passwordBuffer1.length();
                if (length > 0) {
                    passwordBuffer1.delete(length - 1, length); // Remove the last character from the buffer
                }
            }
            return change; // Return the modified change
        };

        TextFormatter<String> formatter = new TextFormatter<>(filter);
        passwordTesto.setTextFormatter(formatter);


    UnaryOperator<TextFormatter.Change> filter2 = change -> {
        if (change.isAdded()) {
            String addedText = change.getText();
            passwordBuffer2.append(addedText); // Add to the real password
            change.setText("*".repeat(addedText.length())); // Mask the added text
        } else if (change.isDeleted()) {
            int length = passwordBuffer2.length();
            if (length > 0) {
                passwordBuffer2.delete(length - 1, length); // Remove the last character
            }
        }
        return change; // Apply the modified change
    };
    TextFormatter<String> formatter2 = new TextFormatter<>(filter2);
    passwordTesto2.setTextFormatter(formatter2);
}
//String password1 = passwordBuffer1.toString();
//String password2 = passwordBuffer2.toString();


    @FXML
    //creo un utente utilizzando l'oggttto utente di App verificando che non ne esista uno con un nome uguale 
    protected void creaAccount(ActionEvent e)throws Exception {
        Scanner scf= new Scanner(new File("utenti.txt"));
        PrintWriter pw = new PrintWriter(new FileWriter("utenti.txt",true));
        ArrayList<String>nomi= new ArrayList<>();
        App.u= new Utente();
        while(scf.hasNextLine()){
            String s = scf.nextLine(); 
            String S[]=s.split(" ");

            nomi.add(S[0]); 
        }
        if(passwordBuffer1.toString().equals(passwordBuffer2.toString())){
            System.out.println("Password1 = " + passwordBuffer1.toString());
            System.out.println("Password2 = " + passwordBuffer2.toString());
            App.u.setPassword(passwordBuffer1.toString());
            if(!nomi.contains(nomeTesto.getText())){
                App.u.setNome(nomeTesto.getText());
                label.setText("Account creato");
                pw.println(App.u.getNome()+" "+App.u.getPassword());
                pw.close();
        }else{
            label.setText("Account già esistente");
        }
    }else{
            label.setText("Password non corrispondenti");
    }
        
       
    scf.close();
    }
        
        

     
 

     @FXML // carico la schermata di log in 
     private void switchToLogIn(ActionEvent e ) throws IOException {
         App.setRoot("log_in");
     }
}