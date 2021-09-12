package app.controller;

import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminPanel implements Initializable {
    public MFXButton btnKorisnici;
    public ImageView userIconBtn;

    @FXML
    public BorderPane mainPane;





    public void initialize(URL url, ResourceBundle resourceBundle) {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPane("UsersInfoTable");
        mainPane.setCenter(view);



    }



    public void handleBtnKorisnici(ActionEvent actionEvent){

        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPane("UsersInfoTable");
        mainPane.setCenter(view);


    }


    public void handleBtnRadnaMjesta(ActionEvent actionEvent) {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPane("WorkplacesOverview");
        mainPane.setCenter(view);
    }

    public void handleBtnEvidencija(ActionEvent actionEvent) {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPane("AttendanceRecords");
        mainPane.setCenter(view);
    }

    public BorderPane getPane() {
        return mainPane;

    }
}
