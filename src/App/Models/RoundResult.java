package App.Models;

import App.Models.Card.Card;

/**
 * Created by calebmacdonaldblack on 2/10/16.
 */
public class RoundResult {
    private final Player player;
    private final TrumpCategory category;
    private final RoundResultType roundResultType;
    private final Card currentCard;

    /**
     * Creates a new instance of a round result
     *
     * @param player          The player to start the next round
     * @param category        The category of the next round
     * @param roundResultType How the round ended. If trump, starting player doesn't select a card. otherwise they do
     * @param currentCard     the current card for the finished round
     */
    public RoundResult(Player player, TrumpCategory category, RoundResultType roundResultType, Card currentCard) {
        this.player = player;
        this.category = category;
        this.roundResultType = roundResultType;
        this.currentCard = currentCard;
    }

    /**
     * Gets the current card from the rounf
     *
     * @return currentCard
     */
    public Card getCurrentCard() {
        return currentCard;
    }

    /**
     * Gets winning player
     *
     * @return Winning player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Gets the trump category to start the next round with
     *
     * @return Trump category
     */
    public TrumpCategory getCategory() {
        return category;
    }

    /**
     * Gets the round result type
     *
     * @return Round result type
     */
    public RoundResultType getRoundResultType() {
        return roundResultType;
    }

    public enum RoundResultType {
        NORMAL,
        START, TRUMP
    }
}
