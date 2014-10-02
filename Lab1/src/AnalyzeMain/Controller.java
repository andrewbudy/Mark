package AnalyzeMain;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
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
    private Button genBtn;
    private Scanner s = null;
    private File output_file;


    @FXML protected void handleGenerateButtonAction(ActionEvent event) {
        String eol = System.getProperty("line.separator");
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
        double[] d = Analyzer.Analyze(values);

        kField.setText(String.format("%.2f",d[1]));
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
        }




    }
}