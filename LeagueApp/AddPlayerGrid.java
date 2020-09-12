
package LeagueApp;

import java.util.List;

import LeagueApp.service.FindPlayer;
import LeagueApp.service.FindTeam;
import LeagueApp.service.UpdateTeam;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

/**
 * AddPlayerGrid is a pop up used to add a player to a team. It is called from
 * the TeamGrid
 * 
 * @author aphralgriffin
 * 
 */

public class AddPlayerGrid extends GridPane {

	public AddPlayerGrid(Team team) {
		// Create Labels And Buttons
		Label playerLabel = new Label("Select Player: ");

		Button addPlayerBtn = new Button("Add Player");

		// Call findPlayersNotOnTeam from FindPlayer to get a list of all the players
		// not on a team
		FindPlayer findPlayer = new FindPlayer();
		List<Player> listPlayer = findPlayer.findPlayersNotOnTeam();

		// Populate combo box with list (cast list to observable list)
		ComboBox<Player> playerDropDown = new ComboBox<Player>(FXCollections.observableList(listPlayer));

		playerDropDown.setPrefWidth(200);

		// Add To Hbox
		HBox hBoxAddPlayer = new HBox(0);
		hBoxAddPlayer.getChildren().addAll(playerLabel, playerDropDown);

		// Add Items to GrifPane and set height etc
		setPadding(new Insets(10));
		setHgap(5);
		setVgap(5);

		add(hBoxAddPlayer, 0, 0, 1, 1);
		add(addPlayerBtn, 0, 1, 1, 1);

		GridPane.setHalignment(addPlayerBtn, HPos.CENTER);

		// When add player is clicked
		addPlayerBtn.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				// Call addPlayerToTeam from UpdateTeam Class to add player to team
				UpdateTeam updateTeam = new UpdateTeam();

				// Get player value from drop down
				Player player = playerDropDown.getValue();

				updateTeam.addPlayerToTeam(player, team.getJersey());
			}
		});

	}

}