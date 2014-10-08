package GenerateMain;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


import javafx.event.ActionEvent;
import javafx.stage.FileChooser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

public class Controller {


    @FXML
    private TextField nField;
    @FXML
    private TextField kField;
    @FXML
    private TextField lField;
    @FXML
    private Button genBtn;
    private BufferedWriter bw;
    private File output_file;


    @FXML protected void handleGenerateButtonAction(ActionEvent event) {
        String eol = System.getProperty("line.separator");
        int k = Integer.parseInt(kField.getText());
        double l = Double.parseDouble(lField.getText());
        int n = Integer.parseInt(nField.getText());
        ArrayList<Double> values = Generator.Generate(n, l, k);

        try {
            bw = new BufferedWriter(new FileWriter(output_file));
            for (int i = 0; i < n; i++) {
                bw.write(String.format(Locale.ENGLISH,"%.2f",values.get(i)) + " ");
                if ((i+1)%10 == 0) bw.write(eol);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (bw != null) try { bw.close(); } catch (IOException ignore) {}
        }
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