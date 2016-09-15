package cmblack;

import cmblack.game.Game;
import cmblack.game.IGameObserver;
import cmblack.player.IPlayer;

import java.util.ArrayList;

/**
 * Created by calebmacdonaldblack on 14/09/2016.
 */
public class UserInterface implements IGameObserver{

    @Override
    public void notify(Game game) {
        System.out.println("\n===============");
        System.out.println("game updated");
        System.out.println("Current Player: " + game.getCurrentPlayer().getName());
        System.out.println("Cards in deck: " + game.getDeck().length());
        ArrayList<IPlayer> playersWon = game.getWinners();
        for(int i=0;i<playersWon.size();i++){
            System.out.println(i + ": " + playersWon.get(i).getName());
        }
        System.out.println("===============\n");
    }
}
