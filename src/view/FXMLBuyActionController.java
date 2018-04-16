package view;

import control.ActionController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Action;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLBuyActionController implements Initializable {

    @FXML
    private MenuBar menuBar;

    @FXML
    private TextField buyQuantText;

    @FXML
    private Label buyValueLabel;

    @FXML
    private MenuItem menuSell;

    @FXML
    private MenuItem menuQuotation;

    @FXML
    private MenuItem menuDeposit;

    @FXML
    private Button buyBtn;

    @FXML
    private MenuItem menuWallet;

    @FXML
    private Button buyBtnCancel;

    @FXML
    private ComboBox<Action> buyCbBoxAction;

    @FXML
    private ComboBox<Action> buyCbBoxActionOut;

    @FXML
    public void goQuitAction() {
        BuyAction.getStage().close();
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
    public void buyBtnAction() {
        ActionController.getActionController().exchange(Double.parseDouble(buyQuantText.getText()), ActionController.getActionController().searchAction("Real"), buyCbBoxAction.getValue());
        Quotation quotation = new Quotation();
        goQuitAction();
        try {
            quotation.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void buyBtnCancelAction() {
        Quotation quotation = new Quotation();
        goQuitAction();
        try {
            quotation.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public ObservableList<Action> loadCheckBox() {
        ObservableList<Action> actions = FXCollections.observableArrayList(ActionController.getActionController().read());
        return actions;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        buyCbBoxAction.setItems(loadCheckBox());
        //buyCbBoxActionOut.setItems(loadCheckBox());
    }
}
