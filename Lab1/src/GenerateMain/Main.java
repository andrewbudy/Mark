package GenerateMain;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Generate.fxml"));
        primaryStage.setResizable(false);
        primaryStage.setTitle("Generation of Erlang n-th Flow ");

        primaryStage.setScene(new Scene(root, 400, 275));


        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
