package cmblack.player;

import cmblack.card.CardType;
import cmblack.card.EmptyCard;
import cmblack.card.ICard;
import cmblack.card.stats.statscalculator.AveragePercentOfRangeCalculator;
import cmblack.card.stats.statscalculator.IAveragePercentOfRangeCalculator;
import cmblack.card.stats.statscalculator.IAveragePercentOfRangeResult;
import cmblack.category.CategoryComparisonResult;
import cmblack.category.EmptyCategory;
import cmblack.category.ICategory;

/**
 * Created by calebmacdonaldblack on 23/9/16.
 */
public class BotAI implements IBotAI {
    @Override
    public ICard findBestCard(IPlayer player, ICard cardToBeat, ICategory currentTrumpCategory) {
        boolean cardPlayed = false;

        if(currentTrumpCategory.equals(new EmptyCategory())){
            throw new NullPointerException("Cannot not choose card with empty category");
        }
        for(ICard card: player.getPlayerHand().getCards().toArray(new ICard[player.getPlayerHand().getCards().size()])) {
            CategoryComparisonResult categoryComparisonResult = card.getStats().compareWith(cardToBeat.getStats());
            if (categoryComparisonResult.valueForCategory(currentTrumpCategory) > 0) {
                return card;
            } else if (card.getType().equals(CardType.TRUMP_CARD)) {
                return card;
            }
        }
        return new EmptyCard();
    }

    @Override
    public ICategory findBestCategory(IPlayer player, ICategory[] choices) {
        IAveragePercentOfRangeCalculator averagePercentOfRangeCalculator = new AveragePercentOfRangeCalculator();
        for(ICard card: player.getPlayerHand().getCards()){
            if(card.getType().equals(CardType.PLAY_CARD)){
                averagePercentOfRangeCalculator.addStats(card.getStats());
            }
        }
        IAveragePercentOfRangeResult averagePercentOfRangeResult = averagePercentOfRangeCalculator.calculateAverage();


        return averagePercentOfRangeResult.getCategoryOfHighestPercentage(choices);
    }
}
