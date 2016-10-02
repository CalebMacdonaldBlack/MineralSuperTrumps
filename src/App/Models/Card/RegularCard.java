package App.Models.Card;

import App.Models.TrumpCategory;

/**
 * Created by calebmacdonaldblack on 29/09/2016.
 */
public class RegularCard extends Card{

    /**
     * Creates a new instance of Regular Card
     * @param title Card title
     * @param description Card description: Chemistry, occurrence, crystal system
     * @param hardness Hardness range
     * @param specificGravity Specific gravity range
     * @param cleavage Cleavage range
     * @param crustalAbundance Crustal abundance range
     * @param economicValue Economic value range
     */
    public RegularCard(String title, String description, Range hardness, Range specificGravity, Cleavage cleavage, CrustalAbundance crustalAbundance, EconomicValue economicValue) {
        super(title, description, hardness, specificGravity, cleavage, crustalAbundance, economicValue, new TrumpCategory[]{}, CardType.REGULAR);
    }

    /**
     * Used for outputting the card to the console
     *
     * @return String representation of a card
     */
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
