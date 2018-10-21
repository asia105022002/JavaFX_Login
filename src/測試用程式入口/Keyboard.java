package 測試用程式入口;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Collections;



public class Keyboard extends Application {
    @FXML
    Parent root;
    @FXML
    ArrayList<Button> btnList;
    @FXML
    PasswordField passwordField;

    private ArrayList numberList;
    private Login login;

    public Keyboard() {
    }

    public Keyboard(Login login) {
        this.login=login;
    }

    public void  showWindow() throws Exception {
        Stage stage=new Stage();
        start(stage);
        stage.setX(login.root.getScene().getWindow().getX()- stage.getWidth());
        stage.setY(login.root.getScene().getWindow().getY());
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
        if(login!=null)
            login.setPassword(passwordField.getText());
        else
            System.out.println("null");
        passwordField.setText("");
        root.getScene().getWindow().hide();
        // Platform.exit();
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../resources/Keyboard.fxml"));
        primaryStage.setTitle("Keyboard");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.sizeToScene();
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
