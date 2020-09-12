

package LeagueApp;

import javafx.application.Application;

import java.util.ArrayList;
import java.util.List;

import LeagueApp.service.*;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


/**
 * <h1>My League Application!</h1> LeagueController starts the
 * application and links the model to the tab panes.
 * 
 * @author aphralgriffin
 * 
 */
public class LeagueController extends Application {
    private VBox leaguePanevBox;
    private Group sceneContent;
    private Scene mainScene;


    public void start(Stage primaryStage) throws Exception{
    	
    	// Create League Pane 
        LeaguePane leaguePane = new LeaguePane();

        leaguePanevBox = new VBox(leaguePane);

        // Create Group
        sceneContent = new Group();

        // Add Pane To Group
        sceneContent.getChildren().addAll(leaguePanevBox);

        // Create Scene, Add Content, Set Colour
        mainScene = new Scene(sceneContent, 500, 650, Color.LIGHTGRAY);

        primaryStage.setTitle("League Application");
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }


    public static void main(String[] args) {
      launch(args);
        
    }
}
