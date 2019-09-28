import javafx.application.Application;
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
    static Parent root2;
    static Scene scene;

    private File days = new File("AllDays.txt");
    private File laughs = new File("AllLaughs.txt");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException, URISyntaxException {
        root = FXMLLoader.load(getClass().getResource("/main.fxml"));
        root2 = FXMLLoader.load(getClass().getResource("/ninja.fxml"));
        root.getStylesheets().add("/stylesheets/main.css");
        root2.getStylesheets().add("/stylesheets/ninja.css");

        primaryStage.setTitle("HihihiCounter");
        int width = 300;
        int height = 300;
        scene = new Scene(root, width, height);
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image("/images/icon.png"));
        primaryStage.setResizable(false);
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
