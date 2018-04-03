package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private static Stage stage;

    private static Scene loginScene;
    private static Scene registerUserScene;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;

        Parent login = FXMLLoader.load(getClass().getResource("Login.fxml"));
        loginScene = new Scene(login);

        Parent registerUser = FXMLLoader.load(getClass().getResource("RegisterUser.fxml"));
        registerUserScene = new Scene(registerUser);

        primaryStage.setScene(loginScene);
        primaryStage.show();
    }

    public static void changeScreen(String scr) {
        switch (scr) {
            case "login":
                stage.setScene(loginScene);
                break;
            case "registerUser":
                stage.setScene(registerUserScene);
                break;
            default:
                break;
        }
    }


    public static void main(String[] args) {
        launch(args);
    }

}
