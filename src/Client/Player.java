package Client;

import java.util.ArrayList;

public class Player {

    private ArrayList<Pawn> pawns;
    private ArrayList<Field> winningFields;


    public Player(){
        pawns = new ArrayList<>();
        winningFields = new ArrayList<>();
    }

    public ArrayList<Pawn> getPawns() {
        return pawns;
    }

    public ArrayList<Field> getWinningFields() {
        return winningFields;
    }

    public void addPawn(Pawn pawn){
        pawns.add(pawn);
    }

    public void addWinningField(Field field){
        if(field instanceof WinningField)
            winningFields.add(field);
    }
}
