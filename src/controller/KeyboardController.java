package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;

import java.util.ArrayList;
import java.util.Collections;

public class KeyboardController {
    @FXML
    Parent root;
    @FXML
    ArrayList<Button> btnList;
    @FXML
    PasswordField passwordField;
    private ArrayList numberList;
    private LoginController loginController;

    public void injectLoginController(LoginController loginController) {
        this.loginController = loginController;
    }


    @FXML
    public void initialize() {
        numberList = new ArrayList();
        for(int c=0;c<10;c++)
            numberList.add(c);
        shuffleButtons();
    }

    public void shuffleButtons() {
        Collections.shuffle(numberList);
        for(int c=0;c<btnList.size();c++)
            btnList.get(c).setText(String.valueOf(numberList.get(c)));
        System.out.println(passwordField.getText());
    }

    @FXML
    public void btn(ActionEvent e) {
        Button btn =(Button)e.getSource();
        passwordField.setText(passwordField.getText()+btn.getText());
    }

    public void backspace() {
        String pw=passwordField.getText();
        passwordField.setText(pw.substring(0,pw.length()-1));
    }

    public void enter() {
        loginController.setPassword(passwordField.getText());
        passwordField.setText("");
        root.getScene().getWindow().hide();
        // Platform.exit();
    }

}
