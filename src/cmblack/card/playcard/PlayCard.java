package cmblack.card.playcard;

import cmblack.card.CardType;
import cmblack.card.ICard;
import cmblack.card.playcard.carddescription.ICardDescription;
import cmblack.card.stats.IStats;
import cmblack.category.ICategory;

/**
 * Created by calebmacdonaldblack on 23/08/2016.
 */
public class PlayCard implements IPlayCard {
    private final IStats playCardStats;
    private final String title;
    private final String imageFileName;
    private final ICardDescription cardDescription;

    public PlayCard(String title, String imageFileName, IStats playCardStats, ICardDescription cardDescription) {
        this.title = title;
        this.imageFileName = imageFileName;
        this.playCardStats = playCardStats;
        this.cardDescription = cardDescription;
    }

    @Override
    public ICardDescription getCardDescription() {
        return this.cardDescription;
    }

    @Override
    public IStats getStats() {
        return this.playCardStats;
    }

    @Override
    public boolean equals(ICard card) {
        return this.title.equals(card.getTitle())
            && this.imageFileName.equals(card.getImageFilename())
            && this.playCardStats.equals(card.getStats())
            && card.getType().equals(CardType.PLAY_CARD);
    }

    @Override
    public ICategory[] changeableTrumpCategories() {
        return new ICategory[0];
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
        return CardType.PLAY_CARD;
    }
}
