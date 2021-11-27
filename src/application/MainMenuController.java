package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Node;
public class MainMenuController {

    @FXML
    private Button castVote;
    @FXML
    private Button addParty;

    @FXML
    private Button showRes;
    @FXML
    private Button Percentage;
    @FXML
    void CastAVote(ActionEvent event) throws Exception {
    	
    	AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("voteCasting.fxml"));
		Scene scene = new Scene(root,290,250);
		Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
		
//    	PersistenceHandler db=new MySQLDBHandler();
//    	db.save();
//    	System.out.print("Hello2");
    }
    @FXML
    void AddCandidate(ActionEvent event) throws Exception {
    	
    	AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("AddCandidate.fxml"));
		Scene scene = new Scene(root,320,275);
		Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
		
//    	PersistenceHandler db=new MySQLDBHandler();
//    	db.save();
//    	System.out.print("Hello2");
    }
    @FXML
    void HowToVote(ActionEvent event) throws Exception {
    	
    	AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("HowToVote.fxml"));
		Scene scene = new Scene(root,320,275);
		Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
		
//    	PersistenceHandler db=new MySQLDBHandler();
//    	db.save();
//    	System.out.print("Hello2");
    }

    @FXML
    void percentage(ActionEvent event) throws IOException {
    	AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("percentage.fxml"));
		Scene scene = new Scene(root,320,275);
		Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
    }
    @FXML
    void showResults(ActionEvent event) throws IOException {
    	AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("winner.fxml"));
		Scene scene = new Scene(root,320,275);
		Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
    }
    @FXML
    public void addParty(ActionEvent event) throws IOException {
    	AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("AddParty.fxml"));
		Scene scene = new Scene(root,290,230);
		Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
    }

}