package cmblack.player;

import cmblack.card.CategoryComparisonResult;
import cmblack.card.ICard;
import cmblack.category.Category;
import cmblack.category.ICategory;

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
        this.cards.add(card);
        return this;
    }

    @Override
    public ICard playCard(ICard cardToBeat, ICategory currentTrumpCategory) {
        for(ICard card: cards){
            CategoryComparisonResult categoryComparisonResult = card.getStats().compareWith(cardToBeat.getStats());
            if(categoryComparisonResult.valueForCategory(currentTrumpCategory) > 0){
                return card;
            }

        }
        return null;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
