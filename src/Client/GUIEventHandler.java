package Client;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class GUIEventHandler  implements EventHandler<ActionEvent> {

    GUI gui;

    GUIEventHandler(GUI gui)
    {
        this.gui = gui;
    }

    @Override
    public void handle(ActionEvent e)
    {
        if(e.getSource() == gui.endTurnB) // Handle end turn button
        {
            // Temporary handler testing updateGUI function
            for(int i = 0; i<=5; i++) gui.playerPoints[i]++;
            gui.updateGUI();
        }
        else if (e.getSource() == gui.authorsM) // Creating popup window for authors option from menu
        {
            // Add authors stage, icon, title, owner and make it act like popup
            Stage authorsDialog = new Stage();
            authorsDialog.getIcons().add(new Image(getClass().getResourceAsStream("icon.jpg")));
            authorsDialog.setTitle("Authors");
            authorsDialog.initModality(Modality.APPLICATION_MODAL);
            authorsDialog.initOwner(gui.primaryStage);

            // Adding content
            VBox authorsVbox = new VBox(10);
            authorsVbox.setAlignment(Pos.TOP_CENTER);
            authorsVbox.getChildren().add(new Text("<< AUTHORS >>"));
            authorsVbox.getChildren().add(new Text("Kuba Bryniarski"));
            authorsVbox.getChildren().add(new Text("Piotr Zaraś"));

            // Finalizing
            Scene authorsScene = new Scene(authorsVbox, 300, 80);
            authorsDialog.setScene(authorsScene);
            authorsDialog.show();
        }
        else if (e.getSource() == gui.rulesM) // Creating popup window for rules option from menu
        {
            // Add rules stage, icon, title, owner and make it act like popup
            Stage rulesDialog = new Stage();
            rulesDialog.getIcons().add(new Image(getClass().getResourceAsStream("icon.jpg")));
            rulesDialog.setTitle("Rules");
            rulesDialog.initModality(Modality.APPLICATION_MODAL);
            rulesDialog.initOwner(gui.primaryStage);

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
        else if (e.getSource() == gui.versionM) // Creating popup window for version option from menu
        {
            // Add version stage, icon, title, owner and make it act like popup
            Stage versionDialog = new Stage();
            versionDialog.getIcons().add(new Image(getClass().getResourceAsStream("icon.jpg")));
            versionDialog.setTitle("version");
            versionDialog.initModality(Modality.APPLICATION_MODAL);
            versionDialog.initOwner(gui.primaryStage);

            // Adding content
            VBox versionVbox = new VBox(10);
            versionVbox.setAlignment(Pos.TOP_CENTER);
            versionVbox.getChildren().add(new Text("<< CURRENT VERSION >>"));
            versionVbox.getChildren().add(new Text("Alpha, before alpha, before alpha"));

            // Finalizing
            Scene versionScene = new Scene(versionVbox, 300, 50);
            versionDialog.setScene(versionScene);
            versionDialog.show();
        }
        else if (e.getSource() == gui.exitM) // Exiting for Exit option from menu
        {
            gui.primaryStage.close();
        }
    }
}
