package cmblack.player;

import cmblack.card.Card;
import cmblack.card.PlayCard;
import cmblack.card.TrumpCard;
import cmblack.category.Category;
import cmblack.deck.Deck;
import cmblack.game.Round;

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

    public void findValidCardToPlay(Round round) {


        //TODO instance of is bad don't use it
        if(round.getCurrentCard() == null || round.getCurrentCard() instanceof TrumpCard){
            for(Card card: new ArrayList<>(this.getCards())){
                //TODO move this functionality into a method on the interface
                // playCard.isGoodChoice(comparingCard, Category) returns true or false
                // trumpCard.isGoodChoice(comparingCard, Category) returns false always
                // playCard.isGoodChoiceForLastResort() returns false always
                // trumpCard.isGoodChoiceForLastResort() returns true always
                if (card instanceof PlayCard){
                    this.removeCard(card, round);
                    round.setCurrentCard(card);
                    System.out.println(getPlayerName() + ": Selecting the first card: " + card.getTitle());
                    return;
                }
            }
        }

        for(Card card: new ArrayList<>(this.getCards())){
            if(card instanceof PlayCard && ((PlayCard) card).getPlayCardStats().getCategoryWithName(round.getCategory()).isBetterThan(((PlayCard) round.getCurrentCard()).getPlayCardStats().getCategoryWithName(round.getCategory()))){
                this.removeCard(card, round);
                System.out.println("Current Card: " + round.getCurrentCard().getTitle());
                round.setCurrentCard(card);
                System.out.println(getPlayerName() + ": selecting better card: " + card.getTitle());
                return;
            }
        }

        for(Card card: new ArrayList<>(this.getCards())){
            if(card instanceof TrumpCard){
                this.removeCard(card, round);
                System.out.println("Current Card: " + round.getCurrentCard().getTitle());
                round.setCurrentCard(card);
                System.out.println(getPlayerName() + ": choosing trump card: " + card.getTitle());
                return;
            }
        }

        System.out.println(getPlayerName() + ": cannot find a card to play");
        round.getPlayerCircle().remove(this);
        this.getCards().add(round.getDeck().takeCard());
    }

    public String chooseCategory() {
        return chooseCategory(Category.Categories.getCategoriesAsStringArray());
    }

    private String chooseCategory(String[] categories) {
        Random random = new Random();
        return categories[random.nextInt(categories.length)];
    }

    @Override
    public void haveTurn(Round round) {
        initializeRound(round);
        findValidCardToPlay(round);
    }

    @Override
    public void removeCard(Card card, Round round) {
        this.getCards().remove(card);
        if(this.getCards().size() == 0){
            round.addWinner(this);
        }
    }

    private void initializeRound(Round round) {
        System.out.println(this.getPlayerName() + ": Checking category");
        if(round.getCategory() == null){
            round.setCategory(this.chooseCategory());

            System.out.println(this.getPlayerName() + ": No current category. selected: " + round.getCategory());
        }
    }
}
