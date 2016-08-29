package cmblack.player;

import cmblack.card.Card;
import cmblack.card.PlayCard;
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
    public void haveTurn(String selectedCategoryName, PlayCard currentCard, Deck deck, ArrayList<Player> playersInCurrentTurn) {
        if(currentCard == null){
            selectedCategoryName = selectCategoryName();
        }

        currentCard = findValidCardToPlay(currentCard, selectedCategoryName);
    }

    private PlayCard findValidCardToPlay(PlayCard currentCard, String selectedCategory) {
        for(Card card: this.getCards()){

            if(card instanceof PlayCard && ((PlayCard) card).getPlayCardStats().getCategoryWithName(selectedCategory).isBetterThan(currentCard.getPlayCardStats().getCategoryWithName(selectedCategory))){
                return (PlayCard) card;
            }
        }
        return null;
    }


    private String selectCategoryName() {
        Random random = new Random();
        return Category.Categories.values()[random.nextInt(Category.Categories.values().length)].getName();
    }
}
