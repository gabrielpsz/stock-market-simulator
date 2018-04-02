package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FXMLCashWithdrawalController {


    @FXML
    private ComboBox<?> cashCbBoxCoin;

    @FXML
    private TextField cashQuantText;

    @FXML
    private Label cashValueLabel;

    @FXML
    private Button cashBtnCancel;

    @FXML
    private Button cashBtnWithdrawal;

    @FXML
    void cashBtnCancelAction(ActionEvent event) {

    }

    @FXML
    void cashBtnWithdrawalAction(ActionEvent event) {

    }
}
