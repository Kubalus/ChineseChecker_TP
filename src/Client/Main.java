package Client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/*
 * TODO: move client startup to Controller.java (if can be done)
 */

public class Main extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("GUI.fxml"));
        primaryStage.setTitle("Chinese Checkers");
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("icon.jpg")));
        primaryStage.setScene(new Scene(root, 995,710));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
