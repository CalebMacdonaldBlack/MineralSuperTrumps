package cmblack.card.trumpcard;

import cmblack.category.Category;
import cmblack.category.ICategory;
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
        ICategory[] categories = new Category[categorieNames.length];
        for(int i=0;i<categorieNames.length;i++){
            categories[i] = new Category(categorieNames[i]);
        }
        return categories;
    }
}
