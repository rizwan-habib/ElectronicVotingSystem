package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AddPartyController {
	 @FXML
    private Button submit;

    @FXML
    private TextField name;

    @FXML
    private Button back;

    @FXML
    void registerParty(ActionEvent event) {
    	String na=name.getText();
    	try {
			VotingHandler v1=new VotingHandler();
			v1.registerParty(na);
			VBox root = (VBox)FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
	    	Scene scene = new Scene(root,290,150);
			Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			// TODO: handle exception
			return;
		}
    }

    @FXML
    void back(ActionEvent event) throws IOException {
    	VBox root = (VBox)FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
    	Scene scene = new Scene(root,290,150);
		Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
    }
}
