package App.Models.Card;

import App.Models.TrumpCategory;

/**
 * Created by calebmacdonaldblack on 29/09/2016.
 */
public class RegularCard extends Card{
    public RegularCard(String title, String description, Range hardness, Range specificGravity, Cleavage cleavage, CrustalAbundance crustalAbundance, EconomicValue economicValue) {
        super(title, description, hardness, specificGravity, cleavage, crustalAbundance, economicValue, new TrumpCategory[]{}, CardType.REGULAR);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append("===========Card==========\n");
        output.append("Title: " + getTitle() + "\n");
        output.append(getDescription() + "\n");
        output.append("-------------------------\n");
        output.append("Hardness: " + getHardness().getLowValue() + " - " + getHardness().getHighValue() + "\n");
        output.append("Specific Gravity: " + getSpecificGravity().getLowValue() + " - " + getSpecificGravity().getHighValue() + "\n");
        output.append("Cleavage: " + getCleavage().getText() + "\n");
        output.append("Crustal Abundance: " + getCrustalAbundance().getText() + "\n");
        output.append("Economic Value: " + getEconomicValue().getText() + "\n");
        output.append("=========================\n");
        return output.toString();
    }
}
