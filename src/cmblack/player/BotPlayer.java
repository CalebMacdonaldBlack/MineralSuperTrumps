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
import cmblack.category.cleavage.CleavageCategory;
import cmblack.category.crustalabundance.CrustalAbundanceCategory;
import cmblack.category.economicvalue.EconomicValueCategory;
import cmblack.category.hardness.HardnessCategory;
import cmblack.category.specificgravity.SpecificGravityCategory;
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
    public IPlayer playCard(ICard cardToBeat, ICategory currentTrumpCategory, IRoundActions roundActions) {

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
                this.cards.remove(card);
                roundActions.playACard(card);
                roundActions.changeCategory(chooseCategory(card.changeableTrumpCategories()));
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
        return this;
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
    public ICategory chooseCategory(ICategory[] changeableCategories) {

        return this.pickCategoryWherePlayerHasHighestAverage(changeableCategories);
    }

    @Override
    public ICategory chooseCategory() {
        return chooseCategory(new ICategory[]{
                new CleavageCategory(),
                new CrustalAbundanceCategory(),
                new EconomicValueCategory(),
                new HardnessCategory(),
                new SpecificGravityCategory()
        });
    }

    @Override
    public int getCountOfCards() {
        return this.cards.size();
    }

    @Override
    public IPlayer giveCard(ICard card) {
        if(!card.equals(new EmptyCard())){
            this.cards.add(card);
        }
        return this;
    }

    @Override
    public ArrayList<ICard> getCards() {
        return this.cards;
    }

    private ICategory pickCategoryWherePlayerHasHighestAverage(ICategory[] categories) {
        IAveragePercentOfRangeCalculator averagePercentOfRangeCalculator = new AveragePercentOfRangeCalculator();
        for(ICard card: cards){
            if(card.getType().equals(CardType.PLAY_CARD)){
                averagePercentOfRangeCalculator.addStats(card.getStats());
            }
        }
        IAveragePercentOfRangeResult averagePercentOfRangeResult = averagePercentOfRangeCalculator.calculateAverage();


        return averagePercentOfRangeResult.getCategoryOfHighestPercentage(categories);
    }
}
