package Client;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class CCMoving implements MovingStrategy {


    @Override
    public ArrayList<Field> possibleMoves(Pawn pawn, Game game) {
        Field field = game.getBoard().getBoard()[pawn.getCoordinateX()][pawn.getCoordinateY()];
        Field[] adjacentFields = game.getAdjacencyRule().adjacentFields(field,game.getBoard().getBoard());
        ArrayList<Field> possibles = new ArrayList<>();
        for(int i =0; i<6 ; i++) {
            if(adjacentFields[i] instanceof AccessibleField) {

               if (adjacentFields[i].getPawn() == null) {
                    if((field.getOwner() != pawn.getOwner()))
                     possibles.add(adjacentFields[i]);

                    else if (pawn.getOwner() == field.getOwner() && adjacentFields[i].getOwner() == pawn.getOwner())
                        possibles.add(adjacentFields[i]);
                }

            }

        }
        possibles.addAll(Jumps(pawn, game));
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

    private ArrayList<Field> Jumps (Pawn pawn, Game game){
        ArrayList<Field> jumps = new ArrayList<>();
        ArrayList<Field> used = new ArrayList<>();
        Queue<Field> queue = new ArrayDeque<>();
        Field operatingField;
        Field field = game.getBoard().getField(pawn.getCoordinateX(),pawn.getCoordinateY());
        Field[] adjacent;
        queue.add(field);
        used.add(field);
        while(!queue.isEmpty()){
            operatingField = queue.poll();
            adjacent = game.getAdjacencyRule().adjacentFields(operatingField,game.getBoard().getBoard());
            for(int i = 0; i < 6; i++){
                if(adjacent[i].getPawn() != null ) {
                    Field[] tempAdjacentField = game.getAdjacencyRule().adjacentFields(adjacent[i], game.getBoard().getBoard());
                    Field temp = tempAdjacentField[i];
                    if (temp instanceof AccessibleField) {
                        if (!used.contains(temp)) {
                            used.add(temp);
                            if (temp.getPawn() == null) {
                                if ((field.getOwner() != pawn.getOwner())) {
                                    jumps.add(temp);
                                    queue.add(temp);
                                } else if (pawn.getOwner() == field.getOwner() && temp.getOwner() == pawn.getOwner()) {
                                    jumps.add(temp);
                                    queue.add(temp);
                                }
                            }
                        }
                    }
                }
            }

        }
    return jumps;
    }

}
