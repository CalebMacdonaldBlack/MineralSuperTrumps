package cmblack.card.playcard;

import cmblack.card.ICardDescription;
import cmblack.card.playcard.playcardstats.IPlayCardStats;
import cmblack.card.playcard.playcardstats.PlayCardStats;

/**
 * Created by calebmacdonaldblack on 23/08/2016.
 */
public class PlayCard implements IPlayCard {
    private final IPlayCardStats playCardStats;
    private final String title;
    private final String imageFileName;
    private final ICardDescription cardDescription;

    public PlayCard(String title, String imageFileName, IPlayCardStats playCardStats, ICardDescription cardDescription) {
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
    public IPlayCardStats getPlayCardStats() {
        return this.playCardStats;
    }

    @Override
    public boolean equals(IPlayCard playCard) {
        return this.title.equals(playCard.getTitle())
            && this.imageFileName.equals(playCard.getImageFilename())
            && this.playCardStats.equals(playCard.getPlayCardStats())
            && this.cardDescription.equals(playCard.getCardDescription());
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public String getImageFilename() {
        return this.imageFileName;
    }
}
