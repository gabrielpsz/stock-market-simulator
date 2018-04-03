package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

public class FXMLCashWithdrawalController {

    @FXML
    private MenuBar menuBar;

    @FXML
    private ComboBox<?> cashCbBoxCoin;

    @FXML
    private Button cashBtnWithdrawal;

    @FXML
    private MenuItem menuSell;

    @FXML
    private MenuItem menuQuotation;

    @FXML
    private TextField cashQuantText;

    @FXML
    private MenuItem menuDeposit;

    @FXML
    private Button cashBtnCancel;

    @FXML
    private MenuItem menuWallet;

    @FXML
    private Label cashValueLabel;

    @FXML
    void goWalletAction(ActionEvent event) {

    }

    @FXML
    void goQuotationAction(ActionEvent event) {

    }

    @FXML
    void goDepositAction(ActionEvent event) {

    }

    @FXML
    void goSellAction(ActionEvent event) {

    }

    @FXML
    void cashBtnCancelAction(ActionEvent event) {

    }

    @FXML
    void cashBtnWithdrawalAction(ActionEvent event) {

    }

}
