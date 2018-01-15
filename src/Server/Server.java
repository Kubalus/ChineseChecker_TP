package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server
{
    static final int PORT = 1201;
    ServerSocket serverSocket = null;
    Socket socket = null;
    List<Room> rooms = new ArrayList<>();

    Server()
    {
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
                new ServerThread(socket, this).start();
            }
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    public Room addToRoom(ServerThread serverThread, int limit)
    {
        for(int i = 0; i < rooms.size(); i++)
        {
            if (rooms.get(i).limit == limit)
            {
                if (rooms.get(i).addPlayer(serverThread))
                {
                    System.out.println("Server: new player added to room nr. "+i);
                    return rooms.get(i);
                }
            }
        }

        System.out.println("Server: No rooms left, creating new room");
        Room temp = new Room(this, limit);
        temp.addPlayer(serverThread);
        rooms.add(temp);
        return temp;
    }
}
