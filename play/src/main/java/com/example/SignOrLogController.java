package com.example;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;
public class SignOrLogController {
    @FXML
     private Button LoginButton;
     @FXML
     private Button SignupButton;

    @FXML
    private  void SwitchtoLogIn(ActionEvent e )throws IOException{
        App.setRoot("log_in");
    }
    @FXML
    private  void SwitchtoSignUp(ActionEvent e )throws IOException{
        App.setRoot("sign_up");
    }

}
