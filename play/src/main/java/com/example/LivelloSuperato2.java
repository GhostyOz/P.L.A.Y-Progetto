package com.example;


import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javafx.scene.control.Button;

import java.io.*;

public class LivelloSuperato2 {
    @FXML
    private Button  backHome;
    @FXML
    private Button  HighLevelButton;
    @FXML
    private Label label;
    int contavalue = App.conta; 
    @FXML
    protected void SwitchToHome() throws IOException{
        App.setRoot("home");
        
    }
    
}
