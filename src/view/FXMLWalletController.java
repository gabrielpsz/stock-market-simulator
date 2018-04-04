package view;

import control.UserController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.User;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLWalletController implements Initializable {

    @FXML
    private TableView<User> walletTable;

    @FXML
    private Button walletDepositBtn;

    @FXML
    private MenuItem menuWallet;

    @FXML
    private TableColumn<User, Double> totalPriceColumn;

    @FXML
    private TableColumn<User, Double> qtdColumn;

    @FXML
    private TableColumn<?, ?> coinColumn;

    @FXML
    private TableColumn<?, ?> priceColumn;

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

    public void loadWallet() {
//        ObservableList<Double> wallet = FXCollections.observableArrayList(UserController.getUserController().listWallet());
//        System.out.println(UserController.getUserController().listWallet());
//        TODO - Implementar carrega tabela
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadWallet();
    }
}
