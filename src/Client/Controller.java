package Client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable
{
    Game game;
    Client client;
    List<Circle> pawnsGUI = new ArrayList();

    @FXML MenuItem twoPlayers;
    @FXML MenuItem threePlayers;
    @FXML MenuItem fourPlayers;
    @FXML MenuItem sixPlayers;
    @FXML MenuItem startGame;

    @FXML GridPane boardGrid;
    @FXML MenuItem exitMI;
    @FXML Button endTurnB;
    @FXML Label redPoints, bluePoints, greenPoints, yellowPoints, blackPoints, whitePoints;


    @Override // Initializer for our GUI Controller
    public void initialize(URL location, ResourceBundle resources)
    {
        connectToServer();
        boardGrid.setAlignment(Pos.CENTER);
    }

    public void connectToServer()
    {
        client = new Client();
        client.start();
    }

    // Refreshing board
    private void refresh()
    {
        boardGrid.getChildren().clear();

        for(int i = 0; i <= 18; i++)
        {
            for(int j = 0; j <= 14; j++)
            {
                if(game.getBoard().getField(i, j).getClass() == AccessibleField.class)
                {
                    if(i % 2 == 1)
                    {
                        boardFill(i, j, false);
                    }
                    else
                    {
                        boardFill(i, j, true);
                    }
                }
                else if(game.getBoard().getField(i, j).getClass() == WinningField.class)
                {
                    if(i % 2 == 1)
                    {
                        boardFill(i, j, false);
                    }
                    else
                    {
                        boardFill(i, j, true);
                    }
                }
            }
        }

        fillPawns();
    }

    // Filling board with proper colored pawns and fields
    private void boardFill(int i, int j, boolean shifted)
    {
        Polygon poly = new Polygon(27*(1), 27*(0),
                27*(0.5), 27*(0.86602540378),
                27*(-0.5), 27*(0.86602540378),
                27*(-1), 27*(0),
                27*(-0.5), 27*(-0.86602540378),
                27*(0.5), 27*(-0.86602540378));
        if(shifted)
        {
            poly.translateYProperty().set(-23);
        }

        if(game.getBoard().getField(i, j).getClass() == WinningField.class)
        {
            for(int var = 0; var < game.getPlayers().length; var++)
            {
                if(game.getBoard().getField(i, j).getOwner().equals(game.getPlayers()[var]))
                {
                    switch (var) {
                        case 0:
                            poly.setFill(Paint.valueOf("RED"));
                            break;
                        case 1:
                            poly.setFill(Paint.valueOf("BLUE"));
                            break;
                        case 2:
                            poly.setFill(Paint.valueOf("GREEN"));
                            break;
                        case 3:
                            poly.setFill(Paint.valueOf("YELLOW"));
                            break;
                        case 4:
                            poly.setFill(Paint.valueOf("#4f4f4f"));
                            break;
                        case 5:
                            poly.setFill(Paint.valueOf("WHITE"));
                            break;
                    }
                }
            }
        }
        else
        {
            poly.setFill(Paint.valueOf("#d6d6d6"));
        }

        poly.setStroke(Paint.valueOf("BLACK"));
        boardGrid.add(poly, i, j);
    }

    private void fillPawns()
    {
        for(int i = 0; i < game.getPlayers().length ; i++)
        {
            for(int j = 0; j < 10; j++)
            {
                int x = game.getPlayers()[i].getPawns().get(j).getCoordinateX();
                int y = game.getPlayers()[i].getPawns().get(j).getCoordinateY();

                Circle circle = new Circle(15);
                if(x % 2 != 1)
                {
                    circle.translateYProperty().set(-23);
                }
                circle.translateXProperty().set(14);
                pawnsGUI.add(circle);
                circle.setOnMouseClicked(event -> pawnClicked(circle));

                switch (i) {
                    case 0:
                        circle.setFill(Paint.valueOf("RED"));
                        break;
                    case 1:
                        circle.setFill(Paint.valueOf("BLUE"));
                        break;
                    case 2:
                        circle.setFill(Paint.valueOf("GREEN"));
                        break;
                    case 3:
                        circle.setFill(Paint.valueOf("YELLOW"));
                        break;
                    case 4:
                        circle.setFill(Paint.valueOf("BLACK"));
                        break;
                    case 5:
                        circle.setFill(Paint.valueOf("WHITE"));
                        break;
                }
                circle.setStroke(Paint.valueOf("BLACK"));
                boardGrid.add(circle, x, y);
            }
        }
    }

    // Probably will have to add coordinates to arguments
    private void pawnClicked(Circle circle)
    {
        // Clear effects for other pawns
        for(int i = 0; i < pawnsGUI.size(); i++)
        {
            pawnsGUI.get(i).setEffect(null);
        }

        // Set effect for this pawn
        //DropShadow shadow = new DropShadow();
        //shadow.colorProperty().set(Color.valueOf("BLACK"));
        Lighting lighting = new Lighting();
        circle.setEffect(lighting);
    }

    @FXML
    public void newGame(ActionEvent e)
    {
        GameDirector director = new GameDirector();
        GameBuilder builder;

        if(e.getSource().equals(twoPlayers))
        {
            builder = new CCBoard2P();
            client.sendMessage("I 2");
        }
        else if(e.getSource().equals(threePlayers))
        {
            builder = new CCBoard3P();
            client.sendMessage("I 3");
        }
        else if(e.getSource().equals(fourPlayers))
        {
            builder = new CCBoard4P();
            client.sendMessage("I 4");
        }
        else
        {
            builder = new CCBoard6P();
            client.sendMessage("I 6");
        }

        director.setBuilder(builder);
        director.createGame();
        game = builder.setupGame();

        startGame.setDisable(true);

        refresh();
    }

    @FXML // EXIT menu item handler (exits game)
    public void exitHandler()
    {
        if(client.isAlive())
        {
            client.sendMessage("END");
        }
        System.exit(0);
    }

    @FXML // END TURN button handler (increments all score values)
    public void endTurn()
    {
        System.out.println("Turn passed... \n");

        if(!boardGrid.getChildren().isEmpty())
        {
            refresh();
        }
    }

    @FXML // RULES manu item handler (creates dialog window with rules)
    public void rulesHandler()
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/Rules.fxml"));
        Parent root = null;
        try
        {
            root = fxmlLoader.load();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        Stage rulesDialog = new Stage();
        rulesDialog.setTitle("Rules");
        rulesDialog.getIcons().add(new Image(getClass().getResourceAsStream("icon.jpg")));
        rulesDialog.initModality(Modality.APPLICATION_MODAL);
        rulesDialog.setScene(new Scene(root));
        rulesDialog.setResizable(false);
        rulesDialog.show();
    }

    @FXML // AUTHOR manu item handler (creates dialog window with authors)
    public void authorsHandler()
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/Authors.fxml"));
        Parent root = null;
        try
        {
            root = fxmlLoader.load();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        Stage authorsDialog = new Stage();
        authorsDialog.setTitle("Authors");
        authorsDialog.getIcons().add(new Image(getClass().getResourceAsStream("icon.jpg")));
        authorsDialog.initModality(Modality.APPLICATION_MODAL);
        authorsDialog.setScene(new Scene(root));
        authorsDialog.setResizable(false);
        authorsDialog.show();
    }
}
