package cmblack.player;

import cmblack.card.ICard;
import cmblack.category.ICategory;

/**
 * Created by calebmacdonaldblack on 11/09/2016.
 */
public interface IPlayerTurn {
    IPlayerTurnResult haveTurn();

    class FakePlayerTurn implements IPlayerTurn {

        @Override
        public IPlayerTurnResult haveTurn() {
            return null;
        }
    }
}
