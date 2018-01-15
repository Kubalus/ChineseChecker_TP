package Client;

public class Game {
    private Board board;
    private Player[] players;
    private AdjacencyStrategy adjacencyRule;
    private MovingStrategy movingRule;


    public void setBoard(Board board) {
        this.board = board;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public void setAdjacencyRule(AdjacencyStrategy adjacencyRule) {
        this.adjacencyRule = adjacencyRule;
    }

    public void setMovingRule(MovingStrategy movingRule) {
        this.movingRule = movingRule;
    }

    public Board getBoardObject() {
        return board;
    }

    public Player[] getPlayers() {
        return players;
    }

    public AdjacencyStrategy getAdjacencyRule() {
        return adjacencyRule;
    }

    public MovingStrategy getMovingRule() {
        return movingRule;
    }
}
