package App.Models;

import App.Models.Card.Card;

import java.util.Random;

/**
 * Created by calebmacdonaldblack on 29/09/2016.
 */
public class BotAI {
    public TrumpCategory getCategory(TrumpCategory[] categories){
        return categories[new Random().nextInt(categories.length)];
    }

    public Card getCard(Player player, TrumpCategory currentCategory, Card currentCard){
        for(Card card: player.getCards().toArray(new Card[player.getCards().size()])){
            if(card.isBetterThan(currentCard, currentCategory)){
                player.getCards().remove(card);
                return card;
            }
        }
        for(Card card: player.getCards().toArray(new Card[player.getCards().size()])){
            if(card.getCardType().equals(Card.CardType.TRUMP)){
                player.getCards().remove(card);
                return card;
            }
        }
        return currentCard;
    }
}
