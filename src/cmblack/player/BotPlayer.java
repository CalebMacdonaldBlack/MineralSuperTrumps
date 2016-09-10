package cmblack.player;

import cmblack.card.ICard;
import cmblack.category.Category;

import java.util.ArrayList;

/**
 * Created by calebmacdonaldblack on 10/09/2016.
 */
public class BotPlayer implements IPlayer {
    private final ArrayList<ICard> cards = new ArrayList<>();
    private final String name;

    public BotPlayer(String name) {
        this.name = name;
    }

    @Override
    public IPlayer addCard(ICard card) {
        return null;
    }

    @Override
    public ICard playCard(ICard cardToBeat, Category currentTrumpCategory) {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }
}
