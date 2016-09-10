package cmblack.card.trumpcard;

import cmblack.card.CardType;
import cmblack.card.ICard;
import cmblack.card.stats.IStats;
import cmblack.category.ICategory;

/**
 * Created by calebmacdonaldblack on 22/08/2016.
 */
public class TrumpCard implements ITrumpCard {
    private final ICategory[] categories;
    private final String subTitle;
    private final String title;
    private final String imageFileName;

    public TrumpCard(String title, String subTitle, String imageFilename, ICategory[] categories) {
        this.categories = categories;
        this.subTitle = subTitle;
        this.title = title;
        this.imageFileName = imageFilename;
    }

    @Override
    public ICategory[] getCategories() {
        return this.categories;
    }

    @Override
    public String getSubTitle() {
        return this.subTitle;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public String getImageFilename() {
        return this.imageFileName;
    }

    @Override
    public CardType getType() {
        return CardType.TRUMP_CARD;
    }

    @Override
    public IStats getStats() {
        return new TrumpCardStats();
    }

    @Override
    public boolean equals(ICard card) {
        return card.getImageFilename().equals(this.imageFileName)
            && card.getTitle().equals(this.title)
            && card.getType().equals(CardType.TRUMP_CARD)
            && card.getStats().equals(this.getStats());
    }

}
