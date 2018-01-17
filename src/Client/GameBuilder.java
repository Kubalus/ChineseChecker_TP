package Client;

// using Builder Pattern to creating Game


public abstract class GameBuilder {
    protected Game game;
    protected Board board;
    protected Player[] players;
    protected AdjacencyStrategy adjacencyRule;
    protected MovingStrategy movingRule;
    protected WinningStrategy winningRule;

    public Game setupGame()
    {
        game = new Game();
        game.setBoard(board);
        game.setPlayers(players);
        game.setAdjacencyRule(adjacencyRule);
        game.setMovingRule(movingRule);
        game.setWinningRule(winningRule);
        return game;
    }

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
    public abstract void setAdjacency();
    public abstract void setMoving();
    public abstract void setWinning();
}
