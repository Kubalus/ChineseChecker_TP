package Client;

import javafx.application.Application;

/*
 * TODO: GUI seems to block client from running and vice versa (needs fixing)
 */
public class Main
{
    public static void main(String[] args)
    {
        Application.launch(GUI.class, args);
        Client client = new Client();
    }
}
