package Client;

import javafx.application.Platform;

import java.io.*;
import java.net.*;

public class Client extends Thread
{
    private final int PORT = 1201;
    private Socket socket;
    private DataInputStream dataIn;
    private DataOutputStream dataOut;
    private String messageIn="";
    private Controller controller;

    Client(Controller controller)
    {
        this.controller = controller;
        try
        {
            System.out.println("Client: Creating client");
            // Set client on server
            socket = new Socket("127.0.0.1", PORT);
            System.out.println("Client: Conected to a server");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void run()
    {
        try
        {
            // Initialize Input and Output streams
            dataIn = new DataInputStream(socket.getInputStream());
            dataOut = new DataOutputStream(socket.getOutputStream());
            System.out.println("Client: input and output streams established");

            while(!messageIn.equals("END"))
            {
                // Receive data and print it on console
                messageIn = dataIn.readUTF();
                System.out.println("Recived message: "+messageIn);
                getMessage(messageIn);
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public void sendMessage(String message)
    {
        try
        {
            dataOut.writeUTF(message);
            System.out.println("Client: message " + '\"' + message + '\"' + " has been send");
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    private void getMessage(String message)
    {
        String temp[] = message.split(" ");
        if(controller.win)
        {
            sendMessage("P "+controller.playerNum);
        }
        else if(temp[0].equals("I")) // For initializing
        {
            controller.setPlayerNum(Integer.parseInt(temp[1]));
        }
        else if(temp[0].equals("S")) // For starting turn
        {
            controller.startTurn();
        }
        else if(temp[0].equals("M")) // For other players movement
        {
            Platform.runLater(() -> {
                controller.movePawn(Integer.parseInt(temp[1]), Integer.parseInt(temp[2]), Integer.parseInt(temp[3]), Integer.parseInt(temp[4]));
            });
        }
    }
}
