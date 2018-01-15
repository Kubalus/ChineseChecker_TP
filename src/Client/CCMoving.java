package Client;

import java.util.ArrayList;

public class CCMoving implements MovingStrategy {


    @Override
    public ArrayList<Field> possibleMoves(Pawn pawn, Game game) {
        Field field = game.getBoardObject().getBoard()[pawn.getCoordinateX()][pawn.getCoordinateY()];
        Field[] adjacentFields = game.getAdjacencyRule().adjacentFields(field,game.getBoardObject().getBoard());
        ArrayList<Field> possibles = new ArrayList<>();
        Field[] tempFieldTable;
        Field temp;
        for(int i =0; i<6 ; i++) {
            if(adjacentFields[i] instanceof AccessibleField) {
                if (adjacentFields[i].getPawn() == null) {
                    if (adjacentFields[i].getOwner() == pawn.getOwner()) {
                        possibles.add(adjacentFields[i]);
                    }
                    else if(adjacentFields[i].getOwner() == null) {
                        possibles.add(adjacentFields[i]);
                    }
                }
                else {
                    tempFieldTable = game.getAdjacencyRule().adjacentFields(adjacentFields[i],game.getBoardObject().getBoard());
                    temp = tempFieldTable[i];
                    if (temp.getPawn() == null) {
                        if (temp.getOwner() == pawn.getOwner()) {
                            possibles.add(temp);
                        }
                        else if(temp.getOwner() == null) {
                            possibles.add(temp);
                        }
                    }

                }
            }

        }

        return possibles;
    }





    @Override
    public void movePawn(Pawn pawn, Field newField, Game game) throws Exception {
        if(newField.getPawn() != null)
            throw new Exception();

        Field oldField = game.getBoardObject().getField(pawn.getCoordinateX(),pawn.getCoordinateY());
        if(oldField.getOwner() != null){
            if((oldField.getOwner() == pawn.getOwner()) && (oldField.getOwner() == newField.getOwner())) {
                newField.setPawn(pawn);
                oldField.setPawn(null);
            }
        }
        else
        if(newField instanceof AccessibleField && newField.getPawn() == null){
            newField.setPawn(pawn);
            oldField.setPawn(null);
        }
        else
            throw new Exception();


    }

}
