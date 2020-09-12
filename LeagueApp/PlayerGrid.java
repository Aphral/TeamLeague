

package LeagueApp;

import java.util.List;

import LeagueApp.service.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/** 
 * PlayerGrid is a Grid used to do anything to do with Player 
 * @author aphralgriffin
 * 
 * */

public class PlayerGrid extends GridPane {

    public PlayerGrid(){
    	// Create Labels & Text Fields & Buttons
        Label fnameLabel = new Label("First Name: ");
        Label mnameLabel = new Label("Middle Name: ");
        Label lnameLabel = new Label("Last Name: ");
        Label phoneLabel = new Label("Phone: ");
        Label emailLabel = new Label("Email: ");
        Label numGoalsLabel = new Label("No. Goals: ");
        Label goalieLabel = new Label("Goalie: ");

        TextField fnameText = new TextField();
        TextField mnameText = new TextField();
        TextField lnameText = new TextField();
        TextField phoneText = new TextField();
        TextField emailText = new TextField();
        TextField numGoalsText = new TextField("0");
        TextField goalieText = new TextField("False");
        TextField searchText = new TextField();
        searchText.setPromptText("Enter Players First Name");

        Button addPlayerBtn = new Button("Add");
        Button removePlayerBtn = new Button("Remove");
        Button editPlayerBtn = new Button("Edit");
        Button listPlayerBtn = new Button("List Players");
        Button searchPlayerBtn = new Button("Search Player");
        
       TextField searchResultBox = new TextField();
       searchResultBox.setPrefHeight(50);
       searchResultBox.setPrefWidth(480);
        
    // Create List Views AntVBoxes & HBoxes 
        ListView<Player> displayPlayers = new ListView<Player>();
        displayPlayers.setStyle("-fx-border-color: SLATEGRAY; -fx-background-color: white;");
        displayPlayers.setPrefHeight(250);
        displayPlayers.setPrefWidth(480);

        VBox labelVBox = new VBox();
        labelVBox.getChildren().addAll(fnameLabel, mnameLabel, lnameLabel,phoneLabel, emailLabel, numGoalsLabel, goalieLabel);
        labelVBox.setSpacing(17);

        VBox textVBox = new VBox();
        textVBox.getChildren().addAll(fnameText, mnameText, lnameText, phoneText, emailText,  numGoalsText, goalieText);
        textVBox.setSpacing(5);

        HBox addHBox = new HBox(0);
        addHBox.getChildren().addAll(labelVBox, textVBox);

        HBox hBoxDisplayPlayers = new HBox(0);
        hBoxDisplayPlayers.getChildren().addAll(displayPlayers);

        HBox searchHBox = new HBox();
        searchHBox.getChildren().addAll(searchText, searchPlayerBtn);

        HBox addBtnHBox = new HBox();
        addBtnHBox.getChildren().addAll(addPlayerBtn, removePlayerBtn, editPlayerBtn);
        addBtnHBox.setSpacing(1);

        HBox btnHBox = new HBox();
        btnHBox.getChildren().addAll(addBtnHBox, searchHBox);
        btnHBox.setSpacing(50);

        HBox listPlayerHBox = new HBox();
        listPlayerHBox.getChildren().addAll(listPlayerBtn);
        listPlayerHBox.setSpacing(10);

        


        setPadding(new Insets(10));
        setHgap(5);
        setVgap(5);

        add(addHBox , 0, 0, 1, 1);
        add( btnHBox, 0, 1, 1, 1);
        add(searchResultBox, 0, 2, 1, 1);
        add( hBoxDisplayPlayers, 0, 3 , 1, 1);
        add( listPlayerHBox, 0, 4 , 1, 1);

        // Calls Edit player Pop Up
        editPlayerBtn.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
            	Player editPlayer = displayPlayers.getSelectionModel().getSelectedItem();
            	
            	EditPlayerGrid editPlayerGridPane = new EditPlayerGrid(editPlayer);


                Stage editPlayerStage = new Stage();

                Scene editPlayerScene = new Scene(editPlayerGridPane, 280, 300);

                editPlayerStage.setTitle("Edit Player");
                editPlayerStage.setScene(editPlayerScene);
                editPlayerStage.show();
                
                displayPlayers.getItems().clear();
            }
        });
        
        // Creates Player 
        addPlayerBtn.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                String fname = String.valueOf(fnameText.getText());
                String mname = String.valueOf(mnameText.getText());
                String lname = String.valueOf(lnameText.getText());
                
                Name name = new Name(fname, mname,lname);
                
                String phone = String.valueOf(phoneText.getText());
                String email = String.valueOf(emailText.getText());
                
                int goals = Integer.parseInt(numGoalsText.getText());
                Boolean goalie = Boolean.parseBoolean(goalieText.getText());
                
                Player player = new Player (name, phone, email, goals, goalie);
                
                CreatePlayer create = new CreatePlayer(player);
            }
        });
        // List Players
        listPlayerBtn.setOnAction(new EventHandler<ActionEvent>() {
        	public void handle(ActionEvent event) {
        		
        		FindPlayer findPlayer = new FindPlayer();
        		List<Player> playerList = findPlayer.findAllPlayers();
        		
        		
        		displayPlayers.getItems().clear();
				for (int i = 0; i < playerList.size(); i++) {
					displayPlayers.getItems().add(playerList.get(i));
				}
        	}
        });
        // Search For Player
        searchPlayerBtn.setOnAction(new EventHandler<ActionEvent>() {
        	public void handle(ActionEvent event) {
        		String name = String.valueOf(searchText.getText());
        		
        		FindPlayer findPlayer = new FindPlayer();
        		String player = findPlayer.findPlayerByName(name);
        		
        		searchResultBox.setText(player);
        		
        	}
        });
        
        removePlayerBtn.setOnAction(new EventHandler<ActionEvent>() {
        	public void handle(ActionEvent event) {
        		Player removePlayer = displayPlayers.getSelectionModel().getSelectedItem();
        		
        		DeletePlayer deletePlayer = new DeletePlayer();
        		deletePlayer.deletePlayer(removePlayer);
        		displayPlayers.getItems().clear();
        		
        		
        	}
        });
    }

}
