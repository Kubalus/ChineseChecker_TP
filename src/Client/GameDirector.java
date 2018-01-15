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
        builder.seedPawns();
        builder.setWinningZones();
        builder.setAdjacency();
        builder.setMoving();
        builder.setWinning();
    }
}
