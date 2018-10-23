package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class menuController {
    @FXML
    private Button buttonDisplay;

    @FXML
    void xuLyEvent(ActionEvent event) {
        try {
            Parent parent;
            parent = FXMLLoader.load(getClass().getResource("sample.fxml"));
            Stage stage = (Stage) buttonDisplay.getScene().getWindow();
            stage.hide();
            stage.setTitle("My Dictionary");
            stage.setScene(new Scene(parent));
            stage.show();
        } catch (Exception e) {

        }
    }

    @FXML
    void initialize() {

    }
}
