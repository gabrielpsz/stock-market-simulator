package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class FXMLRegisterUserController {


    @FXML
    private Button registerUserBtnCancel;

    @FXML
    private Button registerUserBtnSave;

    @FXML
    private PasswordField registerUserPassword;

    @FXML
    private TextField registerUserCPF;

    @FXML
    private TextField registerUserLoginName;

    @FXML
    private MenuItem menuQuit;

    @FXML
    private TextField registerUserName;

    public FXMLRegisterUserController() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("RegisterUser.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
    }

    @FXML
    void goQuitAction(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void registerUserBtnCancelAction(ActionEvent event) {
        Main.changeScreen("login");
    }

    @FXML
    void registerUserBtnSaveAction(ActionEvent event) {

    }
}
