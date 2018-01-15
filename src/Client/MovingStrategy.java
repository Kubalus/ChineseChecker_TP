package Client;

import java.util.ArrayList;

public interface MovingStrategy {

    public abstract ArrayList<Field> possibleMoves(Pawn pawn, Game game);

    public abstract void movePawn(Pawn pawn, Field newField, Game game) throws Exception ;

}
