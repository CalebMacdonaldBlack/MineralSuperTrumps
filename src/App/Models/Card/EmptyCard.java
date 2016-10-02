package App.Models.Card;

import App.Models.TrumpCategory;

/**
 * Created by calebmacdonaldblack on 29/09/2016.
 */
public class EmptyCard extends Card {

    /**
     * Creates a new instance of an empty card. Used instead of null to assist in debugging
     */
    public EmptyCard() {
        super("", "", new Range(-1, -1), new Range(-1, -1), Cleavage.TRUMPCARD, CrustalAbundance.TRUMPCARD, EconomicValue.TRUMPCARD, new TrumpCategory[]{}, CardType.EmptyCard);
    }

    /**
     * Used for outputting the card to the console
     *
     * @return String representation of a card
     */
    @Override
    public String toString() {
        return "No current card. Play any card.";
    }
}
