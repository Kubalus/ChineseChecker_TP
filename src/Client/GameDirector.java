package Client;


public class GameDirector {
    private GameBuilder builder;

    public void setBuilder(GameBuilder builder) {
        this.builder = builder;
    }

    public Board getBoard(){
        return builder.getBoard();
    }

    public void createGame(){
        builder.newBoard();
        builder.buildBoard();
        builder.createPlayers();
        builder.setWinningZones();
        builder.seedPawns();
        builder.setAdjacency();
        builder.setMoving();
        builder.setWinning();
    }
}
