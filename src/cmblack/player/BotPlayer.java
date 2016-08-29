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
    public PlayCard getCardToPlay(String selectedCategoryName, PlayCard currentCard, Deck deck, ArrayList<Player> playersInCurrentTurn) {
        if(currentCard == null){
            selectedCategoryName = selectCategoryName();
        }

        currentCard = findValidCardToPlay(currentCard, selectedCategoryName);
        return currentCard;
    }

    private PlayCard findValidCardToPlay(PlayCard currentCard, String selectedCategory) {
        for(Card card: this.getCards()){
            System.out.println(card instanceof PlayCard);
            System.out.println(((PlayCard) card).getPlayCardStats().getCategoryWithName(selectedCategory).getName());
            System.out.println(currentCard.getPlayCardStats().getCategoryWithName(selectedCategory).getName());
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
