package cmblack.player;

import cmblack.card.Card;
import cmblack.card.PlayCard;
import cmblack.card.TrumpCard;
import cmblack.category.Category;
import cmblack.deck.Deck;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by calebmacdonaldblack on 26/08/2016.
 */
public class BotPlayer extends Player {
    public BotPlayer(String playerName, ArrayList<Card> cards) {
        super(playerName, cards);
    }

    @Override
    public Card getCardToPlay(String selectedCategoryName, PlayCard currentCard, Deck deck, ArrayList<Player> playersInCurrentTurn) {
        if(currentCard == null){
            selectedCategoryName = selectCategoryName();
        }

        Card foundCard = findValidCardToPlay(currentCard, selectedCategoryName);
        if(foundCard == null){
            //TODO refactor this out. It doesn't belong here
            playersInCurrentTurn.remove(this);
            return currentCard;
        }
        return foundCard;
    }

    private Card findValidCardToPlay(PlayCard currentCard, String selectedCategory) {
        for(Card card: this.getCards()){
            if(card instanceof PlayCard && ((PlayCard) card).getPlayCardStats().getCategoryWithName(selectedCategory).isBetterThan(currentCard.getPlayCardStats().getCategoryWithName(selectedCategory))){
                return card;
            }
        }

        for(Card card: this.getCards()){
            if(card instanceof TrumpCard){
                return card;
            }
        }

        return null;
    }


    private String selectCategoryName() {
        Random random = new Random();
        return Category.Categories.values()[random.nextInt(Category.Categories.values().length)].getName();
    }
}
