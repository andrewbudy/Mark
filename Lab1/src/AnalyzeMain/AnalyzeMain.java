package AnalyzeMain;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AnalyzeMain extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Analyze.fxml"));
        primaryStage.setResizable(false);
        primaryStage.setTitle("Analyzation of Erlang n-th Flow ");
        Scene scene = new Scene(root, 400, 275);
        scene.getStylesheets().add("Login.css");
        primaryStage.setScene(scene);


        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
