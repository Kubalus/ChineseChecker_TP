package Client;

import java.util.ArrayList;

public class CCWinning implements WinningStrategy {
    @Override
    public Boolean checkWinning(Player player, Game game) {
        ArrayList<Field> fields = player.getWinningFields();
        for (Field temp : fields){
            if(temp.getPawn() == null || (temp.getPawn() != null && temp.getPawn().getOwner() != temp.getOwner()))
                return false;
        }
        return true;
    }
}
