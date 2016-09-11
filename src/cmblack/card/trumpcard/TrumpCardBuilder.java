package cmblack.card.trumpcard;

import cmblack.category.Category;
import cmblack.category.ICategory;
import cmblack.category.cleavage.CleavageCategory;
import cmblack.category.crustalabundance.CrustalAbundanceCategory;
import cmblack.category.economicvalue.EconomicValueCategory;
import cmblack.category.hardness.HardnessCategory;
import cmblack.category.specificgravity.SpecificGravityCategory;
import cmblack.deck.deckbuilder.IParsedCard;

/**
 * Created by calebmacdonaldblack on 10/09/2016.
 */
public class TrumpCardBuilder implements ITrumpCardBuilder {
    @Override
    public ITrumpCard build(IParsedCard parsedCard) {
        return new TrumpCard(
                parsedCard.getTitle(),
                parsedCard.getSubTitle(),
                parsedCard.getFileName(),
                this.BuildCategories(parsedCard.getCategories())
        );
    }

    private ICategory[] BuildCategories(String[] categorieNames) {
        ICategory[] categories = new ICategory[categorieNames.length];
        for(int i=0;i<categorieNames.length;i++){
            switch(categorieNames[i]){
                case "Hardness":
                    categories[i] = new HardnessCategory();
                    break;
                case "Specific gravity":
                    categories[i] = new SpecificGravityCategory();
                    break;
                case "Cleavage":
                    categories[i] = new CleavageCategory();
                    break;
                case "Crustal abundance":
                    categories[i] = new CrustalAbundanceCategory();
                    break;
                case "Economic value":
                    categories[i] = new EconomicValueCategory();
                    break;
                default:
                    throw new NullPointerException("Cannot find a category with the name: " + categorieNames[i]);

            }
        }
        return categories;
    }
}
