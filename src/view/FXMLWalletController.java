package view;

import control.ActionController;
import control.UserController;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;
import model.Action;
import model.User;
import model.WalletAction;

import java.lang.reflect.Array;
import java.net.URL;
import java.util.*;

public class FXMLWalletController implements Initializable {


    @FXML
    private Button walletDepositBtn;

    @FXML
    private MenuItem menuWallet;

    @FXML
    private TableView<WalletAction> walletTable;

    @FXML
    private TableColumn<WalletAction, String> actionColumn;

    @FXML
    private TableColumn<WalletAction, Double> valueColumn;

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
    private Label saldo_naorealizado;

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
        SellAction sellAction = new SellAction();
        goQuitAction();
        try {
            sellAction.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void walletBtnBuyAction(ActionEvent event) {
        BuyAction buyAction = new BuyAction();
        goQuitAction();
        try {
            buyAction.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        saldo_naorealizado.setText(ActionController.getActionController().setSaldoNaoRealizado().toString());
        actionColumn.setCellValueFactory(new PropertyValueFactory<>("nameAction"));
        valueColumn.setCellValueFactory(new PropertyValueFactory<>("qtd"));
        walletTable.setItems(FXCollections.observableList(listaSemReal()));
    }

    public ArrayList<WalletAction> listaSemReal() {
        ArrayList<WalletAction> walletActions = new ArrayList<>();
        for (WalletAction wa : UserController.getSessionUser().getWallet()) {
            if (!wa.getNameAction().equals("Real")) {
                walletActions.add(wa);
            }
        }
        return walletActions;
    }
}
