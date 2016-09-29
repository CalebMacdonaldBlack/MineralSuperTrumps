package App.Models.Card;

import App.Models.TrumpCategory;

/**
 * Created by calebmacdonaldblack on 29/09/2016.
 */
public class RegularCard extends Card{
    public RegularCard(String title, String description, Range hardness, Range specificGravity, Cleavage cleavage, CrustalAbundance crustalAbundance, EconomicValue economicValue) {
        super(title, description, hardness, specificGravity, cleavage, crustalAbundance, economicValue, new TrumpCategory[]{}, CardType.REGULAR);
    }
}
