package App.Models.Card;

import App.Models.TrumpCategory;

/**
 * Created by calebmacdonaldblack on 29/09/2016.
 */
public class TrumpCard extends Card {
    public TrumpCard(String title, String description, TrumpCategory[] trumpCategories) {
        super(title, description, new Range(-1,-1), new Range(-1,-1), Cleavage.TRUMPCARD, CrustalAbundance.TRUMPCARD, EconomicValue.TRUMPCARD, trumpCategories, CardType.TRUMP);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append("========Trump Card=======\n");
        output.append("Title: " + getTitle() + "\n");
        output.append(getDescription() + "\n");
        output.append("-------------------------\n");
        output.append("Changes category to: \n");
        for(TrumpCategory category: getTrumpCategories()){
            output.append("- " + category.getText() + "\n");
        }
        output.append("========================\n");
        return output.toString();
    }
}
