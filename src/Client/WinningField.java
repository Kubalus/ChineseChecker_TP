package Client;

public class WinningField extends AccessibleField {
    private Player owner = null;

    public WinningField(int x, int y) {
        super(x, y);
        owner = null;
    }

    @Override
    public void setOwner(Player player) {
        this.owner = player;
    }

    @Override
    public Player getOwner() {
        return owner;
    }
}
