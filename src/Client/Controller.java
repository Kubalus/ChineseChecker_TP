package Client;

import javafx.application.Platform;
import javafx.concurrent.*;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.Lighting;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
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

/*
 *  TODO: Finish implementing movement
 *  TODO: Write startTurn()
 */
public class Controller implements Initializable
{
    private Game game;
    private Client client;
    private List<Circle> pawnsGUI;
    private int playerNum = -1;
    private int currentX;
    private int currentY;
    ArrayList<Field> possibleMoves;

    @FXML MenuItem twoPlayers;
    @FXML MenuItem threePlayers;
    @FXML MenuItem fourPlayers;
    @FXML MenuItem sixPlayers;
    @FXML MenuItem startGame;

    @FXML AnchorPane mainPane;
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
        client = new Client(this);
        client.start();
    }


    public void highlight(ArrayList<Field> arr)
    {
        for(int i = 0; i < arr.size(); i++)
        {
            int x = arr.get(i).getCoordinateX();
            int y = arr.get(i).getCoordinateY();

            Circle temp = new Circle(10);

            if(x % 2 == 1)
            {
                temp.translateYProperty().set(-23);
            }

            temp.setFill(Paint.valueOf("#ff00ff"));
            temp.setEffect(new BoxBlur());

            boardGrid.add(temp, x, y);
        }
    }


    // Refreshing board
    private void refresh()
    {
        System.out.println("1");


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
        System.out.println("2");
        fillPawns();
        System.out.println("3");
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
        poly.setOnMouseClicked(e -> fieldClicked(i, j));
        if(game.getBoard().getField(i, j).getClass() == WinningField.class)
        {
            for(int var = 0; var < game.getPlayers().length; var++)
            {
                if(game.getBoard().getField(i, j).getOwner() != null){
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
        }
        else
        {
            poly.setFill(Paint.valueOf("#d6d6d6"));
        }

        poly.setStroke(Paint.valueOf("BLACK"));
        boardGrid.add(poly, i, j);
    }

    private void fieldClicked(int x, int y)
    {



        for(int i = 0; i < pawnsGUI.size(); i++)
        {
            if (pawnsGUI.get(i).getEffect() != null)
            {
                if(possibleMoves.contains(game.getBoard().getField(x,y))) {
                    movePawn(currentX, currentY, x, y);
                    client.sendMessage("M " + currentX + " " + currentY + " " + x + " " + y + " " + playerNum);
                    endTurn();
                }
            }
        }
    }

    private void fillPawns()
    {
        pawnsGUI = new ArrayList();
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
                circle.setOnMouseClicked(event -> pawnClicked(circle, x, y));

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

    private void pawnClicked(Circle circle, int x, int y)
    {

        if(game.getBoard().getField(x, y).getPawn().getOwner().equals(game.getPlayers()[playerNum]))
        {
            // Clear effects for other pawns
            refresh();
            for(int i = 0; i < pawnsGUI.size(); i++)
            {
                pawnsGUI.get(i).setEffect(null);
            }
            currentX = x;
            currentY = y;

            // Set effect for this pawn
            Lighting lighting = new Lighting();
            circle.setEffect(lighting);
            possibleMoves = game.getMovingRule().possibleMoves(
                    game.getBoard().getField(currentX, currentY).getPawn(), game);
            highlight(possibleMoves);
        }
    }

    public void startTurn()
    {
        mainPane.setDisable(false);
    }

    public void setPlayerNum(int playerNum)
    {
        this.playerNum = playerNum;
    }

    public void movePawn(int x1, int y1, int x2, int y2)
    {
        try
        {
            game.getMovingRule().movePawn(game.getBoard().getField(x1, y1).getPawn(), game.getBoard().getField(x2, y2), game);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        refresh();
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
        mainPane.setDisable(true);

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
            mainPane.setDisable(true);
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
