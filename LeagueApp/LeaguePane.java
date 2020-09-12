

package LeagueApp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
 
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;


/**
 * LeaguePane creates all the grids and sets all the tabs in the application.
 * 
 * @author aphralgriffin
 * 
 */

public class LeaguePane extends TabPane {

    public LeaguePane(){

    	// Creates all the diffrent grids
        IntroGrid introGridPane = new IntroGrid();
        LeagueGrid leagueGridPane = new LeagueGrid();
        ManagerGrid managerGridPane = new ManagerGrid();
        PlayerGrid playerGridPane = new PlayerGrid();
        TeamGrid teamGridPane = new TeamGrid();

        // adds grids to tabs 
        Tab introTab = new Tab("Intro", introGridPane);
        Tab playerTab = new Tab("Player", playerGridPane);
        Tab managerTab = new Tab("Manager", managerGridPane);
        Tab teamTab = new Tab("Team", teamGridPane);
        Tab leagueTab = new Tab("League", leagueGridPane);
        getTabs().add(introTab);
        getTabs().add(playerTab);
        getTabs().add(managerTab);
        getTabs().add(teamTab);
        getTabs().add(leagueTab);
        setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);

    }



}
