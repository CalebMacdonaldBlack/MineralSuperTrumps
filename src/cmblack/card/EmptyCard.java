package cmblack.card;

import cmblack.card.stats.EmptyStats;
import cmblack.card.stats.IStats;

/**
 * Created by calebmacdonaldblack on 10/09/2016.
 */
public class EmptyCard implements ICard {
    @Override
    public String getTitle() {
        return "";
    }

    @Override
    public String getImageFilename() {
        return "";
    }

    @Override
    public CardType getType() {
        return CardType.EMPTY_CARD;
    }

    @Override
    public IStats getStats() {
        return new EmptyStats();
    }
}
