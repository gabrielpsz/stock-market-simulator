package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class FXMLRegisterUserController {


    @FXML
    private TextField registerUserName;

    @FXML
    private TextField registerUserCPF;

    @FXML
    private TextField registerUserLoginName;

    @FXML
    private PasswordField registerUserPassword;

    @FXML
    private Button registerUserBtnCancel;

    @FXML
    private Button registerUserBtnSave;

    public FXMLRegisterUserController() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("RegisterUser.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
    }

    @FXML
    public void registerUserBtnCancelAction(ActionEvent event) {
    }

    @FXML
    public void registerUserBtnSaveAction(ActionEvent event) {
    }
}
