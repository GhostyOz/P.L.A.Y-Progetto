package com.example;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class RegolamentoEs3  {
    @FXML
    private Button prosegui;
    @FXML
    private Button  goHome;
  
    @FXML
    protected void prosegui() throws IOException{
        App.setRoot("riordina_codice1");
    }
    @FXML
    protected void SwitchToHome() throws IOException{
        App.setRoot("home");
    }
}