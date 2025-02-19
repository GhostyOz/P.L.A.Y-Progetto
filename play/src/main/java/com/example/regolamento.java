package com.example;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class regolamento  {
    @FXML
    private Button prosegui;
    @FXML
    private Button goHome;
    @FXML
    protected void prosegui() throws IOException{
        App.setRoot("trova_errore1");
    }
    @FXML
    protected void switchToHome() throws IOException{
        App.setRoot("home");
    }
   
}
