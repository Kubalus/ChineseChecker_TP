package Server;

import java.io.*;
import java.net.Socket;

public class ServerThread extends Thread
{
    protected Socket socket;
    DataInputStream dataIn;
    DataOutputStream dataOut;
    String messageIn = "", messageOut = "";

    public ServerThread(Socket clientSocket)
    {
        // Setup socket
        this.socket = clientSocket;
    }

    public void run()
    {
        try
        {
             // Initialize input and Output streams
             dataIn = new DataInputStream(socket.getInputStream());
             dataOut = new DataOutputStream(socket.getOutputStream());

             while (!messageIn.equals("END"))
             {
                     // Read input data and print it on console
                     messageIn = dataIn.readUTF();
                     System.out.println(messageIn);

                     // Send data to client and flush rubbish
                     dataOut.writeUTF(messageOut);
                     dataOut.flush();

             }
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
            return;
        }
    }
}
