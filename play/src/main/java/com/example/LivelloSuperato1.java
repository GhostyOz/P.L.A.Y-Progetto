package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import java.io.*;

public class LivelloSuperato1 {
    @FXML
    private Button  backHome;
    @FXML
    private Button  HighLevelButton;
    @FXML
    private Label label;
    @FXML
    protected void SwitchToHome() throws IOException{
        App.setRoot("home");
    }
    
}
