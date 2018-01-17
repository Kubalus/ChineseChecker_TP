package Client;

public class HexagonalAdjacency implements AdjacencyStrategy {

    @Override
    public Field[] adjacentFields(Field field, Field[][] board) {
        int x = field.getCoordinateX();
        int y = field.getCoordinateY();
        Field[] adjacent = new Field[6];
        adjacent[0] = board[x][y-1];
        adjacent[3] = board[x][y+1];
        if (x % 2 == 1){
            adjacent[1] = board[x+1][y-1];
            adjacent[2] = board[x+1][y];
            adjacent[4] = board[x-1][y];
            adjacent[5] = board[x-1][y-1];
        }
        else {
            adjacent[1] = board[x+1][y];
            adjacent[2] = board[x+1][y+1];
            adjacent[4] = board[x-1][y+1];
            adjacent[5] = board[x-1][y];
        }
        return adjacent;
    }
}
