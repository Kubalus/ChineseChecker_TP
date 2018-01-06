package Client;

// using Builder Pattern to creating Game


public abstract class GameBuilder {
    protected Board board;
    protected Player[] players;

    public void newBoard(){
        this.board = new Board();
    }

    public Board getBoard(){
        return board;
    }

    public Player[] getPlayers() {
        return players;
    }

    public abstract void buildBoard();
    public abstract void createPlayers();
    public abstract void setWinningZones();
    public abstract void seedPawns();
}
