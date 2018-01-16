package Client;

public abstract class Field
{
   private int coordinateX;
   private int coordinateY;

   public Field (int x, int y)
   {

       this.coordinateX = x;
       this.coordinateY = y;
   }

   public void setNewCoordinatetes(int x, int y)
   {
       this.coordinateX = x;
       this.coordinateY = y;
   }

    public int getCoordinateX()
    {
        return coordinateX;
    }

    public int getCoordinateY()
    {
        return coordinateY;
    }

    public void setPawn(Pawn pawn){

    }

    public void setOwner(Player player){

    }

    public Player getOwner(){
        return null;
    }

    public Pawn getPawn(){
        return null;
    }
}


