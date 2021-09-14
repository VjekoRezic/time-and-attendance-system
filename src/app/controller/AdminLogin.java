package app.controller;

import app.helpers.Email;
import app.helpers.PushNotifications;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import app.Main;
import app.model.LoggedInModel;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminLogin implements Initializable  {

    public MFXButton btnLogin;
    public Label errorLabel;
    PushNotifications notifications;

    @FXML
    TextField emailTxt;
    @FXML
    PasswordField passTxt;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        notifications = new PushNotifications();
    }

    public void handleBtnLogin(ActionEvent e) throws IOException {

        Stage stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        String email = emailTxt.getText();
        String pass = passTxt.getText();

        // e-mail and password validation
        if (email.equals("") || pass.equals("")){
            errorLabel.setText("Potrebno je popuniti oba polja.");
        }

        else if(isValidEmailAddress(email)){
            LoggedInModel user = LoggedInModel.login(email, pass);
            if(user == null) {
                errorLabel.setText("Pogrešan e-mail ili lozinka!");
            }
            else if(user.isLogged && user.isAdmin){
                // fire success notification
                notifications.showNotification("STANDARD", "Uspješna prijava", "Pozdrav " + user.userName + "!", "Lijepo je vidjeti Vas opet.");
                // open admin dashboard
                Parent root = FXMLLoader.load(Main.class.getResource("view/AdminDash.fxml"));
                stage.setScene(new Scene(root, 950, 650));
                stage.sizeToScene();
                stage.show();
            }
            else if(user.isLogged && !user.isAdmin){
                errorLabel.setText("Nemate pristup administraciji.");
            }
            else {
                errorLabel.setText("Izgleda da je došlo do greške.");
            }
        }
        else {
            errorLabel.setText("E-adresa nije valjana.");
        }
    }

    private boolean isValidEmailAddress(String email) {
        Email eMailHelper = new Email();
        return eMailHelper.isValid(email);
    }
}
