package sample.controller;

import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import sample.model.Radnomjesto;

public class AddNewWorkplace {
    public AnchorPane workplaces;
    public MFXButton backBtn;
    public TextField workplaceNameField;
    public TextField hourRateField;
    public MFXButton addNewBtn;

    public void handleBackBtn(ActionEvent actionEvent) {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPane("WorkplacesOverview");

        workplaces.getChildren().clear();
        workplaces.getChildren().add(view);
    }

    public void handleAddNewBtn(ActionEvent actionEvent) {
        Radnomjesto rm = new Radnomjesto(workplaceNameField.getText(), Double.parseDouble(hourRateField.getText()));
        rm.createWorkplace();
        clearFields();
        loadWorkplacesOverview();
    }

    private void loadWorkplacesOverview() {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPane("WorkplacesOverview");

        workplaces.getChildren().clear();
        workplaces.getChildren().add(view);
    }

    private void clearFields() {
        this.workplaceNameField.clear();
        this.hourRateField.clear();
    }
}
