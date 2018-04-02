package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class FXMLBuyCoinController extends VBox {


    @FXML
    private ComboBox<?> buyCbBox;

    @FXML
    private TextField buyQuantText;

    @FXML
    private Label buyValueLabel;

    @FXML
    private Button buyBtn;

    @FXML
    private Button buyBtnCancel;


    @FXML
    void buyBtnAction(ActionEvent event) {

    }

    @FXML
    void buyBtnCancelAction(ActionEvent event) {

    }
}
