package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SellAction extends Application {

    private static Stage stage;

    @Override
    public void start(Stage stage) throws Exception {

        Parent sellAction = FXMLLoader.load(getClass().getResource("SellAction.fxml"));
        Scene scene = new Scene(sellAction);
        stage.setScene(scene);
        stage.show();
        setStage(stage);
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        SellAction.stage = stage;
    }


    public static void main(String[] args) {
        launch(args);
    }

}