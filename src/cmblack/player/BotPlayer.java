package cmblack.player;

import cmblack.player.playerhand.IPlayerHand;

/**
 * Created by calebmacdonaldblack on 10/09/2016.
 */

public class BotPlayer implements IPlayer {

    private final String name;
    private final IPlayerHand playerHand;

    public BotPlayer(String name, IPlayerHand playerHand) {
        this.name = name;
        this.playerHand = playerHand;
    }

    @Override
    public IPlayerHand getPlayerHand() {
        return playerHand;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(IPlayer player) {
        return name.equals(player.getName());
    }

    @Override
    public PlayerType getPlayerType() {
        return PlayerType.BOT;
    }
}

//public class BotPlayer {
//    private final ArrayList<ICard> cards = new ArrayList<>();
//    private final String name;
//
//    public BotPlayer(String name) {
//        this.name = name;
//    }
//
//    @Override
//    public IPlayer addCard(ICard card) {
//        this.cards.add(card);
//        return this;
//    }
//
//    @Override
//    public IPlayer playCard(ICard cardToBeat, ICategory currentTrumpCategory, IRoundActions roundActions) {
//
//        boolean cardPlayed = false;
//
//        if(currentTrumpCategory.equals(new EmptyCategory())){
//            throw new NullPointerException("Cannot not choose card with empty category");
//        }
//        for(ICard card: cards.toArray(new ICard[cards.size()])){
//            CategoryComparisonResult categoryComparisonResult = card.getStats().compareWith(cardToBeat.getStats());
//            if(categoryComparisonResult.valueForCategory(currentTrumpCategory) > 0){
//
//                this.cards.remove(card);
//                roundActions.playACard(card);
//                cardPlayed = true;
//                break;
//            }else if(card.getType().equals(CardType.TRUMP_CARD)){
//                this.cards.remove(card);
//                roundActions.playACard(card);
//                roundActions.changeCategory(chooseCategory(card.changeableTrumpCategories()));
//                cardPlayed = true;
//                break;
//            }
//
//        }
//        if(!cardPlayed){
//            roundActions.removeAPlayer(this);
//            roundActions.drawACard(this);
//        }
//        if(getCountOfCards() == 0){
//            roundActions.removePlayerFromGame(this);
//        }
//        roundActions.turnEnded(this);
//        return this;
//    }
//
//    @Override
//    public String getName() {
//        return this.name;
//    }
//
//    @Override
//    public boolean equals(IPlayer player) {
//        return this.name.equals(player.getName());
//    }
//
//    @Override
//    public ICategory chooseCategory(ICategory[] changeableCategories) {
//
//        return this.pickCategoryWherePlayerHasHighestAverage(changeableCategories);
//    }
//
//    @Override
//    public ICategory chooseCategory() {
//        return chooseCategory(new ICategory[]{
//                new CleavageCategory(),
//                new CrustalAbundanceCategory(),
//                new EconomicValueCategory(),
//                new HardnessCategory(),
//                new SpecificGravityCategory()
//        });
//    }
//
//    @Override
//    public int getCountOfCards() {
//        return this.cards.size();
//    }
//
//    @Override
//    public IPlayer giveCard(ICard card) {
//        if(!card.equals(new EmptyCard())){
//            this.cards.add(card);
//        }
//        return this;
//    }
//
//    @Override
//    public ArrayList<ICard> getCards() {
//        return this.cards;
//    }
//
//    private ICategory pickCategoryWherePlayerHasHighestAverage(ICategory[] categories) {
//        IAveragePercentOfRangeCalculator averagePercentOfRangeCalculator = new AveragePercentOfRangeCalculator();
//        for(ICard card: cards){
//            if(card.getType().equals(CardType.PLAY_CARD)){
//                averagePercentOfRangeCalculator.addStats(card.getStats());
//            }
//        }
//        IAveragePercentOfRangeResult averagePercentOfRangeResult = averagePercentOfRangeCalculator.calculateAverage();
//
//
//        return averagePercentOfRangeResult.getCategoryOfHighestPercentage(categories);
//    }
//}
