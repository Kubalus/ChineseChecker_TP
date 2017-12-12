package Server;

public class Field {
   private int coordinateX;
   private int coordinateY;

   public Field (int x, int y){
       this.coordinateX = x;
       this.coordinateY = y;
   }

   public void setNewCoordinatetes(int x, int y){
       this.coordinateX = x;
       this.coordinateY = y;
   }

    public int getCoordinateX() {
        return coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }
}


