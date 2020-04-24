/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jnaina;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author Faiyaz
 */
public class AccountGUIController implements Initializable {
@FXML private TextField USERID;
@FXML private TextField PASSWORD;
@FXML private Label lbl;

Accounthandling ahd = new Accounthandling();


    
public void loginbuttonpushed() throws Exception{   
    String name = USERID.getText();
    String password = PASSWORD.getText();
   
    
    
    if(ahd.accountlogin(name, password)==true){ 
       Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        
        Scene scene = new Scene(root);
        stage.setTitle("NSUER's Merchandise");
        stage.setScene(scene);
        stage.show();
        
        
        
    }
    else
        lbl.setText("INCORRECT USERNAME OR PASSWORD");
        
}


public void createaccount() throws Exception{
    Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("CreateAccount.fxml"));
        
        Scene scene = new Scene(root);
        stage.setTitle("NSUER's Merchandise");
        stage.setScene(scene);
        stage.show();
        
}

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
