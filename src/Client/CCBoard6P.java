package Client;

public class CCBoard6P extends BoardBuilder {

    @Override
    public void buildBoard(){
         Field[][] board = new Field[19][15];

        for(int i = 0; i<19 ; i++){
            for(int j = 0; j<15; j++) {
                if (i >= 5 && i <= 13 && j >= 5 && j <= 9)
                    board[i][j] = new AccessibleField(i, j);
                else if ( j == 4 && i >= 7 && i <= 11)
                    board[i][j] = new AccessibleField(i, j);
                else if ( j == 10 && i >= 6 && i <= 12)
                    board[i][j] = new AccessibleField(i, j);
                else if ( j == 11 && i >= 8 && i <= 10)
                    board[i][j] = new AccessibleField(i, j);
                else if (i == 9 && j == 3)
                    board[i][j] = new AccessibleField(i, j);
                else if (j == 1 && (i == 5 || i == 13))
                    board[i][j] = new WinningField(i,j);
                else if (j == 2 && ((i >= 5 && i <= 7) || (i >= 11 && i <= 13)))
                board[i][j] = new WinningField(i,j);
                else if (j == 3 && ((i >= 5 && i <= 8) || (i >= 10 && i <= 13)))
                    board[i][j] = new WinningField(i,j);
                else if (j == 4 && ((i >= 5 && i <= 6) || (i >= 12 && i <= 13)))
                    board[i][j] = new WinningField(i,j);
                else if (j == 6 && ((i >= 3 && i <= 4) || (i >= 14 && i <= 15)))
                    board[i][j] = new WinningField(i,j);
                else if (j == 7 && ((i >= 1 && i <= 4) || (i >= 14 && i <= 17)))
                    board[i][j] = new WinningField(i,j);
                else if (j == 8 && ((i >= 2 && i <= 4) || (i >= 14 && i <= 17)))
                    board[i][j] = new WinningField(i,j);
                else if (j == 9 && (i == 4 || i == 14))
                    board[i][j] = new WinningField(i,j);
                else if (j == 10 && (i == 5 || i == 13))
                board[i][j] = new WinningField(i,j);
                else if (j == 11 && ((i >= 5 && i <= 7) || (i >= 11 && i <= 13)))
                    board[i][j] = new WinningField(i,j);
                else if (j == 12 && ((i >= 5 && i <= 8) || (i >= 10 && i <= 13)))
                    board[i][j] = new WinningField(i,j);
                else if (j == 13 && ((i >= 5 && i <= 6) || (i >= 12 && i <= 13)))
                    board[i][j] = new WinningField(i,j);
                else
                    board[i][j] = new InaccessibleField(i,j);
            }
        }
    this.board.setBoard(board);
    }

    @Override
    public void seedPawns(){

    }
}
