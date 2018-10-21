package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

import java.util.ArrayList;

public class GoGameController {
    private boolean act=true;
    private int st=0;

    @FXML
    private ArrayList<Button> btnList ;

    public void BtnOnClick(ActionEvent e){
        if(act)
        {
            Button t=(Button)e.getSource();
            if(t.getText().equals(""))
            {
                t.setText(st++%2==0?"O":"X");
                judge();
            }
        }
    }

    private void judge(){
        int[][] i={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
        for (int[] anI : i) {
            if (!btnList.get(anI[0]).getText().equals(""))
                if (btnList.get(anI[0]).getText().equals(btnList.get(anI[1]).getText()) && btnList.get(anI[0]).getText().equals(btnList.get(anI[2]).getText())||st==9) {
                    act = false;
                    Alert msg = new Alert(Alert.AlertType.CONFIRMATION);
                    msg.setTitle("系統提示");
                    if(st==9)
                        msg.setHeaderText("平局");
                    else
                        msg.setHeaderText(btnList.get(anI[0]).getText().equals("O") ? "O勝利" : "X勝利");
                    msg.setContentText("重新開始遊戲?");
                    msg.showAndWait();
                    ButtonType rtn = msg.getResult();
                    if (rtn == ButtonType.OK)
                        restart();
                }
        }
    }

    private void restart() {
        act=true;
        st=0;
        for(Button btn:btnList)
            btn.setText("");
    }
}
