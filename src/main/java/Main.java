import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class Main extends Application {
    static Parent root;

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
    }
}
