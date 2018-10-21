import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("resources/Login.fxml"));
        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root));//Scene大小居然跟fxml有出入 甲骨文你方法怎麼寫的你
        //primaryStage.sizeToScene();調用這行會閃一下 怪了我不是在show之前調用的嗎 你閃個毛阿
        primaryStage.centerOnScreen();
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
