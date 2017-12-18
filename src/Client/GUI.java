package Client;

import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.image.Image;

/*
 * TODO: Add left side of game containing board and pawns
 *
 * TODO: Add tests for whole GUI class
 */

public class GUI extends Application
{
    // Temporary data until we'll be able to pass all back-end properties
    int playerPoints[] = {0, 0, 0, 0, 0, 0};
    GUIEventHandler handler;

    // GUI data
    Button endTurnB;
    MenuBar mainMenuBar;
    AnchorPane root, lSide ,rSide;
    SplitPane vSplit;
    MenuItem rulesM, versionM, authorsM, newGameM, saveM, exitM;
    Text red, blue, green, yellow, black, white;
    Stage primaryStage;

    @Override
    public void start(Stage primaryStage)
    {
        handler = new GUIEventHandler(this);

        this.primaryStage = primaryStage;
        primaryStage.setTitle("Chinese Checkers");
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
        gameMenu.getItems().add(newGameM = new MenuItem("New Game"));
        newGameM.setOnAction(handler);
        gameMenu.getItems().add(saveM = new MenuItem("Save"));
        saveM.setOnAction(handler);
        gameMenu.getItems().add(exitM = new MenuItem("Exit"));
        exitM.setOnAction(handler);

        // Creating Game Menu
        Menu helpMenu = new Menu("Help");
        helpMenu.getItems().add(rulesM = new MenuItem("Rules"));
        rulesM.setOnAction(handler);
        helpMenu.getItems().add(versionM = new MenuItem("Version"));
        versionM.setOnAction(handler);
        helpMenu.getItems().add(authorsM = new MenuItem("Authors"));
        authorsM.setOnAction(handler);

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
        endTurnB = new Button("END TURN");
        endTurnB.setOnAction(handler);
        endTurnB.setMinSize(100, 50);
        AnchorPane.setTopAnchor(endTurnB, 10d);
        AnchorPane.setLeftAnchor(endTurnB, 10d);
        AnchorPane.setRightAnchor(endTurnB, 10d);

        // Scoreboard
        red = new Text("RED: " + playerPoints[0]);
             AnchorPane.setTopAnchor(red, 100d);
             AnchorPane.setLeftAnchor(red, 10d);
             AnchorPane.setRightAnchor(red, 10d);
        rSide.getChildren().add(red);

        blue = new Text("BLUE: " + playerPoints[1]);
             AnchorPane.setTopAnchor(blue, 120d);
             AnchorPane.setLeftAnchor(blue, 10d);
             AnchorPane.setRightAnchor(blue, 10d);
        rSide.getChildren().add(blue);

        green = new Text("GREEN: " + playerPoints[2]);
             AnchorPane.setTopAnchor(green, 140d);
             AnchorPane.setLeftAnchor(green, 10d);
             AnchorPane.setRightAnchor(green, 10d);
        rSide.getChildren().add(green);

        yellow = new Text("YELLOW: " + playerPoints[3]);
             AnchorPane.setTopAnchor(yellow, 160d);
             AnchorPane.setLeftAnchor(yellow, 10d);
             AnchorPane.setRightAnchor(yellow, 10d);
        rSide.getChildren().add(yellow);

        black = new Text("BLACK: " + playerPoints[4]);
            AnchorPane.setTopAnchor(black, 180d);
            AnchorPane.setLeftAnchor(black, 10d);
            AnchorPane.setRightAnchor(black, 10d);
        rSide.getChildren().add(black);

        white = new Text("WHITE: " + playerPoints[5]);
            AnchorPane.setTopAnchor(white, 200d);
            AnchorPane.setLeftAnchor(white, 10d);
            AnchorPane.setRightAnchor(white, 10d);
        rSide.getChildren().add(white);

        rSide.getChildren().add(endTurnB);


        AnchorPane.setTopAnchor(rSide, 0d);
        AnchorPane.setLeftAnchor(rSide, 0d);
        AnchorPane.setRightAnchor(rSide, 0d);
        AnchorPane.setBottomAnchor(rSide, 0d);
    }

    // Method that updates GUI data like points or last events
    protected void updateGUI()
    {
        // Update scoreboard
        red.setText("RED: "+playerPoints[0]);
        blue.setText("BLUE: "+playerPoints[1]);
        green.setText("GREEN: "+playerPoints[2]);
        yellow.setText("YELLOW: "+playerPoints[3]);
        black.setText("BLACK: "+playerPoints[4]);
        white.setText("WHITE: "+playerPoints[5]);
    }
/*
    @Override
    public void handle(ActionEvent e)
    {
        if(e.getSource() == endTurnB) // Handle end turn button
        {
            // Temporary handler testing updateGUI function
            for(int i = 0; i<=5; i++) playerPoints[i]++;
            updateGUI();
        }
        else if (e.getSource() == authorsM) // Creating popup window for authors option from menu
        {
            // Add authors stage, icon, title, owner and make it act like popup
            Stage authorsDialog = new Stage();
            authorsDialog.getIcons().add(new Image(getClass().getResourceAsStream("icon.jpg")));
            authorsDialog.setTitle("Authors");
            authorsDialog.initModality(Modality.APPLICATION_MODAL);
            authorsDialog.initOwner(primaryStage);

            // Adding content
            VBox authorsVbox = new VBox(10);
            authorsVbox.setAlignment(Pos.CENTER);
            authorsVbox.getChildren().add(new Text("<< AUTHORS >>"));
            authorsVbox.getChildren().add(new Text("Kuba Bryniarski"));
            authorsVbox.getChildren().add(new Text("Piotr Zaraś"));

            // Finalizing
            Scene authorsScene = new Scene(authorsVbox, 300, 100);
            authorsDialog.setScene(authorsScene);
            authorsDialog.show();
        }
        else if (e.getSource() == rulesM) //
        {
            // Add rules stage, icon, title, owner and make it act like popup
            Stage rulesDialog = new Stage();
            rulesDialog.getIcons().add(new Image(getClass().getResourceAsStream("icon.jpg")));
            rulesDialog.setTitle("Rules");
            rulesDialog.initModality(Modality.APPLICATION_MODAL);
            rulesDialog.initOwner(primaryStage);

            // Adding content
            VBox rulesVbox = new VBox(10);
            rulesVbox.setAlignment(Pos.TOP_CENTER);
            // For now rules are just copy paste from wikipedia
            rulesVbox.getChildren().add(new Text("<< RULES >>"));
            rulesVbox.getChildren().add(new Text("The aim is to race all one's pieces into the star corner on the\n" +
                    "opposite side of the board before opponents do the same. The destination corner is called home.\n" +
                    " Each player has 10 pieces, except in games between two players when 15 are used.\n"));
            rulesVbox.getChildren().add(new Text("In \"hop across\", the most popular variation, each player starts\n" +
                    " with their colored pieces on one of the six points or corners of the star and attempts to race\n" +
                    " them all home into the opposite corner. Players take turns moving a single piece, either by\n" +
                    " moving one step in any direction to an adjacent empty space, or by jumping in one or any number\n" +
                    " of available consecutive hops over other single pieces. A player may not combine hopping with a\n" +
                    " single-step move – a move consists of one or the other. There is no capturing in Chinese Checkers,\n" +
                    " so hopped pieces remain active and in play. Turns proceed clockwise around the board.\n"));

            // Finalizing
            Scene rulesScene = new Scene(rulesVbox, 600, 250);
            rulesDialog.setScene(rulesScene);
            rulesDialog.show();
        }
    }*/
}
