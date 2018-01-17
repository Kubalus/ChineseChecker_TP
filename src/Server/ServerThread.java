package Server;

import java.io.*;
import java.net.Socket;

public class ServerThread extends Thread
{
    protected Socket socket;
    private Server server;
    private DataInputStream dataIn;
    private DataOutputStream dataOut;
    private String messageIn = "";
    private Room room;

    public ServerThread(Socket clientSocket, Server server)
    {
        // Setup socket
        this.socket = clientSocket;
        this.server = server;
        System.out.println("ServerThread: New client thread created");
    }

    public void run()
    {
        try
        {
             // Initialize input and Output streams
             dataIn = new DataInputStream(socket.getInputStream());
             dataOut = new DataOutputStream(socket.getOutputStream());
             System.out.println("ServerThread: Intput and Output streams established");

             while (!messageIn.equals("END"))
             {
                 // Read input data and print it on console
                 messageIn = dataIn.readUTF();
                 System.out.println("ServerThread: recived "+'\"'+messageIn+'\"');
                 messageControll(messageIn);
             }
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
            return;
        }
    }

    public void sendMessage(String message)
    {
        try
        {
            dataOut.writeUTF(message);
            dataOut.flush();
            System.out.println("ServerThread: message "+'\"'+message+'\"'+" has been send");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    // I-ini <number of players>, M-move <X-coordinate-from> <Y-coordinate-from> <X-coordinate-to> <Y-coordinate-to>,
    private void messageControll(String message)
    {
        String split[] = message.split(" ");

        if(split[0].equals("I"))
        {
            room = server.addToRoom(this, Integer.parseInt(split[1]));
        }
        else if(split[0].equals("M"))
        {
            room.sendToPlayers(message, Integer.parseInt(split[5]));
            room.getPlayers().get((Integer.parseInt(split[5]) + 1)%room.limit).sendMessage("S");
        }
    }
}
