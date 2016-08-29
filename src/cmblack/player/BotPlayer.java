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
    public void haveTurn(Category selectedCategory, Card currentCard, Deck deck, ArrayList<Player> playersInCurrentTurn) {
        if(currentCard == null){
            selectedCategory = selectCategory();
        }

        findCardWithHighestCategory(currentCard, selectedCategory);
    }

    private Card findCardWithHighestCategory(Card currentCard, Category selectedCategory) {
        this.getCards().stream().filter(card -> card instanceof PlayCard).forEach(card -> {
            Category selectedCardsCategory;
            Category comparingCategory = ((PlayCard) card).getPlayCardStats().getCategoryWithName(selectedCategory.getName());

        });
        return null;
    }

    private Category selectCategory() {
        Random random = new Random();
        return Category.Categories.values()[random.nextInt(Category.Categories.values().length)].getCategory();
    }
}
