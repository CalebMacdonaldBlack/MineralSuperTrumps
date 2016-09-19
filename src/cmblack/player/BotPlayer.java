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
import cmblack.controller.IRoundActions;

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
    public void playCard(ICard cardToBeat, ICategory currentTrumpCategory, IRoundActions roundActions) {

        boolean cardPlayed = false;

        if(currentTrumpCategory.equals(new EmptyCategory())){
            throw new NullPointerException("Cannot not choose card with empty category");
        }
        for(ICard card: cards.toArray(new ICard[cards.size()])){
            CategoryComparisonResult categoryComparisonResult = card.getStats().compareWith(cardToBeat.getStats());
            if(categoryComparisonResult.valueForCategory(currentTrumpCategory) > 0){

                this.cards.remove(card);
                roundActions.playACard(card);
                cardPlayed = true;
                break;
            }else if(card.getType().equals(CardType.TRUMP_CARD)){
                roundActions.playACard(card);
                roundActions.changeCategory(chooseCategory());
                cardPlayed = true;
                break;
            }

        }
        if(!cardPlayed){
            roundActions.removeAPlayer(this);
            roundActions.drawACard(this);
        }
        if(getCountOfCards() == 0){
            roundActions.removePlayerFromGame(this);
        }
        roundActions.turnEnded(this);
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
