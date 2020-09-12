

package LeagueApp;

import LeagueApp.service.DeletePlayer;
import LeagueApp.service.UpdatePlayer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * EditPlayerGrid is a grid which Allows a user ot edit a player It is called in the playerGrid,
 * Edit players and Managers and list Teams
 * 
 * @author aphralgriffin
 * 
 */

public class EditPlayerGrid extends GridPane {

    public EditPlayerGrid(Player oldPlayer){
    	// Create Labels & Text Fields & HBoxes
        Label fnameLabel = new Label("First Name: ");
        Label mnameLabel = new Label("Middle Name: ");
        Label lnameLabel = new Label("Last Name: ");
        Label phoneLabel = new Label("Phone: ");
        Label emailLabel = new Label("Email: ");
        Label numGoalsLabel = new Label("No. Goals: ");
        Label goalieLabel = new Label("Goalie: ");

        TextField fnameText = new TextField();
        fnameText.setText(oldPlayer.getName().getFirstname());
        TextField mnameText = new TextField();
        mnameText.setText(oldPlayer.getName().getMiddlename());
        TextField lnameText = new TextField();
        lnameText.setText(oldPlayer.getName().getLastname());
        TextField phoneText = new TextField();
        phoneText.setText(oldPlayer.getPhone());
        TextField emailText = new TextField();
        emailText.setText(oldPlayer.getEmail());
        TextField numGoalsText = new TextField("0");
        numGoalsText.setText(Integer.toString(oldPlayer.getGoals()));
        TextField goalieText = new TextField("False");
        goalieText.setText(Boolean.toString(oldPlayer.getGoalie()));
        
        Button confirmPlayerBtn = new Button("Confirm");

        VBox labelVBox = new VBox();
        labelVBox.getChildren().addAll(fnameLabel, mnameLabel, lnameLabel, phoneLabel, emailLabel, numGoalsLabel, goalieLabel);
        labelVBox.setSpacing(17);

        VBox textVBox = new VBox();
        textVBox.getChildren().addAll(fnameText, mnameText, lnameText, phoneText, emailText, numGoalsText, goalieText);
        textVBox.setSpacing(5);

        HBox addHBox = new HBox(0);
        addHBox.getChildren().addAll(labelVBox, textVBox);



        setPadding(new Insets(10));
        setHgap(5);
        setVgap(10);

        add(addHBox , 0, 0, 1, 1);
        add(confirmPlayerBtn, 0, 1, 1, 1);

        GridPane.setHalignment(addHBox, HPos.CENTER);
        GridPane.setHalignment(confirmPlayerBtn, HPos.CENTER);

        // Confirm Player Button Clicked
        confirmPlayerBtn.setOnAction(new EventHandler<ActionEvent>() {
        	public void handle(ActionEvent event) {
        		
        		 // Update Player is called and player is updated 
        		String fname = String.valueOf(fnameText.getText());
                String mname = String.valueOf(mnameText.getText());
                String lname = String.valueOf(lnameText.getText());
                
                Name name = new Name(fname, mname,lname);
                
                String phone = String.valueOf(phoneText.getText());
                String email = String.valueOf(emailText.getText());
                
                int goals = Integer.parseInt(numGoalsText.getText());
                Boolean goalie = Boolean.parseBoolean(goalieText.getText());
                
                Player newPlayer = new Player (name, phone, email, goals, goalie);
        		
                UpdatePlayer updatePlayer = new UpdatePlayer();
                updatePlayer.updatePlayer(newPlayer, oldPlayer);
        		
        	}
        });
    }
}