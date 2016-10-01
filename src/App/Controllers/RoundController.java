package App.Controllers;

import App.Models.Card.Card;
import App.Models.TrumpCategory;

/**
 * Created by calebmacdonaldblack on 29/09/2016.
 */
public interface RoundController {
    void selectCategory(TrumpCategory category);

    void selectCard(Card currentCard);
}
