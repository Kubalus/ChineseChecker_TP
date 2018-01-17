package Client;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.paint.Paint;


public class ColorPopupController
{
    @FXML
    Label colorLabel;

    public void setColor(int x)
    {
        switch(x) {
            case 0:
                colorLabel.setText("RED");
                colorLabel.setTextFill(Paint.valueOf("RED"));
                break;
            case 1:
                colorLabel.setText("BLUE");
                colorLabel.setTextFill(Paint.valueOf("BLUE"));
                break;
            case 2:
                colorLabel.setText("GREEN");
                colorLabel.setTextFill(Paint.valueOf("GREEN"));
                break;
            case 3:
                colorLabel.setText("YELLOW");
                colorLabel.setTextFill(Paint.valueOf("YELLOW"));
                break;
            case 4:
                colorLabel.setText("BLACK");
                colorLabel.setTextFill(Paint.valueOf("BLACK"));
                break;
            case 5:
                colorLabel.setText("WHITE");
                colorLabel.setTextFill(Paint.valueOf("BLACK"));
                break;
        }
    }
}
