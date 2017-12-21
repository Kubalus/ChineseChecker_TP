package Client;

import java.io.*;
import java.net.*;

public class Client
{
    static final int PORT = 1201;
    Socket socket;
    DataInputStream dataIn;
    DataOutputStream dataOut;
    String messageIn="", messageOut="";

    Client()
    {
        try
        {
            // Set client on server
            socket = new Socket("localhost", PORT);

            // Initialize Input and Output streams
            dataIn = new DataInputStream(socket.getInputStream());
            dataOut = new DataOutputStream(socket.getOutputStream());

            while(!messageIn.equals("END"))
            {
                // Send data
                dataOut.writeUTF(messageOut);

                // Receive data and print it on console
                messageIn = dataIn.readUTF();
                System.out.println(messageIn);
            }
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }
}
