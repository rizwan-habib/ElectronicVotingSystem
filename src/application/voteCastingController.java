package application;

import java.io.IOException;
import java.util.ArrayList;

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
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class voteCastingController {
	@FXML
    private TextField candidatename;

    @FXML
    private Button back;

    @FXML
    private Button voted;

    @FXML
    private TextField cnic;
    
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
    	String p=candidatename.getText();
    	if(p.isEmpty()) {
    		return;
    	}
    	try {
            int d = Integer.parseInt(c);
        } catch (NumberFormatException nfe) {
            return;
        }
    	VotingHandler v=new VotingHandler();
    	boolean flag=v.verifyVoter(Integer.parseInt(c))&&v.verifyCandidate(p);
    	if (flag) {

    		
//    		System.exit(0);
    		//vote casting 
    		try {
    			v.voteCast(c,p);
			} catch (Exception e) {
				// TODO: handle exception
				return;
			}
    		VBox root;
			try {
				root = (VBox)FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
				Scene scene = new Scene(root,290,150);
	    		Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
	    		primaryStage.setScene(scene);
	    		primaryStage.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
    		
    		
		}
    }

    
//    public void initialize() {
//    	menu1.setText("PMLN");
//    	menu2.setText("PTI");
//    }
    public void initialize() {

        VotingHandler v1=new VotingHandler();
        ArrayList<Candidate> cns=new ArrayList<Candidate>();
        cns=v1.getCandidates();
        int size = cns.size();
        //Node[] n = new Node[size];
        for (int i = 0; i < size; i++) {
            //FXMLLoader loader = new FXMLLoader(getClass().getResource("Bloc.fxml"));
            //ControllerItem controller = new ControllerItem();
            //loader.setController(controller);
            //n[i] = loader.load();
            //controller.setButtonInst(ecoles.get(i));
            //Box.getChildren().add(n[i]);

            Text btn = new Text();
            btn.setText(cns.get(i).getName()+" ("+cns.get(i).getParty().getName()+")");
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
