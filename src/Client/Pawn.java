package Client;

public class Pawn{
    private int coordinateX;
    private int coordinateY;
    Player owner;


    public Pawn (int x, int y, Player player) {
        coordinateX = x;
        coordinateY = y;
        this.owner = player;
    }


}
