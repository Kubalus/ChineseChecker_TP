package Client;

import java.util.*;

public class Bot extends Player {
    private ArrayList<Pawn> notWinningPawns;

    public Bot(){
        super();
    }

    public void initializeBot(){
        this.notWinningPawns = this.getPawns();
    }

    private int fieldDistance(Field field1, Field field2){
        int x1 = field1.getCoordinateX();
        int y1 = field1.getCoordinateY();
        int x2 = field2.getCoordinateX();
        int y2 = field2.getCoordinateY();
        int cubeX1 = x1;
        int cubeY1 = y1 - ((x1 + (x1 & 1)) / 2 );
        int cubeZ1 = 0 - cubeX1 - cubeY1;
        int cubeX2 = x2;
        int cubeY2 = y2 - ((x2 + (x2 & 1)) / 2 );
        int cubeZ2 = 0 - cubeX2 - cubeY2;

        return Math.max(Math.abs(cubeX1 - cubeX2), Math.max(Math.abs(cubeY1 - cubeY2), Math.abs(cubeZ1 - cubeZ2)));
    }

    private Boolean isPath(Game game, Field start, Field end){
        Queue<Field> queue = new ArrayDeque<>();
        Field operatingField;
        ArrayList<Field> moves;
        ArrayList<Field> used = new ArrayList<>();
        Pawn tempPawn = start.getPawn();
        queue.add(start);
        used.add(start);
        while(!queue.isEmpty()){
            operatingField = queue.poll();
            if(operatingField == end)
                return true;
            tempPawn.setCoordinates(operatingField.getCoordinateX(),operatingField.getCoordinateY());
            moves = game.getMovingRule().possibleMoves(tempPawn,game);
            for(Field tile : moves){
                if(!used.contains(tile)){
                    used.add(tile);
                    queue.add(tile);
                }
            }

        }

        return false;
    }

    public void botMove(Game game){
        Field targetField = null;
        Pawn bestPawn = null;
        int shortestDistance = 100000;
        ArrayList<Field>  winning = this.getWinningFields();
        ArrayList<Field>  moves;
        Collections.shuffle(winning);
        int distance;
        Field fieldToMove = null;

        // choose empty winning field that will be targeted

        for(Field tile : winning){
            if(tile.getPawn() == null){
                targetField = tile;
                break;
            }
        }
        // choose the closest Pawn
        for(Pawn pawn : notWinningPawns){
            distance = fieldDistance(game.getBoard().getField(pawn.getCoordinateX(),pawn.getCoordinateY()),targetField);
            if(distance < shortestDistance){
                bestPawn = pawn;
                shortestDistance = distance;
            }
        }
        int shortestDistance2 = 100000;
        moves = game.getMovingRule().possibleMoves(bestPawn,game);
        for(Field tile : moves){
            distance = fieldDistance(tile, targetField);
            if(shortestDistance2 > distance && isPath(game,tile,targetField)){
                shortestDistance2 = distance;
                fieldToMove = tile;
            }
        }
        if(fieldToMove == targetField)
            notWinningPawns.remove(bestPawn);

        try {
            game.getMovingRule().movePawn(bestPawn,fieldToMove,game);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
