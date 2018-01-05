package Client;

public abstract class BoardBuilder {
    protected Board board;

    public void newBoard(){
        board = new Board();
    }

    public Board getBoard(){
        return board;
    }

    public abstract void buildBoard();
    public abstract void seedPawns();
}
