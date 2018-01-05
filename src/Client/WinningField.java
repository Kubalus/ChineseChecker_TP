package Client;

public class WinningField extends Field {
    private Player owner;

    public WinningField(int x, int y) {
        super(x, y);
    }

    public void setOwner( Player player){
        this.owner = player;
    }

}
