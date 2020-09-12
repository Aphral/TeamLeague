

package LeagueApp;

import java.util.Comparator;
import java.util.List;

import LeagueApp.service.CreateManager;
import LeagueApp.service.CreatePlayer;
import LeagueApp.service.FindManager;
import LeagueApp.service.FindPlayer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/** 
 * ManagerGrid is a Grid used to do anything to do with Manager 
 * @author aphralgriffin
 * 
 * */

public class ManagerGrid extends GridPane {

    public ManagerGrid(){
    	// Create Labels & Text Fields & Buttons
        Label fnameLabel = new Label("First Name: ");
        Label mnameLabel = new Label("Middle Name: ");
        Label lnameLabel = new Label("Last Name: ");
        Label phoneLabel = new Label("Phone: ");
        Label emailLabel = new Label("Email: ");
        Label dobLabel = new Label("Date Of Birth: ");
        Label starLabel = new Label("Star Rating: ");

        TextField fnameText = new TextField();
        TextField mnameText = new TextField();
        TextField lnameText = new TextField();
        TextField phoneText = new TextField();
        TextField emailText = new TextField();
        TextField dobText = new TextField();
        TextField starText = new TextField("0");

        Button addManagerBtn = new Button("Add Manager");
        Button listByStarBtn = new Button("List By Star Rating");
        Button listAlphaBtn = new Button("List Alphabetically");

        // Create List Views AntVBoxes & HBoxes 
        ListView<Manager> displayManagers = new ListView<Manager>();
        displayManagers.setStyle("-fx-border-color: SLATEGRAY; -fx-background-color: white;");
        displayManagers.setPrefHeight(300);
        displayManagers.setPrefWidth(480);

        VBox labelVBox = new VBox();
        labelVBox.getChildren().addAll(fnameLabel, mnameLabel, lnameLabel, phoneLabel, emailLabel,dobLabel, starLabel);
        labelVBox.setSpacing(17);

        VBox textVBox = new VBox();
        textVBox.getChildren().addAll(fnameText, mnameText, lnameText,phoneText, emailText, dobText, starText);
        textVBox.setSpacing(5);

        HBox addHBox = new HBox(0);
        addHBox.getChildren().addAll(labelVBox, textVBox);

        HBox addBtnHBox = new HBox();
        addBtnHBox.getChildren().addAll(addManagerBtn);

        HBox listBtnHBox = new HBox(0);
        listBtnHBox.getChildren().addAll(listByStarBtn, listAlphaBtn);

        HBox hBoxDisplayManagers = new HBox(0);
        hBoxDisplayManagers.getChildren().addAll(displayManagers);

        setPadding(new Insets(10));
        setHgap(5);
        setVgap(5);

        add(addHBox , 0, 0, 1, 1);
        add(addBtnHBox, 0, 1, 1,1);
        add(hBoxDisplayManagers , 0, 2, 1, 1);
        add( listBtnHBox, 0, 3 , 1, 1);
        
        // List Managers by rating 
        listByStarBtn.setOnAction(new EventHandler<ActionEvent>() {
        	public void handle(ActionEvent event) {
        		
        		FindManager findManager = new FindManager();
        		List<Manager> managerList = findManager.findAllManagers();
        		
        		managerList.sort(Comparator.comparing(Manager::getStarRate));
        		
        		displayManagers.getItems().clear();
				for (int i = 0; i < managerList.size(); i++) {
					displayManagers.getItems().add(managerList.get(i));
				}
        	}
        });
        
        // List managers by alphabetically
        listAlphaBtn.setOnAction(new EventHandler<ActionEvent>() {
        	public void handle(ActionEvent event) {
        		
        		FindManager findManager = new FindManager();
        		List<Manager> managerList = findManager.findAllManagers();
        		
        		managerList.sort(Comparator.comparing(Manager::getManagerFirstName));
        		
        		displayManagers.getItems().clear();
				for (int i = 0; i < managerList.size(); i++) {
					displayManagers.getItems().add(managerList.get(i));
				}
        	}
        });
        
        // Create Manager 
        addManagerBtn.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                String fname = String.valueOf(fnameText.getText());
                String mname = String.valueOf(mnameText.getText());
                String lname = String.valueOf(lnameText.getText());
                
                Name name = new Name(fname, mname,lname);
                
                String phone = String.valueOf(phoneText.getText());
                String email = String.valueOf(emailText.getText());
                
                int star = Integer.parseInt(starText.getText());
                String dob = String.valueOf(dobText.getText());
                
                Manager manager = new Manager (name, phone, email, dob,  star, null);
                
                CreateManager create = new CreateManager(manager);
            }
        });
    }

}
