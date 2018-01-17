package Client;

import java.util.ArrayList;

public class CCMoving implements MovingStrategy {


    @Override
    public ArrayList<Field> possibleMoves(Pawn pawn, Game game) {
        Field field = game.getBoard().getBoard()[pawn.getCoordinateX()][pawn.getCoordinateY()];
        Field[] adjacentFields = game.getAdjacencyRule().adjacentFields(field,game.getBoard().getBoard());
        ArrayList<Field> possibles = new ArrayList<>();
        Field[] tempFieldTable;
        Field temp;
        for(int i =0; i<6 ; i++) {
            if(adjacentFields[i] instanceof AccessibleField) {

               if (adjacentFields[i].getPawn() == null) {
                    if((field.getOwner() != pawn.getOwner()))
                     possibles.add(adjacentFields[i]);

                    else if (pawn.getOwner() == field.getOwner() && adjacentFields[i].getOwner() == pawn.getOwner())
                        possibles.add(adjacentFields[i]);
                }
               else {
                   tempFieldTable = game.getAdjacencyRule().adjacentFields(adjacentFields[i],game.getBoard().getBoard());
                   temp = tempFieldTable[i];
                   if( temp instanceof AccessibleField){
                       if (temp.getPawn() == null) {
                            if ((field.getOwner() != pawn.getOwner())) {
                                possibles.add(temp);
                            }
                            else if(pawn.getOwner() == field.getOwner() && temp.getOwner() == pawn.getOwner()) {
                               possibles.add(temp);
                           }

                      }
                   }
                }
            }

        }

        return possibles;
    }



    @Override
    public void movePawn(Pawn pawn, Field newField,Game game) throws Exception {
        if (newField.getPawn() != null)
            throw new Exception();
        else {
            Field oldField = game.getBoard().getField(pawn.getCoordinateX(), pawn.getCoordinateY());
            newField.setPawn(pawn);
            pawn.setCoordinates(newField.getCoordinateX(),newField.getCoordinateY());
            oldField.setPawn(null);
        }
    }

}
