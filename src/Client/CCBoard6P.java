package Client;

public class CCBoard6P extends GameBuilder {

    @Override
    public void buildBoard(){
         Field[][] tempBoard = new Field[19][15];

        for(int i = 0; i<19 ; i++){
            for(int j = 0; j<15; j++) {
                if (i >= 5 && i <= 13 && j >= 5 && j <= 9)
                    tempBoard[i][j] = new AccessibleField(i, j);
                else if ( j == 4 && i >= 7 && i <= 11)
                    tempBoard[i][j] = new AccessibleField(i, j);
                else if ( j == 10 && i >= 6 && i <= 12)
                    tempBoard[i][j] = new AccessibleField(i, j);
                else if ( j == 11 && i >= 8 && i <= 10)
                    tempBoard[i][j] = new AccessibleField(i, j);
                else if (i == 9 && j == 3)
                    tempBoard[i][j] = new AccessibleField(i, j);
                else if (j == 1 && (i == 5 || i == 13))
                    tempBoard[i][j] = new WinningField(i,j);
                else if (j == 2 && ((i >= 5 && i <= 7) || (i >= 11 && i <= 13)))
                    tempBoard[i][j] = new WinningField(i,j);
                else if (j == 3 && ((i >= 5 && i <= 8) || (i >= 10 && i <= 13)))
                    tempBoard[i][j] = new WinningField(i,j);
                else if (j == 4 && ((i >= 5 && i <= 6) || (i >= 12 && i <= 13)))
                    tempBoard[i][j] = new WinningField(i,j);
                else if (j == 6 && ((i >= 3 && i <= 4) || (i >= 14 && i <= 15)))
                    tempBoard[i][j] = new WinningField(i,j);
                else if (j == 7 && ((i >= 1 && i <= 4) || (i >= 14 && i <= 17)))
                    tempBoard[i][j] = new WinningField(i,j);
                else if (j == 8 && ((i >= 2 && i <= 4) || (i >= 14 && i <= 16)))
                    tempBoard[i][j] = new WinningField(i,j);
                else if (j == 9 && (i == 4 || i == 14))
                    tempBoard[i][j] = new WinningField(i,j);
                else if (j == 10 && (i == 5 || i == 13))
                    tempBoard[i][j] = new WinningField(i,j);
                else if (j == 11 && ((i >= 5 && i <= 7) || (i >= 11 && i <= 13)))
                    tempBoard[i][j] = new WinningField(i,j);
                else if (j == 12 && ((i >= 5 && i <= 8) || (i >= 10 && i <= 13)))
                    tempBoard[i][j] = new WinningField(i,j);
                else if (j == 13 && ((i >= 5 && i <= 6) || (i >= 12 && i <= 13)))
                    tempBoard[i][j] = new WinningField(i,j);
                else
                    tempBoard[i][j] = new InaccessibleField(i,j);
            }
        }
    this.board.setBoard(tempBoard);
    }

    @Override
    public void createPlayers() {

        Player[] tempPlayers = new Player[6];
        tempPlayers[0] = new Player();
        tempPlayers[1] = new Player();
        tempPlayers[2] = new Player();
        tempPlayers[3] = new Player();
        tempPlayers[4] = new Player();
        tempPlayers[5] = new Player();
        this.players = tempPlayers;
    }

