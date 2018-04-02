package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class FXMLLoginController extends VBox {

    @FXML
    private TextField LoginUserText;

    @FXML
    private PasswordField LoginUserPass;

    @FXML
    private Button loginBtnRegisterUser;

    @FXML
    private Button LoginBtn;


    @FXML
    public void LoginBtnAction(ActionEvent event) {

    }

    @FXML
    public void loginBtnRegisterUserAction(ActionEvent event) {

    }
}
