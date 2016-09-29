package App.Models.Card;

import App.Models.TrumpCategory;

/**
 * Created by calebmacdonaldblack on 29/09/2016.
 */
public class TrumpCard extends Card {
    public TrumpCard(String title, String description, TrumpCategory[] trumpCategories) {
        super(title, description, new Range(-1,-1), new Range(-1,-1), Cleavage.TRUMPCARD, CrustalAbundance.TRUMPCARD, EconomicValue.TRUMPCARD, trumpCategories, CardType.TRUMP);
    }
}
