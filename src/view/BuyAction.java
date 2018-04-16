package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BuyAction extends Application {

    private static Stage stage;

    @Override
    public void start(Stage stage) throws Exception {

        Parent buyAction = FXMLLoader.load(getClass().getResource("BuyAction.fxml"));
        Scene scene = new Scene(buyAction);
        stage.setScene(scene);
        stage.show();
        setStage(stage);
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        BuyAction.stage = stage;
    }

    public static void main(String[] args) {
        launch(args);
    }

}
