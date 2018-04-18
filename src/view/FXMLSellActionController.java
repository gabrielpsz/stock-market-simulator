package view;

import control.ActionController;
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
import model.Action;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLSellActionController implements Initializable {

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
    private ComboBox<Action> sellCbAction;

    @FXML
    private MenuItem menuWallet;

    @FXML
    private Button sellBtnCancel;

    @FXML
    private TextField sellQtdText;


    @FXML
    public void goQuitAction() {
        SellAction.getStage().close();
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

    public ObservableList<Action> loadCheckBox() {
        ObservableList<Action> actions = FXCollections.observableArrayList(ActionController.getActionController().read());
        actions.remove(ActionController.getActionController().searchAction("Real"));
        return actions;
    }

    @FXML
    public void sellBtnAction() {
        ActionController.getActionController().venda(Double.parseDouble(sellQtdText.getText()), sellCbAction.getValue(), ActionController.getActionController().searchAction("Real"));
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
        sellCbAction.setItems(loadCheckBox());
    }
}
