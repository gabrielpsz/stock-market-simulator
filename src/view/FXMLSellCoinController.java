package view;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class FXMLSellCoinController extends VBox {


    @FXML
    private ComboBox<?> sellCbCoin;

    @FXML
    private TextField sellQtdText;

    @FXML
    private Button sellBtn;

    @FXML
    private Button sellBtnCancel;

    @FXML
    private Label sellValueLabel;

    @FXML
    void sellBtnAction(ActionEvent event) {

    }

    @FXML
    void sellBtnCancelAction(ActionEvent event) {

    }
}
