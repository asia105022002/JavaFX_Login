package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    private Stage stageKeyboard;
    @FXML
    Parent root;
    @FXML
    PasswordField passwordField;

    @FXML
    private void login(javafx.event.ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("../resources/MainStage.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Main");
        stage.centerOnScreen();
        stage.show();
    }

    public void exit() {
        System.exit(0);
    }

    public void keyboard() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/Keyboard.fxml"));
        Parent keyboardPane = loader.load();
        KeyboardController keyboardController = loader.getController();
        keyboardController.injectLoginController(LoginController.this);
        Scene sceneKeyboard = new Scene(keyboardPane);
        if(stageKeyboard==null) {
            stageKeyboard = new Stage();
            stageKeyboard.setTitle("Keyboard");
            stageKeyboard.setScene(sceneKeyboard);
            stageKeyboard.setResizable(false);
            stageKeyboard.show();
            setKeyboardLocation();//不能在show前調用 因為stageKeyboard.getWidth()會Nan 好懶得查 就讓他閃吧
        }
        else if(!stageKeyboard.isShowing()) {
            stageKeyboard.show();
            setKeyboardLocation();
            PasswordField passwordField = (PasswordField)stageKeyboard.getScene().lookup("#passwordField");
            passwordField.setText("");
        }
    }


    private void setKeyboardLocation() {
        stageKeyboard.setX(root.getScene().getWindow().getX()- stageKeyboard.getWidth());
        stageKeyboard.setY(root.getScene().getWindow().getY());
    }


    public void setPassword(String password) {
        passwordField.setText(password);
    }
}
