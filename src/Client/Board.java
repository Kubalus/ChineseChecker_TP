package Client;

import java.util.concurrent.ExecutionException;

public class Board {

    private Field[][] board;

    public void setBoard(Field[][] newBoard){
        this.board = newBoard;
    }

    public Field getField(int x, int y){
        return board[x][y];
    }

    public Field[][] getBoard() {
        return board;
    }
}

