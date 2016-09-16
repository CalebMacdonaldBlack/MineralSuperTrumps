package cmblack.player;

import cmblack.card.CardType;
import cmblack.category.CategoryComparisonResult;
import cmblack.card.EmptyCard;
import cmblack.card.ICard;
import cmblack.card.stats.statscalculator.AveragePercentOfRangeCalculator;
import cmblack.card.stats.statscalculator.IAveragePercentOfRangeCalculator;
import cmblack.card.stats.statscalculator.IAveragePercentOfRangeResult;
import cmblack.category.EmptyCategory;
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

        if(currentTrumpCategory.equals(new EmptyCategory())){
            throw new NullPointerException("Cannot not choose card with empty category");
        }

        ICard possibleTrumpCard = new EmptyCard();
        for(ICard card: cards){
            CategoryComparisonResult categoryComparisonResult = card.getStats().compareWith(cardToBeat.getStats());
            if(categoryComparisonResult.valueForCategory(currentTrumpCategory) > 0){
                this.cards.remove(card);
                return card;
            }else if(card.getType().equals(CardType.TRUMP_CARD)){
                possibleTrumpCard = card;
            }

        }
        this.cards.remove(possibleTrumpCard);
        return possibleTrumpCard;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(IPlayer player) {
        return this.name.equals(player.getName());
    }

    @Override
    public ICategory chooseCategory() {

        return this.pickCategoryWherePlayerHasHighestAverage();
    }

    @Override
    public int getCountOfCards() {
        return this.cards.size();
    }

    @Override
    public void giveCard(ICard card) {
        if(!card.equals(new EmptyCard())){
            this.cards.add(card);
        }
    }

    @Override
    public ArrayList<ICard> getCards() {
        return this.cards;
    }

    private ICategory pickCategoryWherePlayerHasHighestAverage() {
        IAveragePercentOfRangeCalculator averagePercentOfRangeCalculator = new AveragePercentOfRangeCalculator();
        for(ICard card: cards){
            if(card.getType().equals(CardType.PLAY_CARD)){
                averagePercentOfRangeCalculator.addStats(card.getStats());
            }
        }
        IAveragePercentOfRangeResult averagePercentOfRangeResult = averagePercentOfRangeCalculator.calculateAverage();


        return averagePercentOfRangeResult.getCategoryOfHighestPercentage();
    }
}
