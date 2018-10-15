package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Login extends Application {
    @FXML
    private Pane root;
    @FXML
    private Pane mainRoot;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    @FXML
    private void login(javafx.event.ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("MainFrame.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        Stage primaryStage = (Stage) root.getScene().getWindow();
        Stage mainStage = (Stage) mainRoot.getScene().getWindow();
        double locX = primaryStage.getX();
        double stageWidth=primaryStage.getWidth();
        double locY = primaryStage.getY();
        double stageHeight=primaryStage.getHeight();
        double width=mainStage.getWidth();
        double height=mainStage.getHeight();

        stage.setX(locX+stageWidth/2-width/2);
        stage.setY(locY+stageHeight/2-height/2);
        stage.show();
    }

    @FXML
    public void test() {
        Stage stage = (Stage) root.getScene().getWindow();
        int locX = (int) stage.getX();
        int locY = (int) stage.getY();
    }

}



