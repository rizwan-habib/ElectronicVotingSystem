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

public class AddCandidateController {
	@FXML
    private TextField address;

    @FXML
    private Button submit;

    @FXML
    private TextField name;

    @FXML
    private Button back;

    @FXML
    private TextField cnic;

    @FXML
    private TextField age;
    @FXML
    private TextField party;

    @FXML
    void addCandidate(ActionEvent event) {
    	String na=name.getText();
    	int ag=Integer.parseInt(age.getText());
    	String addres=address.getText();
    	String cn=cnic.getText();
    	String pr=party.getText();
    	try {
			VotingHandler v1=new VotingHandler();
			v1.registerCandidate(na,ag,addres,cn,pr);
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
