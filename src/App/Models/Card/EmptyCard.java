package App.Models.Card;

import App.Models.TrumpCategory;

/**
 * Created by calebmacdonaldblack on 29/09/2016.
 */
public class EmptyCard extends Card {
    public EmptyCard() {
        super("", "", new Range(-1,-1), new Range(-1,-1), Cleavage.TRUMPCARD, CrustalAbundance.TRUMPCARD, EconomicValue.TRUMPCARD, new TrumpCategory[]{}, CardType.EmptyCard);
    }
}
