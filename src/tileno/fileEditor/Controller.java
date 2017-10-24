package tileno.fileEditor;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Label prog_name;

    @FXML
    private TextField input;

    @FXML
    private TextArea output;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        prog_name.setText(Main.TITLE);
    }

    @FXML
    protected void load(ActionEvent actionEvent){
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(input.getText() + ".data"));
            String line;
            while ((line = br.readLine()) != null) {
                output.setText(line);
            }
            br.close();
        }
        catch (IOException e){
            AlertBox.display("Error","No such file!");
        }
    }

    @FXML
    protected void save(ActionEvent actionEvent) throws IOException {
        FileOutputStream out = new FileOutputStream(input.getText() + ".data");
        byte[] data = output.getText().getBytes();
        out.write(data);
        out.close();
    }
}
