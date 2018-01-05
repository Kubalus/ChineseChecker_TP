package Client;


public class BoardDirector {
    private BoardBuilder builder;

    public void setBuilder(BoardBuilder builder) {
        this.builder = builder;
    }

    public Board getBoard(){
        return builder.getBoard();
    }
    public void createBoard(){
        builder.newBoard();
        builder.buildBoard();
        builder.seedPawns();
    }
}
