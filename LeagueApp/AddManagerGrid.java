
package LeagueApp;

import java.util.List;

import LeagueApp.service.FindManager;
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
 * AddManagerGrid is a pop up used to add a manager to a team. It is called from the TeamGrid
 * @author aphralgriffin
 * 
 * */

public class AddManagerGrid extends GridPane {
	public AddManagerGrid(Team team) {

		// Create Labels And Buttons
		Label managerLabel = new Label("Select Manager: ");

		Button addManagerBtn = new Button("Add Manager");

		// Call findNullManagers from FindManager to get a list of all the managers not
		// on a team
		FindManager findManager = new FindManager();
		List<Manager> managerList = findManager.findNullManagers();

		// Populate combo box with list (cast list to observable list)
		ComboBox<Manager> managerDropDown = new ComboBox<Manager>(FXCollections.observableList(managerList));

		managerDropDown.setPrefWidth(200);

		// Add To Hbox
		HBox hBoxAddManager = new HBox(0);
		hBoxAddManager.getChildren().addAll(managerLabel, managerDropDown);

		// Add Items to GrifPane and set height etc
		setPadding(new Insets(10));
		setHgap(5);
		setVgap(5);

		add(hBoxAddManager, 0, 0, 1, 1);
		add(addManagerBtn, 0, 1, 1, 1);

		GridPane.setHalignment(addManagerBtn, HPos.CENTER);

		// When add manager is clicked
		addManagerBtn.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				// Call addManagerToTeam from UpdateTeam Class to add manager to team
				UpdateTeam updateTeam = new UpdateTeam();

				// Get manager value from drop down
				Manager manager = managerDropDown.getValue();

				updateTeam.addManagerToTeam(manager, team.getJersey());
			}
		});
	}

}
