package tileno.fileEditor;

import com.sun.istack.internal.Nullable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by sirshadow on 10/24/17.
 */
public class CreationBox {

    /**
     * Use this to create a new window that can be used to create files
     * @param state is used for setting print out messages
     */
    static void display(@Nullable Label state){
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Create new file");
        stage.setMinWidth(350);

        TextField field = new TextField();
        Label label = new Label();
        label.setText("File name:");

        Button button = new Button("Done");
        button.setOnAction(event -> {
            File f = new File(Main.PATH +  field.getText() + ".txt");
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (state != null) state.setText(field.getText() + " has been created!");
            stage.close();
        });

        VBox box = new VBox(15);
        box.getChildren().addAll(label,field,button);
        box.setAlignment(Pos.CENTER);

        Scene scene = new Scene(box);
        stage.setScene(scene);
        stage.show();
    }
}
