package view;

import control.UserController;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Coin;
import model.User;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

public class FXMLWalletController implements Initializable {


    @FXML
    private Button walletDepositBtn;

    @FXML
    private MenuItem menuWallet;

    @FXML
    private TableView<String> walletTable;

    @FXML
    private TableColumn<String, String> coinColumn;

    @FXML
    private Button walletBtnSell;

    @FXML
    private MenuBar menuBar;

    @FXML
    private MenuItem menuSell;

    @FXML
    private MenuItem menuQuotation;

    @FXML
    private MenuItem menuDeposit;

    @FXML
    private Button walletBtnBuy;

    @FXML
    private Button walletCashWithBtn;

    @FXML
    public void goQuitAction() {
        Wallet.getStage().close();
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
    void walletDepositBtnAction(ActionEvent event) {
        CashDeposit deposit = new CashDeposit();
        goQuitAction();
        try {
            deposit.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void walletCashWithBtnAction(ActionEvent event) {
        CashWithdrawal withdrawal = new CashWithdrawal();
        goQuitAction();
        try {
            withdrawal.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void walletBtnSellAction(ActionEvent event) {
        SellCoin sellCoin = new SellCoin();
        goQuitAction();
        try {
            sellCoin.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void walletBtnBuyAction(ActionEvent event) {
        BuyCoin buyCoin = new BuyCoin();
        goQuitAction();
        try {
            buyCoin.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ObservableList<String> loadWallet() {
        ObservableList<String> wallet = FXCollections.observableArrayList(UserController.getUserController().listWallet());
//        TODO - Implementar carrega tabela
        return wallet;

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println(loadWallet());
        coinColumn.setCellValueFactory(x -> new SimpleObjectProperty<>(loadWallet().toString()));
        walletTable.setItems(loadWallet());
    }
}
