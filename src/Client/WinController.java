package Client;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class WinController
{
    @FXML Label placeLabel;

    public void ini(int place)
    {
        placeLabel.setText("# "+place);
    }
}
