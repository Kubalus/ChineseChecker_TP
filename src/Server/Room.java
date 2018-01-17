package Server;

import java.util.ArrayList;
import java.util.List;

public class Room
{
    private Server server;
    private List<ServerThread> players;
    int limit;
    int place = 0;

    Room(Server server, int i)
    {
        this.server = server;
        limit = i;
        players = new ArrayList<>();
    }

    // Returns 1 if added successfully or 0 if not
    public boolean addPlayer(ServerThread player)
    {
        if(players.size() < limit)
        {
            players.add(player);
            return true;
        }
        else
        {
            return false;
        }
    }

    public List<ServerThread> getPlayers()
    {
        return players;
    }

    public void sendToPlayers(String message, int exclude)
    {
        for(int i = 0; i < players.size(); i++)
        {
            if(i != exclude)
            {
                players.get(i).sendMessage(message);
            }
        }
    }
}
