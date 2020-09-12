

package LeagueApp;

import java.util.ArrayList;
import java.util.List;

import LeagueApp.service.CreateTeam;
import LeagueApp.service.FindManager;
import LeagueApp.service.FindTeam;
import LeagueApp.service.UpdateTeam;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * TeamGrid is a grid which contains everything needed to do with a team Create,
 * Edit players and Managers and list Teams
 * 
 * @author aphralgriffin
 * 
 */

public class TeamGrid extends GridPane {

	public TeamGrid() {
		// Create Labels & Text Fields
		Label jerseyColourLabel = new Label("Jersey Colour: ");
		Label managerLabel = new Label("Manager: ");
		Label teamPlayerLabel = new Label("Choose Team: ");
		Label teamBoxLabel = new Label("Teams: ");

		TextField jerseyColourText = new TextField();

		// Call findNullManagers from FindManager to get a list of all the managers not
		// on a team
		FindManager findManager = new FindManager();
		List<Manager> managerList = findManager.findNullManagers();

		// Populate combo box with list (cast list to observable list)
		ComboBox<Manager> managerDropDown = new ComboBox<Manager>(FXCollections.observableList(managerList));
		managerDropDown.setPrefWidth(200);

		// Call findAllTeams from FindTeam to get a list of all the teams 
		FindTeam findTeam = new FindTeam();
		List<Team> listTeam = findTeam.findAllTeams();
		  
		// Populate combo box with list (cast list to observable list)
		ComboBox<Team> teamDropDown = new ComboBox<Team>(FXCollections.observableList(listTeam));
		teamDropDown.setPrefWidth(150);

		//Create Buttons
		Button addTeamBtn = new Button("Add ");
		Button listTeamPlayersBtn = new Button("List Players");
		Button listTeamsBtn = new Button("List Teams");
		Button addManagerBtn = new Button("Add Manager");
		Button addPlayerBtn = new Button("Add Player");
		Button removeManagerBtn = new Button("Remove Manager");
		Button removePlayerBtn = new Button("Remove Player");

		// Made separator 
		Separator separatorLine = new Separator();

		// Create List Views For Players And Teams
		ListView<Player> displayPlayers = new ListView<Player>();
		displayPlayers.setStyle("-fx-border-color: SLATEGRAY; -fx-background-color: white;");
		displayPlayers.setPrefHeight(200);
		displayPlayers.setPrefWidth(480);

		ListView<Team> displayTeams = new ListView<Team>();
		displayPlayers.setStyle("-fx-border-color: SLATEGRAY; -fx-background-color: white;");
		displayTeams.setPrefHeight(200);
		displayTeams.setPrefWidth(480);

		// Create HBoxes And VBoxes
		HBox hBoxAddTeamBtn = new HBox(0);
		hBoxAddTeamBtn.getChildren().addAll(addTeamBtn);
		hBoxAddTeamBtn.setSpacing(5);
		hBoxAddTeamBtn.setMinWidth(200);

		VBox labelVBox = new VBox();
		labelVBox.getChildren().addAll(jerseyColourLabel, managerLabel);
		labelVBox.setSpacing(17);

		VBox textVBox = new VBox();
		textVBox.getChildren().addAll(jerseyColourText, managerDropDown, hBoxAddTeamBtn);
		textVBox.setSpacing(5);

		HBox addHBox = new HBox(0);
		addHBox.getChildren().addAll(labelVBox, textVBox);

		HBox hBoxDisplayPlayers = new HBox(0);
		hBoxDisplayPlayers.getChildren().addAll(displayPlayers);

		HBox hBoxSearchTeamPlayers = new HBox(0);
		hBoxSearchTeamPlayers.getChildren().addAll(teamPlayerLabel, teamDropDown, listTeamPlayersBtn, removePlayerBtn);
		hBoxSearchTeamPlayers.setSpacing(5);

		HBox hBoxAddBtn = new HBox(0);
		hBoxAddBtn.getChildren().addAll(addManagerBtn, addPlayerBtn, removeManagerBtn);
		hBoxAddBtn.setSpacing(5);

		// Add All To Grid And Set Height etc 
		setPadding(new Insets(10));
		setHgap(5);
		setVgap(5);

		add(addHBox, 0, 0, 1, 1);
		add(separatorLine, 0, 1, 1, 1);
		add(hBoxSearchTeamPlayers, 0, 2, 1, 1);
		add(hBoxDisplayPlayers, 0, 3, 1, 1);
		add(listTeamsBtn, 0, 4, 1, 1);
		add(displayTeams, 0, 5, 1, 1);
		add(hBoxAddBtn, 0, 6, 1, 1);

		// When addManager Clicked
		addManagerBtn.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				// get selected team from view
				Team team = displayTeams.getSelectionModel().getSelectedItem();
				// Add Manager Pop up and seleected team. 
				AddManagerGrid addManagerGridPane = new AddManagerGrid(team);

				Stage addManagerStage = new Stage();

				Scene addManagerScene = new Scene(addManagerGridPane, 340, 140);

				addManagerStage.setTitle("Add Manager");
				addManagerStage.setScene(addManagerScene);

				addManagerStage.show();
			}
		});

		// When addPlayer Clicked
		addPlayerBtn.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				// get selected team from view
				Team team = displayTeams.getSelectionModel().getSelectedItem();
				
				// Add Player Pop up and selected team. 
				AddPlayerGrid addPlayerGridPane = new AddPlayerGrid(team);

				Stage addPlayerStage = new Stage();

				Scene addPlayerScene = new Scene(addPlayerGridPane, 340, 140);

				addPlayerStage.setTitle("Add Player");
				addPlayerStage.setScene(addPlayerScene);
				addPlayerStage.show();
			}
		});

		// When addTeam Clciked
		addTeamBtn.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				// get manager value from drop down
				Manager manager = managerDropDown.getValue();
				
				// get value of jersey 
				String jersey = String.valueOf(jerseyColourText.getText());

				// Create new team 
				Team team = new Team(jersey, manager, null);

				CreateTeam createTeam = new CreateTeam(team);

			}
		});

		// When listTeamPlayers Clciked
		listTeamPlayersBtn.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				//Get List of Players and display them 
				Team team = teamDropDown.getValue();
				String colour = team.getJersey();

				FindTeam findTeam = new FindTeam();
				List<Player> playerList = findTeam.findAllPlayersInTeam(colour);

				displayPlayers.getItems().clear();
				for (int i = 0; i < playerList.size(); i++) {
					displayPlayers.getItems().add(playerList.get(i));
				}

			}
		});

		// When listTeams Clciked
		listTeamsBtn.setOnAction(new EventHandler<ActionEvent>() {

			// Get List of teams and displays 
			public void handle(ActionEvent event) {
				FindTeam findTeam = new FindTeam();
				List<Team> teamList = findTeam.findAllTeams();

				displayTeams.getItems().clear();
				for (int i = 0; i < teamList.size(); i++) {
					displayTeams.getItems().add(teamList.get(i));
				}

			}
		});

		// When removePlayer Clicked
		removePlayerBtn.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				// Get value of team and value of player and deleted player
				Team team = teamDropDown.getValue();
				String colour = team.getJersey();

				displayTeams.getItems().clear();
				UpdateTeam updateTeam = new UpdateTeam();
				Player removePlayer = displayPlayers.getSelectionModel().getSelectedItem();
				updateTeam.removePlayerFromTeam(removePlayer, colour);

			}
		});
		
		// When removeManager Clicked
		removeManagerBtn.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				// Get value of team and remove manager
				Team removeManager = displayTeams.getSelectionModel().getSelectedItem();
				String colour = removeManager.getJersey();
				UpdateTeam updateTeam = new UpdateTeam();

				updateTeam.removeManagerFromTeam(colour);

			}
		});

	}

}
