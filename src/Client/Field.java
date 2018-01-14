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
        // TODO: Handle setting Pawn on Inaccessible fields
    }

    public void setOwner(Player player){
       // TODO: the same as higher ( each Field Class excluding WinningField)
    }

    public Player getOwner(){
        return null;
    }

    public Pawn getPawn(){
        return null;

    }
}