    @Override
    public void seedPawns(){

         Pawn tempPawn;

        // Pawns for player1
        for(int i = 5; i <= 8; i++){
            for(int j = 1; j <= 4; j++){
                if(j == 3){
                    tempPawn = new Pawn(i,j,this.players[0]);
                    this.board.getField(i,j).setPawn(tempPawn);
                    this.players[0].addPawn(tempPawn);
                }

                else if(j == 2 && i <= 7 ){
                    tempPawn = new Pawn(i,j,this.players[0]);
                    this.board.getField(i,j).setPawn(tempPawn);
                    this.players[0].addPawn(tempPawn);
                }

                else if(j == 4 && i <= 6 ) {
                    tempPawn = new Pawn(i,j,this.players[0]);
                    this.board.getField(i,j).setPawn(tempPawn);
                    this.players[0].addPawn(tempPawn);
                }

                else if(i == 5 && j == 1 ){
                    tempPawn = new Pawn(i,j,this.players[0]);
                    this.board.getField(i,j).setPawn(tempPawn);
                    this.players[0].addPawn(tempPawn);
                }
            }
        }

        // Pawns for player2
        for(int i = 10; i <= 13; i++){
            for(int j = 1; j <= 4; j++){
                if(j == 3){
                    tempPawn = new Pawn(i,j,this.players[1]);
                    this.board.getField(i,j).setPawn(tempPawn);
                    this.players[1].addPawn(tempPawn);
                }

                else if(j == 2 && i >= 11 ){
                    tempPawn = new Pawn(i,j,this.players[1]);
                    this.board.getField(i,j).setPawn(tempPawn);
                    this.players[1].addPawn(tempPawn);
                }

                else if(j == 4 && i >= 12){
                    tempPawn = new Pawn(i,j,this.players[1]);
                    this.board.getField(i,j).setPawn(tempPawn);
                    this.players[1].addPawn(tempPawn);
                }

                 else if(i == 13 && j == 1){
                    tempPawn = new Pawn(i,j,this.players[1]);
                    this.board.getField(i,j).setPawn(tempPawn);
                    this.players[1].addPawn(tempPawn);
                }
            }
        }

        // Pawns for player3
        for(int i = 14; i <= 17; i++){
            for(int j = 6; j <= 9; j++){
                if(i == 14 && j == 9){
                    tempPawn = new Pawn(i,j,this.players[2]);
                    this.board.getField(i,j).setPawn(tempPawn);
                    this.players[2].addPawn(tempPawn);
                }
                else if(j == 6 && i <=15 ){
                    tempPawn = new Pawn(i,j,this.players[2]);
                    this.board.getField(i,j).setPawn(tempPawn);
                    this.players[2].addPawn(tempPawn);
                }
                else if(j == 7){
                    tempPawn = new Pawn(i,j,this.players[2]);
                    this.board.getField(i,j).setPawn(tempPawn);
                    this.players[2].addPawn(tempPawn);
                }
                else if(j == 8 && i <=16 ){
                    tempPawn = new Pawn(i,j,this.players[2]);
                    this.board.getField(i,j).setPawn(tempPawn);
                    this.players[2].addPawn(tempPawn);
                }
            }
        }

        // Pawns for player4
        for(int i = 1; i <= 4; i++){
            for(int j = 6; j <= 9; j++){
                if(j == 7){
                    tempPawn = new Pawn(i,j,this.players[3]);
                    this.board.getField(i,j).setPawn(tempPawn);
                    this.players[3].addPawn(tempPawn);
                }

                else if(j == 6 && i > 2 ){
                    tempPawn = new Pawn(i,j,this.players[3]);
                    this.board.getField(i,j).setPawn(tempPawn);
                    this.players[3].addPawn(tempPawn);
                }

                else if(j == 8 && i >= 2){
                    tempPawn = new Pawn(i,j,this.players[3]);
                    this.board.getField(i,j).setPawn(tempPawn);
                    this.players[3].addPawn(tempPawn);
                }

                else if(i == 4 && j == 9){
                    tempPawn = new Pawn(i,j,this.players[3]);
                    this.board.getField(i,j).setPawn(tempPawn);
                    this.players[3].addPawn(tempPawn);
                }
            }
        }

        // Pawns for player5
        for(int i = 5; i <= 8; i++){
            for(int j = 10; j <= 13; j++){
                if(j == 12){
                    tempPawn = new Pawn(i,j,this.players[4]);
                    this.board.getField(i,j).setPawn(tempPawn);
                    this.players[4].addPawn(tempPawn);
                }

                else if(j == 13 && i <= 6 ){
                    tempPawn = new Pawn(i,j,this.players[4]);
                    this.board.getField(i,j).setPawn(tempPawn);
                    this.players[4].addPawn(tempPawn);
                }

                else if(j == 11 && i <= 7){
                    tempPawn = new Pawn(i,j,this.players[4]);
                    this.board.getField(i,j).setPawn(tempPawn);
                    this.players[4].addPawn(tempPawn);
                }

                else if(i == 5 && j == 10){
                    tempPawn = new Pawn(i,j,this.players[4]);
                    this.board.getField(i,j).setPawn(tempPawn);
                    this.players[4].addPawn(tempPawn);
                }
            }
        }

        // Pawns for player6
        for(int i = 10; i <= 13; i++){
            for(int j = 10; j <= 13; j++){
                if(j == 12){
                    tempPawn = new Pawn(i,j,this.players[5]);
                    this.board.getField(i,j).setPawn(tempPawn);
                    this.players[5].addPawn(tempPawn);
                }

                else if(j == 11 && i > 10 ){
                    tempPawn = new Pawn(i,j,this.players[5]);
                    this.board.getField(i,j).setPawn(tempPawn);
                    this.players[5].addPawn(tempPawn);
                }

                else if(j == 13 && i >= 12){
                    tempPawn = new Pawn(i,j,this.players[5]);
                    this.board.getField(i,j).setPawn(tempPawn);
                    this.players[5].addPawn(tempPawn);
                }

                else if(i == 13 && j == 10){
                    tempPawn = new Pawn(i,j,this.players[5]);
                    this.board.getField(i,j).setPawn(tempPawn);
                    this.players[5].addPawn(tempPawn);
                }
            }
        }

    }

