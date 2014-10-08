package AnalyzeMain;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {


    @FXML
    private Label kField;
    @FXML
    private Label lField;
    @FXML
    private Label aCField;
    @FXML
    private Button genBtn;
    @FXML
    private Button aCBtn;
    @FXML
    private Label kText;
    @FXML
    private Label aCText;
    @FXML
    private Label lText;
    private File output_file;
    private ArrayList<Double> values;
    private Scanner s = null;

    @FXML protected void handleGenerateButtonAction(ActionEvent event) {
        values = getValues();
        double[] d = Analyzer.analyze(values);
        lText.setVisible(true);
        kText.setVisible(true);
        kField.setText(String.format("%.2f",d[1]));;
        lField.setText(String.format("%.2f",d[0]));

    }

    @FXML protected void handleChooseFileButtonAction(ActionEvent event){

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            output_file = selectedFile;
           genBtn.setDisable(false);
           aCBtn.setDisable(false);
        }




    }

    @FXML protected void handleCalcAutoCorButtonAction(ActionEvent event) {
        values = getValues();
        aCText.setVisible(true);
        double ac = Analyzer.calcAC(values,1);
        aCField.setText(String.format("%.8f",ac));


    }

    private ArrayList<Double> getValues(){
        ArrayList<Double> values = new ArrayList<Double>();
        try {
            s = new Scanner(output_file);
            while (s.hasNext()) {
                values.add(Double.parseDouble(s.next()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            s.close();
        }
        return values;
    }
}