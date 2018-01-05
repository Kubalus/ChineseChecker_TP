package Client;

public class AccessibleField extends Field {

    Pawn pawn;


    public AccessibleField(int x, int y) {
        super(x, y);
    }

    public void setPawn(){
        this.pawn = null;
    }

    public void setPawn(Pawn pawn){
        this.pawn = pawn;
    }
}
