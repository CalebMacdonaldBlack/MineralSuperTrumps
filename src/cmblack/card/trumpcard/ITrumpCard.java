package cmblack.card.trumpcard;

import cmblack.card.ICard;

/**
 * Created by calebmacdonaldblack on 9/09/2016.
 */
public interface ITrumpCard extends ICard {
    String[] getCategories();
    String getSubTitle();
}