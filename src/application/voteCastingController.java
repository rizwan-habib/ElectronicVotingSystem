package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import javafx.stage.Stage;

public class voteCastingController {
	@FXML
    private MenuButton candidates;
    @FXML
    private Button back;
    @FXML
    private TextField cnic;
    @FXML
    private MenuItem menu2;
    @FXML
    private MenuItem menu1;
    @FXML
    private Button voteCasted;
    @FXML
    private GridPane Box;
    @FXML
    void voteCasted(ActionEvent event) {
    	String c=cnic.getText();
    	if(c.isEmpty()) {
    		return;
    	}
    	try {
            int d = Integer.parseInt(c);
        } catch (NumberFormatException nfe) {
            return;
        }
    	VotingHandler v=new VotingHandler();
    	boolean flag=v.verifyVoter(Integer.parseInt(c));
    	if (flag) {
//    		System.exit(0);
    		//vote casting
    		v.voteCast(c);
		}
    }

    
//    public void initialize() {
//    	menu1.setText("PMLN");
//    	menu2.setText("PTI");
//    }
    public void initialize() {

        
        int size = 5;
        //Node[] n = new Node[size];
        for (int i = 0; i < size; i++) {
            //FXMLLoader loader = new FXMLLoader(getClass().getResource("Bloc.fxml"));
            //ControllerItem controller = new ControllerItem();
            //loader.setController(controller);
            //n[i] = loader.load();
            //controller.setButtonInst(ecoles.get(i));
            //Box.getChildren().add(n[i]);

            Button btn = new Button("button");
            Box.add(btn, 0, i); // Button is added to next row every time.
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
