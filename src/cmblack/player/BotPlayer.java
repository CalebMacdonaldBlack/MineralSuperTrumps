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

    public BotPlayer(String bot1) {
        this(bot1, new ArrayList<Card>());
    }

    @Override
    public Card getCardToPlay(String selectedCategoryName, Card currentCard, Deck deck) {

        return findValidCardToPlay(currentCard, selectedCategoryName);
    }

    private Card findValidCardToPlay(Card currentCard, String selectedCategory) {
        if(currentCard == null){
            for(Card card: this.getCards()){
                if (card instanceof PlayCard){
                    this.getCards().remove(card);
                    return card;
                }
            }
        }

        for(Card card: this.getCards()){
            if(card instanceof PlayCard && ((PlayCard) card).getPlayCardStats().getCategoryWithName(selectedCategory).isBetterThan(((PlayCard) currentCard).getPlayCardStats().getCategoryWithName(selectedCategory))){
                this.getCards().remove(card);
                return card;
            }
        }

        for(Card card: this.getCards()){
            if(card instanceof TrumpCard){
                this.getCards().remove(card);
                return card;
            }
        }

        return null;
    }

    @Override
    public String chooseCategory() {
        return chooseCategory(Category.Categories.getCategoriesAsStringArray());
    }

    @Override
    public String chooseCategory(String[] categories) {
        Random random = new Random();
        return categories[random.nextInt(categories.length)];
    }
}
