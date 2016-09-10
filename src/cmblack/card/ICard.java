package cmblack.card;

import cmblack.card.playcard.CardType;
import cmblack.card.stats.IStats;

/**
 * Created by calebmacdonaldblack on 23/08/2016.
 */
public interface ICard {

    String getTitle();

    String getImageFilename();

    //Todo stats for both trump and playCard

    //TODO comparing stats returns a statsResult with all comparison
    //TODO return the comparingStats as an object

    CardType type();


    IStats getPlayCardStats();
}
