package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    Stage stage=new Stage();

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("GoGame.fxml"));
        primaryStage.setTitle("井字遊戲");
        primaryStage.setScene(new Scene(root, 330, 330));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    public void show() throws Exception {
        start(stage);
    }
}
