package Client;

import java.io.*;
import java.net.*;

public class Client
{
    int PORT = 1201;
    Socket socket;
    DataInputStream dataIn;
    DataOutputStream dataOut;
    String messageIn="", messageOut="";

    Client()
    {
        System.out.println("Clietnt: Creating client");
        try
        {
            // Set client on server
            socket = new Socket("127.0.0.1", PORT);
            System.out.println("Client: Conected to a server");

            // Initialize Input and Output streams
            dataIn = new DataInputStream(socket.getInputStream());
            dataOut = new DataOutputStream(socket.getOutputStream());
            System.out.println("Client: input and output streams established");

            while(!messageIn.equals("END"))
            {
                // Send data
                if(messageOut.equals(""))
                {
                    dataOut.writeUTF(messageOut);
                }

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
