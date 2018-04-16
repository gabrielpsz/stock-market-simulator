package view;

import control.ActionController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Action;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLQuotationController implements Initializable {

    @FXML
    private MenuBar menuBar;

    @FXML
    private TableView<Action> tableQuotation;

    @FXML
    private TableColumn<Action, Double> columnPrice;

    @FXML
    private TableColumn<Action, String> columnAction;

    @FXML
    private Button quoteBtnSell;

    @FXML
    private MenuItem menuSell;

    @FXML
    private MenuItem menuQuotation;

    @FXML
    private Button quoteBtnBuy;

    @FXML
    private MenuItem menuDeposit;

    @FXML
    private MenuItem menuWallet;


    public FXMLQuotationController() {

    }

    @FXML
    public void goQuitAction() {
        Quotation.getStage().close();
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
    public void quoteBtnBuyAction() {
        BuyAction buyAction = new BuyAction();
        goQuitAction();
        try {
            buyAction.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void quoteBtnSellAction() {
        SellAction sellAction = new SellAction();
        goQuitAction();
        try {
            sellAction.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ObservableList<Action> loadTable() {
        ObservableList<Action> actions = FXCollections.observableArrayList(ActionController.getActionController().read());
        return actions;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        columnAction.setCellValueFactory(
                new PropertyValueFactory<>("name"));
        columnPrice.setCellValueFactory(
                new PropertyValueFactory<>("price"));

        tableQuotation.setItems(loadTable());
    }
}
