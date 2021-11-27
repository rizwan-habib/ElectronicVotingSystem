package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class WinnerController {
	@FXML
    private GridPane grid;

    @FXML
    private Button back;

    @FXML
    void Back(ActionEvent event) {
    	try {
    		VBox root = (VBox)FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
			Scene scene = new Scene(root,290,150);
    		Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
    		primaryStage.setScene(scene);
    		primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    public void initialize() {

        VotingHandler v1=new VotingHandler();
        ArrayList<Candidate> cns=new ArrayList<Candidate>();
        cns=v1.getOrderedCandidates();
        int size = cns.size();
        //Node[] n = new Node[size];
        for (int i = 0; i < size; i++) {

            Text btn = new Text();
            btn.setText(cns.get(i).getName()+" ("+cns.get(i).getParty().getName()+") ("+String.valueOf(cns.get(i).getVotes())+")");
            grid.add(btn, 0, i); // Button is added to next row every time.
//            Text btn1 = new Text();
//            btn.setText(String.valueOf(cns.get(i).getVotes()));
//            grid.add(btn1, 1, i); // Button is added to next row every time.
        }

    }
}
