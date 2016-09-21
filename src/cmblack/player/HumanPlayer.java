package cmblack.player;

import cmblack.card.CardType;
import cmblack.card.ICard;
import cmblack.category.CategoryComparisonResult;
import cmblack.category.ICategory;
import cmblack.controller.IRoundActions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by calebmacdonaldblack on 20/09/2016.
 */
public class HumanPlayer implements IPlayer {
    private final ArrayList<ICard> cards = new ArrayList<>();
    private final String name;

    public HumanPlayer(String name) {
        this.name = name;
    }

    @Override
    public IPlayer addCard(ICard card) {
        return null;
    }

    @Override
    public IPlayer playCard(ICard cardToBeat, ICategory currentTrumpCategory, IRoundActions roundActions) {

        List<ICard> validCards = new ArrayList<>();

        for(ICard card: cards){
            CategoryComparisonResult categoryComparisonResult = card.getStats().compareWith(cardToBeat.getStats());
            if(categoryComparisonResult.valueForCategory(currentTrumpCategory) > 0 || card.getType().equals(CardType.TRUMP_CARD)){
                validCards.add(card);
            }
        }

        ICard card = roundActions.findCardToPlay(validCards.toArray(new ICard[validCards.size()]));

        // TODO: 21/09/2016 make this a method that the controller calls
        this.cards.remove(card);
        return this;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(IPlayer player) {
        return false;
    }

    @Override
    public ICategory chooseCategory(ICategory[] changeableCategories) {
        return null;
    }

    @Override
    public ICategory chooseCategory() {
        return null;
    }

    @Override
    public int getCountOfCards() {
        return this.cards.size();
    }

    @Override
    public IPlayer giveCard(ICard card) {
        this.cards.add(card);
        return this;
    }

    @Override
    public ArrayList<ICard> getCards() {
        return null;
    }
}
