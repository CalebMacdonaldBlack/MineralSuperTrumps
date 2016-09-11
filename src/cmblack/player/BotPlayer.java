package cmblack.player;

import cmblack.card.CardType;
import cmblack.card.CategoryComparisonResult;
import cmblack.card.EmptyCard;
import cmblack.card.ICard;
import cmblack.card.stats.AveragePercentOfRangeCalculator;
import cmblack.card.stats.IAveragePercentOfRangeCalculator;
import cmblack.card.stats.IAveragePercentOfRangeResult;
import cmblack.category.Category;
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
        ICard possibleTrumpCard = new EmptyCard();
        for(ICard card: cards){
            CategoryComparisonResult categoryComparisonResult = card.getStats().compareWith(cardToBeat.getStats());
            if(categoryComparisonResult.valueForCategory(currentTrumpCategory) > 0){
                return card;
            }else if(card.getType().equals(CardType.TRUMP_CARD)){
                possibleTrumpCard = card;
            }

        }
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
