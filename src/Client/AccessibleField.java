package Client;

public class AccessibleField extends Field {
    Pawn pawn;

    public AccessibleField(int x, int y) {

        super(x, y);
        pawn = null;
    }

    public void removePawn(){
        this.pawn = null;
    }

    @Override
    public void setPawn(Pawn pawn) {
        this.pawn = pawn;
    }

    @Override
    public Pawn getPawn(Field field) {
        return pawn;
    }
}
