import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Controller {

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

    private int count = 0;

    Image angry = new Image("/images/angry.png");
    Image bad = new Image("/images/bad.png");
    Image normal = new Image("/images/normal.png");
    Image ok = new Image("/images/ok.png");
    Image great = new Image("/images/great.png");

    //counting
    @FXML
    void counter() {
        count();
        moodChanger();
    }

    private void count() {
        count++;
        counter.setText(String.valueOf(count));
    }

    //save to files


    //mood change
    private void moodChanger() {
        if (count >= 0 && count <= 10) {
            mood.setImage(great);
        } else if (count > 10 && count <= 20) {
            mood.setImage(ok);
        } else if (count > 20 && count <= 40) {
            mood.setImage(normal);
        } else if (count > 40 && count <= 60) {
            mood.setImage(bad);
        } else if (count > 60) {
            mood.setImage(angry);
        }
    }

    //stylesheet change

}
