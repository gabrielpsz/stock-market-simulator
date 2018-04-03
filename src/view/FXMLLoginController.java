package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class FXMLLoginController {

    @FXML
    private Button loginBtnRegisterUser;

    @FXML
    private PasswordField LoginUserPass;

    @FXML
    private Button LoginBtn;

    @FXML
    private TextField LoginUserText;

    @FXML
    private MenuItem menuQuit;

    public FXMLLoginController() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

    }

    @FXML
    protected void goQuitAction(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    protected void loginBtnRegisterUserAction(ActionEvent event) {
        Main.changeScreen("registerUser");
    }

    @FXML
    protected void LoginBtnAction(ActionEvent event) {

    }

}
