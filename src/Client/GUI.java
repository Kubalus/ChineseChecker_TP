package Client;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class GUI extends Application
{

    Button testButton;
    MenuBar mainMenuBar;
    AnchorPane root;

    @Override
    public void start(Stage primaryStage)
    {
        primaryStage.setTitle("Chinese Checkers (beta)");

        testButton = new Button("TESTING");


        root = new AnchorPane();


        createMenu();

        Scene mainScene = new Scene(root, 1080, 720);
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    private void createMenu()
    {
        // Creating Game Menu
        Menu gameMenu = new Menu("Game");
        gameMenu.getItems().add(new MenuItem("New Game"));
        gameMenu.getItems().add(new MenuItem("Save"));
        gameMenu.getItems().add(new MenuItem("Exit"));

        // Creating Game Menu
        Menu helpMenu = new Menu("Help");
        helpMenu.getItems().add(new MenuItem("Rules"));
        helpMenu.getItems().add(new MenuItem("Version"));
        helpMenu.getItems().add(new MenuItem("Creators"));

        // Creating menu bar and adding menus to it
        mainMenuBar = new MenuBar();
        mainMenuBar.getMenus().addAll(gameMenu, helpMenu);

        root.getChildren().add(mainMenuBar);
        AnchorPane.setTopAnchor(mainMenuBar, 0d);
        AnchorPane.setLeftAnchor(mainMenuBar, 0d);
        AnchorPane.setRightAnchor(mainMenuBar, 0d);
    }
}
