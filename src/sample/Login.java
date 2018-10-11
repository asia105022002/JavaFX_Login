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
import javafx.stage.Stage;

import java.io.IOException;

public class Login extends Application {
    Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage=primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void LoginMain(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MainFrame.fxml"));
        primaryStage.setTitle("Main");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public void LoginMain() throws Exception {
//        replaceSceneContent("MainFrame.fxml");
    }
//
//    private Parent replaceSceneContent(String fxml) throws Exception {
//        Parent page = (Parent) FXMLLoader.load(Login.class.getResource(fxml), null, new JavaFXBuilderFactory());
//        Scene scene = primaryStage.getScene();
//        if (scene == null) {
//            scene = new Scene(page, 700, 450);
//            scene.getStylesheets().add(Login.class.getResource("demo.css").toExternalForm());
//            primaryStage.setScene(scene);
//        } else {
//            primaryStage.getScene().setRoot(page);
//        }
//        primaryStage.sizeToScene();
//        return page;
//    }

    @FXML
    private void login(javafx.event.ActionEvent event) throws IOException
    {
        Parent blah = FXMLLoader.load(getClass().getResource("MainFrame.fxml"));
        Scene scene = new Scene(blah);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(scene);
        appStage.show();
    }
}



