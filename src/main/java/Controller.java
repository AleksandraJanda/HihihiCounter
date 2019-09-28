import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Window;

import java.io.IOException;
import java.time.LocalDateTime;

public class Controller {

    @FXML
    private AnchorPane pane;

    @FXML
    JFXButton hihihi;

    @FXML
    JFXButton ninja;

    @FXML
    JFXButton save;

    @FXML
    JFXTextField counter;

    @FXML
    ImageView mood;

    static int count = 0;

    private Image angry = new Image("/images/angry.png");
    private Image bad = new Image("/images/bad.png");
    private Image normal = new Image("/images/normal.png");
    private Image ok = new Image("/images/ok.png");
    private Image great = new Image("/images/great.png");

    //counting
    @FXML
    void counter() throws IOException {
        count();
        add();
        moodChanger();
        if (count % 10 == 0) {
            save();
        }
    }

    private void count() {
        count++;
        counter.setText(String.valueOf(count));
    }

    //save to files
    @FXML
    void save() throws IOException {
        FakeDatabase.saveData(FakeDatabase.listOfDayLaughCounts, FakeDatabase.allDays);
        FakeDatabase.saveData(FakeDatabase.listOfSingleLaughs, FakeDatabase.allLaughs);
    }

    //add laughs
    private void add() {
        LocalDateTime date = LocalDateTime.now();
        addSingleLaugh(date);
        addDayLaughCount(date);
    }

    private void addSingleLaugh(LocalDateTime date) {
        FakeDatabase.listOfSingleLaughs.add(date.toLocalDate() + " " + date.toLocalTime());
    }

    private void addDayLaughCount(LocalDateTime date) {
        if (FakeDatabase.isLastCurrentDay()) {
            FakeDatabase.listOfDayLaughCounts.remove(FakeDatabase.listOfDayLaughCounts.size() - 1);
        }
        FakeDatabase.listOfDayLaughCounts.add(date.toLocalDate() + " " + count);
    }

    //mood change
    private void moodChanger() {
        if (count >= 0 && count <= 10) {
            mood.setImage(great);
        } else if (count > 10 && count <= 20) {
            mood.setImage(ok);
        } else if (count > 20 && count <= 30) {
            mood.setImage(normal);
        } else if (count > 30 && count <= 40) {
            mood.setImage(bad);
        } else if (count > 40) {
            mood.setImage(angry);
        }
    }

    //stylesheet change
    @FXML
    void ninjaModeOn(ActionEvent ae) {
        changeStageSize(ae, 70);
        Main.scene.setRoot(Main.root2);
    }

    @FXML
    void ninjaModeOff(ActionEvent ae) {
        changeStageSize(ae, 330);
        Main.scene.setRoot(Main.root);

    }

    private void changeStageSize(ActionEvent ae, int height) {
        Node source = (Node) ae.getSource();
        Window theStage = source.getScene().getWindow();
        theStage.setHeight(height);
    }
}