    @Override
    public void setWinningZones() {

        // setting winning field for Player 6 on starting field for player 1
        for(int i = 5; i <= 8; i++){
            for(int j = 1; j <= 4; j++){
                if(j == 3){
                    this.board.getField(i,j).setOwner(this.players[5]);
                    this.players[5].addWinningField(this.board.getField(i,j));
                }

                else if(j == 2 && i <= 7 ){
                    this.board.getField(i,j).setOwner(this.players[5]);
                    this.players[5].addWinningField(this.board.getField(i,j));
                }

                else if(j == 4 && i <= 6 ) {
                    this.board.getField(i,j).setOwner(this.players[5]);
                    this.players[5].addWinningField(this.board.getField(i,j));
                }

                else if(i == 5 && j == 1 ){
                    this.board.getField(i,j).setOwner(this.players[5]);
                    this.players[5].addWinningField(this.board.getField(i,j));
                }
            }
        }

        // setting winning field for Player 5 on starting field for player 2
        for(int i = 10; i <= 13; i++){
            for(int j = 1; j <= 4; j++){
                if(j == 3){
                    this.board.getField(i,j).setOwner(this.players[4]);
                    this.players[4].addWinningField(this.board.getField(i,j));
                }

                else if(j == 2 && i >= 11 ){
                    this.board.getField(i,j).setOwner(this.players[4]);
                    this.players[4].addWinningField(this.board.getField(i,j));
                }

                else if(j == 4 && i >= 12){
                    this.board.getField(i,j).setOwner(this.players[4]);
                    this.players[4].addWinningField(this.board.getField(i,j));
                }

                else if(i == 13 && j == 1){
                    this.board.getField(i,j).setOwner(this.players[4]);
                    this.players[4].addWinningField(this.board.getField(i,j));
                }
            }
        }

        // setting winning field for Player 4 on starting field for player 3
        for(int i = 14; i <= 17; i++){
            for(int j = 6; j <= 9; j++){
                if(i == 14 && j == 9){
                    this.board.getField(i,j).setOwner(this.players[3]);
                    this.players[3].addWinningField(this.board.getField(i,j));
                }
                else if(j == 6 && i <=15 ){
                    this.board.getField(i,j).setOwner(this.players[3]);
                    this.players[3].addWinningField(this.board.getField(i,j));
                }
                else if(j == 7){
                    this.board.getField(i,j).setOwner(this.players[3]);
                    this.players[3].addWinningField(this.board.getField(i,j));
                }
                else if(j == 8 && i <=16 ){
                    this.board.getField(i,j).setOwner(this.players[3]);
                    this.players[3].addWinningField(this.board.getField(i,j));
                }
            }
        }

        // setting winning field for Player 3 on starting field for player 4
        for(int i = 1; i <= 4; i++){
            for(int j = 6; j <= 9; j++){
                if(j == 7){
                    this.board.getField(i,j).setOwner(this.players[2]);
                    this.players[2].addWinningField(this.board.getField(i,j));
                }

                else if(j == 6 && i >= 2 ){
                    this.board.getField(i,j).setOwner(this.players[2]);
                    this.players[2].addWinningField(this.board.getField(i,j));
                }

                else if(j == 8 && i >= 2){
                    this.board.getField(i,j).setOwner(this.players[2]);
                    this.players[2].addWinningField(this.board.getField(i,j));
                }

                else if(i == 4 && j == 9){
                    this.board.getField(i,j).setOwner(this.players[2]);
                    this.players[2].addWinningField(this.board.getField(i,j));
                }
            }
        }

        // setting winning field for Player 2 on starting field for player 5
        for(int i = 5; i <= 8; i++){
            for(int j = 10; j <= 13; j++){
                if(j == 12){
                    this.board.getField(i,j).setOwner(this.players[1]);
                    this.players[1].addWinningField(this.board.getField(i,j));
                }

                else if(j == 13 && i <= 6 ){
                    this.board.getField(i,j).setOwner(this.players[1]);
                    this.players[1].addWinningField(this.board.getField(i,j));
                }

                else if(j == 11 && i <= 7){
                    this.board.getField(i,j).setOwner(this.players[1]);
                    this.players[1].addWinningField(this.board.getField(i,j));
                }

                else if(i == 5 && j == 10){
                    this.board.getField(i,j).setOwner(this.players[1]);
                    this.players[1].addWinningField(this.board.getField(i,j));
                }
            }
        }

        // setting winning field for Player 1 on starting field for player 6
        for(int i = 10; i <= 13; i++){
            for(int j = 10; j <= 13; j++){
                if(j == 12){
                    this.board.getField(i,j).setOwner(this.players[0]);
                    this.players[0].addWinningField(this.board.getField(i,j));
                }

                else if(j == 11 && i >= 11 ){
                    this.board.getField(i,j).setOwner(this.players[0]);
                    this.players[0].addWinningField(this.board.getField(i,j));
                }

                else if(j == 13 && i >= 12){
                    this.board.getField(i,j).setOwner(this.players[0]);
                    this.players[0].addWinningField(this.board.getField(i,j));
                }

                else if(i == 13 && j == 10){
                    this.board.getField(i,j).setOwner(this.players[0]);
                    this.players[0].addWinningField(this.board.getField(i,j));
                }
            }
        }

    }

    @Override
    public void setAdjacency() {
        this.adjacencyRule = new HexagonalAdjacency();
    }

    @Override
    public void setMoving() {
        this.movingRule = new CCMoving();
    }

    @Override
    public void setWinning() {
        this.winningRule = new CCWinning();
    }
}

// TODO : Tests to Pawns and Winning Zones