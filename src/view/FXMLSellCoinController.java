package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FXMLSellCoinController {

    @FXML
    private MenuBar menuBar;

    @FXML
    private Button sellBtn;

    @FXML
    private MenuItem menuSell;

    @FXML
    private MenuItem menuQuotation;

    @FXML
    private MenuItem menuDeposit;

    @FXML
    private ComboBox<?> sellCbCoin;

    @FXML
    private MenuItem menuWallet;

    @FXML
    private Button sellBtnCancel;

    @FXML
    private TextField sellQtdText;

    @FXML
    private Label sellValueLabel;

    @FXML
    public void goQuitAction() {
        SellCoin.getStage().close();
    }

    @FXML
    public void goWalletAction() {
        Wallet wallet = new Wallet();
        goQuitAction();
        try {
            wallet.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void goQuotationAction() {
        Quotation quotation = new Quotation();
        goQuitAction();
        try {
            quotation.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void goDepositAction() {
        CashDeposit deposit = new CashDeposit();
        goQuitAction();
        try {
            deposit.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void goBuyAction() {
        BuyCoin buyCoin = new BuyCoin();
        goQuitAction();
        try {
            buyCoin.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void goSellAction() {
        SellCoin sellCoin = new SellCoin();
        goQuitAction();
        try {
            sellCoin.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void sellBtnAction(ActionEvent event) {

    }

    @FXML
    void sellBtnCancelAction(ActionEvent event) {

    }

}
