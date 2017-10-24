package tileno.fileEditor;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

/**
 * Created by sirshadow on 10/24/17.
 */
public class CreationBox {

    public static void display(){
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Create new file");
        stage.setMinWidth(350);

        TextField field = new TextField();

        Button button = new Button("Done");
        button.setOnAction(event -> {
            File f = new File(field.getText() + ".data");
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

            stage.close();
        });

        VBox box = new VBox(15);
        box.getChildren().addAll(field,button);
        box.setAlignment(Pos.CENTER);

        Scene scene = new Scene(box);
        stage.setScene(scene);
        stage.show();
    }

}
