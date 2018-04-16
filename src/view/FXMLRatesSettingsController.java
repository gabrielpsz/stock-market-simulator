package view;

import control.ActionController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLRatesSettingsController implements Initializable {

    @FXML
    private MenuBar menuBar;

    @FXML
    private MenuItem menuBuy;

    @FXML
    private Button ratesBtnSave;

    @FXML
    private MenuItem menuSell;

    @FXML
    private MenuItem menuQuotation;

    @FXML
    private MenuItem menuDeposit;

    @FXML
    private MenuItem menuWallet;

    @FXML
    private TextField rateBrokerageTxt;

    @FXML
    private Button ratesBtnCancel;

    @FXML
    private TextField rateIofTxt;

    @FXML
    void goQuitAction() {
        RatesSettings.getStage().close();
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
        BuyAction buyAction = new BuyAction();
        goQuitAction();
        try {
            buyAction.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void goSellAction() {
        SellAction sellAction = new SellAction();
        goQuitAction();
        try {
            sellAction.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void ratesBtnSaveAction() {
        ActionController.setCorretagem(Double.parseDouble(rateBrokerageTxt.getText()));
        Login login = new Login();
        goQuitAction();
        try {
            login.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void ratesBtnCancelAction() {
        ActionController.setCorretagem(Double.parseDouble(rateIofTxt.getText()));
        Login login = new Login();
        goQuitAction();
        try {
            login.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
