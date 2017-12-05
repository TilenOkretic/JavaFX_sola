package tileno.fileEditor;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.FileInputStream;

public class Main extends Application {

    static final String TITLE = "File Editor";
    private static final int WIDTH = 600,HEIGHT = 475;
    static final String PATH = Main.class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("File_Editor.jar","");
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("fileEditor.fxml"));
        primaryStage.setTitle(TITLE);
        Scene scene = new Scene(root, WIDTH,HEIGHT);
        primaryStage.setResizable(false);

        primaryStage.getIcons().add(new Image(new FileInputStream("res/icon.png")));

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
