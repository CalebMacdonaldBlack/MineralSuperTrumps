package App.Models;

import App.Models.Card.Card;

import java.util.Random;

/**
 * Created by calebmacdonaldblack on 29/09/2016.
 */
public class BotAI {

    /**
     * Ai chooses a category at random
     *
     * @param categories The categories it can choose from
     * @return A single trump category
     */
    public TrumpCategory getCategory(TrumpCategory[] categories) {
        stall();
        return categories[new Random().nextInt(categories.length)];
    }

    /**
     * Ai chooses a valid card at random or doesn't play a card
     *
     * @param player          The current player
     * @param currentCategory The current category
     * @param currentCard     The current card
     * @return Either the same card or a new card from the current player
     */
    public Card getCard(Player player, TrumpCategory currentCategory, Card currentCard) {

        for (Card card : player.getCards().toArray(new Card[player.getCards().size()])) {
            if (card.isBetterThan(currentCard, currentCategory)) {
                player.getCards().remove(card);
                stall();
                return card;
            }
        }
        for (Card card : player.getCards().toArray(new Card[player.getCards().size()])) {
            if (card.getCardType().equals(Card.CardType.TRUMP)) {
                player.getCards().remove(card);
                stall();
                return card;
            }
        }
        return currentCard;
    }

    /**
     * Slows down the Ai response
     */
    private void stall() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
