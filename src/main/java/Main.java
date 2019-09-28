import com.jfoenix.controls.JFXTextField;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class Main extends Application {

    static Parent root;
    File days = new File("AllDays.txt");
    File laughs = new File("AllLaughs.txt");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException, URISyntaxException {
        root = FXMLLoader.load(getClass().getResource("/main.fxml"));
        root.getStylesheets().add("/stylesheets/main.css");
        primaryStage.setTitle("HihihiCounter");
        primaryStage.setScene(new Scene(root, 300, 300));
        primaryStage.getIcons().add(new Image("/images/icon.png"));
        primaryStage.show();

        if (!days.exists()) {
            FakeDatabase.saveData(new ArrayList<>(), FakeDatabase.allDays);
        }
        if (!laughs.exists()) {
            FakeDatabase.saveData(new ArrayList<>(), FakeDatabase.allLaughs);
        }
        if (days.exists()) {
            FakeDatabase.readData(FakeDatabase.listOfDayLaughCounts, days);
        }
        if (laughs.exists()) {
            FakeDatabase.readData(FakeDatabase.listOfSingleLaughs, laughs);
        }

        Controller.count = FakeDatabase.readCurrentDayCount();
    }
}
