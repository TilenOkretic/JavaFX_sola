package tileno.fileEditor;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Created by sirshadow on 10/24/17.
 */
public class AlertBox {
    /**
     * Used to create basic alert boxes!
     * @param title of the alert box
     * @param message to display
     */
    static void display(String title,String message){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);

        Label label = new Label();
        label.setText(message);
        Button button = new Button("OK");
        button.setOnAction(e -> window.close());

        VBox box = new VBox(20);
        box.getChildren().addAll(label,button);
        box.setAlignment(Pos.BOTTOM_CENTER);

        Scene scene = new Scene(box);
        window.setScene(scene);
        window.show();
    }
}