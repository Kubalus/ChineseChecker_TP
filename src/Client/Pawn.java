package Client;

public class Pawn{
    private int coordinateX;
    private int coordinateY;
    private Player owner;


    public Pawn (int x, int y, Player player) {
        this.coordinateX = x;
        this.coordinateY = y;
        this.owner = player;
    }

    public void setCoordinates(int x, int y){
        this.coordinateX = x;
        this.coordinateY = y;

    }

    public Player getOwner() {
        return owner;
    }

    public int getCoordinateX() {
        return coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }
}
