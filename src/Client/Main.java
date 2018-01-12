package Client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Main extends Application
{
    Parent root;
    Controller gui;

    public static void main(String[] args)
    {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception
    {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/GUI.fxml"));
        root = fxmlLoader.load();

        gui = fxmlLoader.getController();

        primaryStage.setTitle("Chinese Checkers");
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("icon.jpg")));
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public Controller getController()
    {
        return gui;
    }

    /*
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        root = FXMLLoader.load(getClass().getResource("GUI.fxml"));
        primaryStage.setTitle("Chinese Checkers");
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("icon.jpg")));
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    */
}
