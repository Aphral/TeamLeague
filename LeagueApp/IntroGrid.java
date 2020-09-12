

package LeagueApp;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.io.FileInputStream;

/**
 * IntroGrid contains just an image for the application
 * 
 * @author aphralgriffin
 * 
 */

public class IntroGrid extends GridPane {

    public IntroGrid() {
        setPadding(new Insets(10));

        HBox imageHbox = new HBox();

        try {
            FileInputStream input = new FileInputStream("src/football.png");
            Image image = new Image(input);
            ImageView imageView = new ImageView(image);
            imageHbox.getChildren().addAll(imageView);
        } catch (Exception e) {
            System.out.println("Something Went Wrong\n");
            e.printStackTrace();
            System.exit(0);
        }
        Label introLabel = new Label("Welcome To");
        Label introLabel2 = new Label("The League Application");

        introLabel.setStyle("-fx-font: 24 arial");
        introLabel2.setStyle("-fx-font: 24 arial");

        add(imageHbox, 0, 3, 1, 1);
        add(introLabel2, 0, 2, 1, 1);
        add(introLabel, 0, 1, 1, 1);

        GridPane.setHalignment(introLabel, HPos.CENTER);
        GridPane.setHalignment(imageHbox, HPos.CENTER);
        GridPane.setHalignment(introLabel2, HPos.CENTER);
    }
}