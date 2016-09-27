package cmblack.player.round;

import cmblack.category.ICategory;
import cmblack.deck.IDeck;
import cmblack.player.IPlayer;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * Created by calebmacdonaldblack on 11/09/2016.
 */
public interface IRoundResult {
    IPlayerGroup getPlayerGroup();
    ICategory getNextRoundCategory();
    List<IPlayer> getPlayersToRemoveFromGame();
}
