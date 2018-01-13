package Client;

public class WinningField extends Field {
    private Player owner = null;

    public WinningField(int x, int y) {
        super(x, y);
    }

    @Override
    public void setOwner(Player player) {
        this.owner = player;
    }

    @Override
    public Player getOwner(Field field) {
        return owner;
    }
}
