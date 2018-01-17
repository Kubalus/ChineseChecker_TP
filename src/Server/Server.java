package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Server
{
    static private final int PORT = 1201;
    private ServerSocket serverSocket = null;
    private Socket socket = null;
    private List<Room> rooms = new ArrayList<>();
    private Random rand = new Random();

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

                    if(rooms.get(i).limit == rooms.get(i).getPlayers().size())
                    {
                        startupMessage(rooms.get(i));
                    }

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

    public void startupMessage(Room room)
    {
        for(int i = 0; i < room.limit; i++)
        {
            room.getPlayers().get(i).sendMessage("I " + i);
        }
        room.getPlayers().get(rand.nextInt(room.limit)).sendMessage("S");
    }
}
