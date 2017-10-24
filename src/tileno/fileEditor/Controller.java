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

    @FXML
    private Label state;

    /**
     * This is kind of the 'load' function
     * Here the program name is set and it disables the text area editing
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        prog_name.setText(Main.TITLE);
        output.setEditable(false);
    }

    /**
     * Used to load a file
     * If the file does not exist it throws and shows an 'error' alert box
     * @param actionEvent
     */
    @FXML
    protected void load(ActionEvent actionEvent){
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(Main.class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("File_Editor.jar","")  + input.getText() + ".txt"));
            String line;
            while ((line = br.readLine()) != null) {
                output.setText(line);
                state.setText(input.getText() + " has loaded!");
            }
            br.close();
            output.setEditable(true);
        }
        catch (IOException e){
            AlertBox.display("Error","No such file!");
        }
    }

    /**
     * Saving of the file
     * Basically takes the text from the text area and writes it into the file
     * @param actionEvent
     * @throws IOException
     */
    @FXML
    protected void save(ActionEvent actionEvent) throws IOException {
        FileOutputStream out = new FileOutputStream(Main.class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("File_Editor.jar","") + input.getText() + ".txt");
        byte[] data = output.getText().getBytes();
        out.write(data);
        out.close();
        state.setText(input.getText() + " has saved!");
    }

    /**
     * This is used to create a new file
     * It pops up a new box where you write the file name and press 'done' and the file is created
     * @param actionEvent
     */
    @FXML
    protected void createFile(ActionEvent actionEvent) {
        CreationBox.display(state);
    }
}
