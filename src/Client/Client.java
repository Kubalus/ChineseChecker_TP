package Client;

import java.io.*;
import java.net.*;

public class Client extends Thread
{
    private final int PORT = 1201;
    private Socket socket;
    private DataInputStream dataIn;
    private DataOutputStream dataOut;
    private String messageIn="";
    private int playerNum;
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
        if(temp[0].equals("I"))
        {
            playerNum = Integer.parseInt(temp[1]);
            controller.unlock(Integer.parseInt(temp[1]));
        }
    }
}
