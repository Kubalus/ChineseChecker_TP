package Server;

import java.io.*;
import java.net.*;

public class Server
{
    // Port number
    static final int PORT = 1201;

    public static void main(String[] args)
    {
        ServerSocket serverSocket = null;
        Socket socket = null;
        System.out.println("Server: Creating server");
        try
        {
            // Setup server socket
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server: Server running on port number "+PORT);

            while(true)
            {
                // Try to accept new client
                socket = serverSocket.accept();

                // Create new thread for a client
                new ServerThread(socket).start();
            }
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }
}
