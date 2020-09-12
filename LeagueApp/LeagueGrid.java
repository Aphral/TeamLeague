

package LeagueApp;

import java.util.ArrayList;
import java.util.List;

import LeagueApp.service.FindPlayer;
import LeagueApp.service.FindTeam;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.*;

/**
 * LeagueGrid is a grid which lists the players on a grid
 * 
 * @author aphralgriffin
 * 
 */
public class LeagueGrid extends GridPane {

	public LeagueGrid() {

		Label leagueListLabel = new Label("List Of Teams In League");
		leagueListLabel.setStyle("-fx-font: 24 arial");

		Button listTeamBtn = new Button("List Teams");
		
		Button memoryBtn = new Button("Memory Demo");

		ListView<Team> displayTeams = new ListView<Team>();
		displayTeams.setStyle("-fx-border-color: SLATEGRAY; -fx-background-color: white;");
		displayTeams.setPrefHeight(480);
		displayTeams.setPrefWidth(480);

		HBox hBoxDisplayTeams = new HBox(0);
		hBoxDisplayTeams.getChildren().addAll(displayTeams);
		

		setPadding(new Insets(10));
		setHgap(5);
		setVgap(5);

		add(leagueListLabel, 0, 0, 1, 1);
		add(hBoxDisplayTeams, 0, 1, 1, 1);
		add(listTeamBtn, 0, 4, 1, 1);
		add(memoryBtn, 0, 5, 1, 1);

		GridPane.setHalignment(leagueListLabel, HPos.CENTER);

		// List teams in league
		listTeamBtn.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				FindTeam findTeam = new FindTeam();
				List<Team> teamList = findTeam.findAllTeams();

				displayTeams.getItems().clear();
				for (int i = 0; i < teamList.size(); i++) {
					displayTeams.getItems().add(teamList.get(i));
				}

			}
		});
		
		// Creates A Space Error 
		memoryBtn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				Boolean broken = false;

				Name name = new Name("This", "Will", "Break");
				Player player = new Player(name, "123345", "Longestemailintheworlds252716@gmail", 250, true);
				
				List<Player> list = new ArrayList<Player>();
				
				while(broken == false) {
					list.add(player);
				}
			}
		});
	}

}