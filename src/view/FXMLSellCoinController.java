package view;

import control.CoinController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Coin;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLSellCoinController implements Initializable {

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
    private ComboBox<Coin> sellCbCoin;

    @FXML
    private MenuItem menuWallet;

    @FXML
    private Button sellBtnCancel;

    @FXML
    private TextField sellQtdText;


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

    public ObservableList<Coin> loadCheckBox() {
        ObservableList<Coin> coins = FXCollections.observableArrayList(CoinController.getCoinController().read());
        return coins;
    }

    @FXML
    public void sellBtnAction() {
        CoinController.getCoinController().exchange(Double.parseDouble(sellQtdText.getText()), sellCbCoin.getValue(), CoinController.getCoinController().searchCoin("Real"));

    }

    @FXML
    public void sellBtnCancelAction() {
        Wallet wallet = new Wallet();
        goQuitAction();
        try {
            wallet.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sellCbCoin.setItems(loadCheckBox());
    }
}
