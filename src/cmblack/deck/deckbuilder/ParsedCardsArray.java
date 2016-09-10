package cmblack.deck.deckbuilder;

/**
 * Created by calebmacdonaldblack on 24/08/2016.
 */

public class ParsedCardsArray {
    private ParsedCard[] cards;

    public ParsedCardsArray(ParsedCard[] cards) {
        this.cards = cards;
    }

    public ParsedCard[] getCards(){
        return this.cards;
    }
}