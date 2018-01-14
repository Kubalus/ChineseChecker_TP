package Client;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable
{

    Client client;
    Board gameBoard;
    GameDirector director;
    GameBuilder builder;

    @FXML GridPane boardGrid;
    @FXML MenuItem exitMI;
    @FXML Button endTurnB;
    @FXML Label redPoints, bluePoints, greenPoints, yellowPoints, blackPoints, whitePoints;


    @Override // Initializer for our GUI Controller
    public void initialize(URL location, ResourceBundle resources)
    {
        this.client = new Client();
        boardGrid.setAlignment(Pos.CENTER);
    }

    @FXML
    public void newGame()
    {
        director = new GameDirector();
        builder = new CCBoard6P();
        director.setBuilder(builder);
        director.createGame();
        gameBoard = director.getBoard();

        refresh();
    }

    // Refreshing board
    private void refresh()
    {
        boardGrid.getChildren().clear();

        for(int i = 0; i <= 18; i++)
        {
            for(int j = 0; j <= 14; j++)
            {
                if(gameBoard.getField(i, j).getClass() == AccessibleField.class)
                {
                    if(i % 2 == 1)
                    {
                        boardFill(i, j, false);
                        /*Polygon poly = new Polygon(27*(1), 27*(0),
                                27*(0.5), 27*(0.86602540378),
                                27*(-0.5), 27*(0.86602540378),
                                27*(-1), 27*(0),
                                27*(-0.5), 27*(-0.86602540378),
                                27*(0.5), 27*(-0.86602540378));

                        poly.setFill(Paint.valueOf("GREY"));
                        poly.setStroke(Paint.valueOf("BLACK"));
                        boardGrid.add(poly, i, j);

                        if(gameBoard.getField(i, j).pawn != null)
                        {
                            Circle circle = new Circle(15);
                            circle.translateXProperty().set(14);
                            boardGrid.add(circle, i, j);
                        }*/

                    }
                    else
                    {
                        boardFill(i, j, true);
                       /* Polygon poly = new Polygon(27*(1), 27*(0),
                                27*(0.5), 27*(0.86602540378),
                                27*(-0.5), 27*(0.86602540378),
                                27*(-1), 27*(0),
                                27*(-0.5), 27*(-0.86602540378),
                                27*(0.5), 27*(-0.86602540378));
                        poly.translateYProperty().set(-23);
                        poly.setFill(Paint.valueOf("GREY"));
                        poly.setStroke(Paint.valueOf("BLACK"));
                        boardGrid.add(poly, i, j);

                        if(gameBoard.getField(i, j).pawn != null)
                        {
                            Circle circle = new Circle(15);
                            circle.translateYProperty().set(-23);
                            circle.translateXProperty().set(14);
                            boardGrid.add(circle, i, j);
                        }*/
                    }
                }
                else if(gameBoard.getField(i, j).getClass() == WinningField.class)
                {
                    if(i % 2 == 1)
                    {
                        boardFill(i, j, false);
                        /*Polygon poly = new Polygon(27*(1), 27*(0),
                                27*(0.5), 27*(0.86602540378),
                                27*(-0.5), 27*(0.86602540378),
                                27*(-1), 27*(0),
                                27*(-0.5), 27*(-0.86602540378),
                                27*(0.5), 27*(-0.86602540378));

                        poly.setFill(Paint.valueOf("WHITE"));
                        poly.setStroke(Paint.valueOf("BLACK"));
                        boardGrid.add(poly, i, j);

                        if(gameBoard.getField(i, j).pawn != null)
                        {
                            Circle circle = new Circle(15);
                            circle.translateXProperty().set(14);
                            boardGrid.add(circle, i, j);
                        }*/
                    }
                    else
                    {
                        boardFill(i, j, true);
                       /* Polygon poly = new Polygon(27*(1), 27*(0),
                                27*(0.5), 27*(0.86602540378),
                                27*(-0.5), 27*(0.86602540378),
                                27*(-1), 27*(0),
                                27*(-0.5), 27*(-0.86602540378),
                                27*(0.5), 27*(-0.86602540378));
                        poly.translateYProperty().set(-23);
                        poly.setFill(Paint.valueOf("WHITE"));
                        poly.setStroke(Paint.valueOf("BLACK"));
                        boardGrid.add(poly, i, j);

                        if(gameBoard.getField(i, j).pawn != null)
                        {
                            Circle circle = new Circle(15);
                            circle.translateYProperty().set(-23);
                            circle.translateXProperty().set(14);
                            for(int var = 0; var <= 6; var++)
                            {
                                if (gameBoard.getField(i, j).pawn.owner.equals(builder.players[var]))
                                {
                                    switch (var){
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
                                }
                            }

                            circle.setStroke(Paint.valueOf("BLACK"));
                            boardGrid.add(circle, i, j);
                        }*/
                    }
                }
            }
        }
    }

    // Filling board with proper collored pawns and fields
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

        /*if(gameBoard.getField(i, j).getClass() == WinningField.class)
        {
            for(int var = 0; var < 6; var++)
            {
                if(gameBoard.getField(i, j).getOwner().equals(builder.players[var]))
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
                            poly.setFill(Paint.valueOf("BLACK"));
                            break;
                        case 5:
                            poly.setFill(Paint.valueOf("WHITE"));
                            break;
                    }
                }
            }
        }
        else
        {*/
            poly.setFill(Paint.valueOf("#d6d6d6"));
        //}

        poly.setStroke(Paint.valueOf("BLACK"));
        boardGrid.add(poly, i, j);

        if(gameBoard.getField(i, j).getPawn()!= null)
        {
            Circle circle = new Circle(15);
            if(shifted)
            {
                circle.translateYProperty().set(-23);
            }
            circle.translateXProperty().set(14);
            for(int var = 0; var < 6; var++)
            {
                //if (gameBoard.getField(i, j).pawn.owner.equals(builder.players[var])
                if (gameBoard.getField(i, j).getPawn().getOwner().equals(builder.players[var])) {
                    switch (var) {
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
                }
            }

            circle.setStroke(Paint.valueOf("BLACK"));
            boardGrid.add(circle, i, j);
        }
    }

    @FXML // EXIT menu item handler (exits game)
    public void exitHandler()
    {
        System.exit(0);
    }

    @FXML // END TURN button handler (increments all score values)
    public void endTurn()
    {
        System.out.println("Turn passed... \n -- Incrementing point values");
        redPoints.setText(""+(Integer.parseInt(redPoints.getText())+1));
        bluePoints.setText(""+(Integer.parseInt(bluePoints.getText())+1));
        greenPoints.setText(""+(Integer.parseInt(greenPoints.getText())+1));
        yellowPoints.setText(""+(Integer.parseInt(yellowPoints.getText())+1));
        blackPoints.setText(""+(Integer.parseInt(blackPoints.getText())+1));
        whitePoints.setText(""+(Integer.parseInt(whitePoints.getText())+1));

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
