package com.example;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class RegolamentoEs2  {
    @FXML
    private Button prosegui;
    @FXML
    private Button  goHome;
  
    @FXML
    protected void prosegui() throws IOException{
        App.setRoot("trovaImport1");
    }
    @FXML
    protected void SwitchToHome() throws IOException{
        App.setRoot("home");
    }
}