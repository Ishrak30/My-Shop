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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Faiyaz
 */



public class FXMLDocumentController extends AccountGUIController implements Initializable{
   
  @FXML private TextField ID;
  @FXML private ComboBox Depart;
  @FXML private ComboBox Size;
  @FXML private ComboBox Quantity;
  @FXML private TextField Name;   
  @FXML private Label llb;
    Accessexcelfile aef = new Accessexcelfile();
    
    
    
    
    
    
    public void Savebuttonpushed() throws Exception{
        
        
        String department = Depart.getValue().toString();
        String q = Quantity.getValue().toString();
        double quantity = Double.parseDouble(q);
        String size = Size.getValue().toString();
        
       String NSUID = ID.getText();
       double id = Double.parseDouble(NSUID);
       
       String name = Name.getText();
       aef.addrecord(name, department, size, quantity, id);

    }
    
    public void Donebuttonpushed() throws Exception{
      String department = Depart.getValue().toString();
        String q = Quantity.getValue().toString();
        double quantity = Double.parseDouble(q);
        String size = Size.getValue().toString();
        
       aef.removefromstock(department, size, quantity); 
       llb.setText("Your purchase has been confirmed.\n Payable amount "+(450*quantity));
 
    }
    
    public void logoutbuttonpushed() throws Exception{
     Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("AccountGUI.fxml"));
        
        Scene scene = new Scene(root);
        stage.setTitle("NSUER's Merchandise");
        stage.setScene(scene);
        stage.show();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            this.Depart.getItems().addAll("ECE","BBA","GENERAL");
            this.Quantity.getItems().addAll("1","2","3","4","5");
            this.Size.getItems().addAll("M","L","XL","XXL");
    }  
    
    
    
}
