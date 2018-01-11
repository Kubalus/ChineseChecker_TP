package Client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable
{

    Client client;
    Board gameBoard;

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
    private void newGame()
    {
        GameDirector director = new GameDirector();
        GameBuilder builder = new CCBoard6P();
        director.setBuilder(builder);
        director.createGame();
        gameBoard = director.getBoard();

        refreash();
    }

    // Refreashing board TODO: delete earlier stuff before deleting
    private void refreash()
    {
        for(int i = 0; i <= 18; i++)
        {
            for(int j = 0; j <= 14; j++)
            {
                if(gameBoard.getField(i, j).getClass() == AccessibleField.class)
                {
                    if(i % 2 == 1)
                    {
                        Polygon poly = new Polygon(27*(1), 27*(0),
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
                        }

                    }
                    else
                    {
                        Polygon poly = new Polygon(27*(1), 27*(0),
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
                        }
                    }
                }
                else if(gameBoard.getField(i, j).getClass() == WinningField.class)
                {
                    if(i % 2 == 1)
                    {
                        Polygon poly = new Polygon(27*(1), 27*(0),
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
                        }
                    }
                    else
                    {
                        Polygon poly = new Polygon(27*(1), 27*(0),
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
                            boardGrid.add(circle, i, j);
                        }
                    }
                }
            }
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
        refreash();
    }

    @FXML // RULES manu item handler (creates dialog window with rules)
    public void rulesHandler()
    {
        // Add rules stage, icon, title, owner and make it act like popup
        Stage rulesDialog = new Stage();
        rulesDialog.getIcons().add(new Image(getClass().getResourceAsStream("icon.jpg")));
        rulesDialog.setTitle("Rules");
        rulesDialog.initModality(Modality.APPLICATION_MODAL);

        // Adding content
        VBox rulesVbox = new VBox(10);
        rulesVbox.setAlignment(Pos.TOP_CENTER);
        // For now rules are just copy paste from wikipedia
        rulesVbox.getChildren().add(new Label("<< RULES >>"));
        rulesVbox.getChildren().add(new Label("The aim is to race all one's pieces into the star corner on the\n" +
                "opposite side of the board before opponents do the same. The destination corner is called home.\n" +
                " Each player has 10 pieces, except in games between two players when 15 are used.\n"));
        rulesVbox.getChildren().add(new Label("In \"hop across\", the most popular variation, each player starts\n" +
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

    @FXML // AUTHOR manu item handler (creates dialog window with authors)
    public void authorsHandler()
    {
        // Add authors stage, icon, title, owner and make it act like popup
        Stage authorsDialog = new Stage();
        authorsDialog.getIcons().add(new Image(getClass().getResourceAsStream("icon.jpg")));
        authorsDialog.setTitle("Authors");
        authorsDialog.initModality(Modality.APPLICATION_MODAL);

        // Adding content
        VBox authorsVbox = new VBox(10);
        authorsVbox.setAlignment(Pos.TOP_CENTER);
        authorsVbox.getChildren().add(new Label("<< AUTHORS >>"));
        authorsVbox.getChildren().add(new Label("Kuba Bryniarski"));
        authorsVbox.getChildren().add(new Label("Piotr Zaraś"));

        // Finalizing
        Scene authorsScene = new Scene(authorsVbox, 300, 80);
        authorsDialog.setScene(authorsScene);
        authorsDialog.show();
    }


}
