package Client;

import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;

/*
 * TODO: Add left side of game containing board and pawns
 * TODO: Add event handlers for menu items and button
 * TODO: Add tests for whole GUI class
 */

public class GUI extends Application
{

    Button testButton;
    MenuBar mainMenuBar;
    AnchorPane root, lSide ,rSide;
    SplitPane vSplit;

    @Override
    public void start(Stage primaryStage)
    {
        primaryStage.setTitle("Chinese Checkers (beta)");
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("icon.jpg")));

        // Setting up the main scene
        root = new AnchorPane();
        Scene mainScene = new Scene(root, 1080, 720);
        primaryStage.setScene(mainScene);
        primaryStage.setResizable(false);

        // Creating all needed panels
        lSide = new AnchorPane();

        // Creating menu bar
        createMenu();

        // Creating right side of window
        createRightSide();

        // Vertical split setup (lSide | rSide)
        vSplit = new SplitPane();
        vSplit.setOrientation(Orientation.HORIZONTAL);
        vSplit.getItems().addAll(lSide, rSide);
        vSplit.setDividerPositions(0.75);

        // Setting up root panel with the main vertical split
        root.getChildren().add(vSplit);
        SplitPane.setResizableWithParent(vSplit, Boolean.FALSE);
        AnchorPane.setTopAnchor(vSplit, 25d);
        AnchorPane.setLeftAnchor(vSplit, 0d);
        AnchorPane.setRightAnchor(vSplit, 0d);
        AnchorPane.setBottomAnchor(vSplit, 0d);

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

    private void createRightSide()
    {
        rSide = new AnchorPane();

        // End turn button
        testButton = new Button("END TURN");
        testButton.setMinSize(100, 50);
        AnchorPane.setTopAnchor(testButton, 10d);
        AnchorPane.setLeftAnchor(testButton, 10d);
        AnchorPane.setRightAnchor(testButton, 10d);

        rSide.getChildren().add(testButton);

        AnchorPane.setTopAnchor(rSide, 0d);
        AnchorPane.setLeftAnchor(rSide, 0d);
        AnchorPane.setRightAnchor(rSide, 0d);
        AnchorPane.setBottomAnchor(rSide, 0d);
    }
}
