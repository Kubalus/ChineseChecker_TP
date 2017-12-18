package Server;

public class Board
{

    private Field[][] board;

    public Board()
    {
        board = new Field[19][15];
    }

    public Field[] adjacentField(int x, int y)
    {
        Field[] adjacents = new Field[6];
        adjacents[0] = board[x][y-1];
        adjacents[3] = board[x][y+1];
        if (x % 2 == 1)
        {
            adjacents[1] = board[x+1][y-1];
            adjacents[2] = board[x+1][y];
            adjacents[4] = board[x-1][y];
            adjacents[5] = board[x-1][y-1];
        }
        else
        {
            adjacents[1] = board[x+1][y];
            adjacents[2] = board[x+1][y+1];
            adjacents[4] = board[x-1][y+1];
            adjacents[5] = board[x-1][y];
        }
        return adjacents;
    }
}
