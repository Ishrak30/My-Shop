/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jnaina;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
/**
 * FXML Controller class
 *
 * @author Faiyaz
 */
public class CreateAccountController implements Initializable {
@FXML private TextField newuserid;
@FXML private TextField newpassword;

Accounthandling cahd = new Accounthandling();
        
        
    public void CreateAccountButton() throws Exception{
    String userid = newuserid.getText();
    String userpassword = newpassword.getText();
    
    cahd.createaccount(userid, userpassword);
     Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("AccountGUI.fxml"));
        
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
