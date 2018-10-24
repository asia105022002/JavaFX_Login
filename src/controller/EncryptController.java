package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.*;


public class EncryptController {
    @FXML
    Parent root;
    @FXML
    RadioButton radioBtnEn;
    @FXML
    RadioButton radioBtnDe;
    @FXML
    ComboBox comboBoxMathod;
    @FXML
    TextField textFieldPw;
    @FXML
    ToggleGroup mode;
    @FXML
    TextArea textAreaLeft;
    @FXML
    TextArea textAreaRight;

    @FXML
    public void initialize() {
        ObservableList<String> mathodOptions =FXCollections.observableArrayList("DES","AES","XOR","Caeser");
        comboBoxMathod.setValue("Caeser");
        comboBoxMathod.setItems(mathodOptions);
    }

    public void run() throws Exception {
        RadioButton radioButton=(RadioButton)mode.getSelectedToggle();
        boolean encryptMode = radioButton.getText().equals("Encrypt");
        String mathod=comboBoxMathod.getSelectionModel().getSelectedItem().toString();
        String contain_string=textAreaLeft.getText();
        String key=textFieldPw.getText();
        if(contain_string.length()==0) {
            Alert alert = new Alert(Alert.AlertType.ERROR,"請輸入內容");
            alert.setHeaderText(null);
            alert.showAndWait();
        }
        else if(key.length()==0) {
            Alert alert = new Alert(Alert.AlertType.ERROR,"請輸入金鑰");
            alert.setHeaderText(null);
            alert.showAndWait();
        }
        else {
            byte[] contain=encryptMode?contain_string.getBytes():plugs.EncryptMathod.hex2Byte(contain_string);
            byte[] temp=new byte[0];
            switch(mathod) {
                case "DES":
                    try {
                        temp=plugs.EncryptMathod.DES(contain, key, encryptMode);
                    } catch (Exception e) {
                        Alert alert = new Alert(Alert.AlertType.ERROR,"DES金鑰須為8的倍數");
                        alert.setHeaderText(null);
                        alert.showAndWait();
                    }
                    break;
                case "AES": {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Unfinished");
                    alert.setHeaderText(null);
                    alert.showAndWait();
                    break;
                }
                case "XOR":
                    temp=plugs.EncryptMathod.XOR(contain, key);
                    break;
                case "Caeser":
                    try{
                        temp=plugs.EncryptMathod.Caesar(contain, Integer.parseInt(key), encryptMode);
                    }catch (Exception exception){
                        Alert alert = new Alert(Alert.AlertType.ERROR,"Caeser金鑰為±255間的整數");
                        alert.setHeaderText(null);
                        alert.showAndWait();
                    }
                    break;
            }
            textAreaRight.setText(encryptMode?plugs.EncryptMathod.byte2Hex(temp):new String(temp));
        }

    }

    public void load() throws Exception {
        FileChooser fileChooser = new FileChooser();
        //fileChooser.setInitialDirectory();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("txt", "*.txt"));
        File seletedFile = fileChooser.showOpenDialog(null);
        if(seletedFile!=null) {
            long fileSize = seletedFile.length();
            if (fileSize > Integer.MAX_VALUE) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("檔案過大");
                alert.showAndWait();
            }
            else {
                FileInputStream fileInputStream = new FileInputStream(seletedFile);
                byte[] buffer = new byte[(int) fileSize];
                BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
                bufferedInputStream.read(buffer);
                textAreaLeft.setText(new String(buffer,"Big5"));
                fileInputStream.close();
            }
        }
    }

    public void save() throws Exception {
        FileChooser fileChooser = new FileChooser();
        //fileChooser.setInitialDirectory();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("txt", "*.txt"));
        File seletedFile = fileChooser.showSaveDialog(null);
        if(seletedFile!=null) {
            FileWriter fileWriter= new FileWriter(seletedFile);
            BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
            bufferedWriter.write(textAreaRight.getText());
            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();
        }
    }

    public void exit(){
        Stage stage = (Stage) root.getScene().getWindow();
        stage.close();
    }

}
