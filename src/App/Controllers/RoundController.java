package App.Controllers;

import App.Models.Card.Card;
import App.Models.TrumpCategory;

/**
 * Created by calebmacdonaldblack on 29/09/2016.
 */
public interface RoundController {

    /**
     * Callback method for view to select a trump category
     *
     * @param category The category to change to
     */
    void selectCategory(TrumpCategory category);

    /**
     * Callback method for view to select a card
     *
     * @param currentCard The newly selected card
     */
    void selectCard(Card currentCard);
}
