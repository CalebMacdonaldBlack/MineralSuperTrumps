package cmblack.deck.deckbuilder;

import cmblack.card.ICard;
import cmblack.card.playcard.IPlayCardBuilder;
import cmblack.card.playcard.PlayCardBuilder;
import cmblack.card.trumpcard.ITrumpCardBuilder;
import cmblack.card.trumpcard.TrumpCardBuilder;
import cmblack.deck.Deck;
import cmblack.deck.IDeck;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Created by calebmacdonaldblack on 24/08/2016.
 */
public class JSONDeckBuilder implements IDeckBuilder {

    private final JsonReader jsonReader;
    private final IPlayCardBuilder playCardBuilder;
    private final ITrumpCardBuilder trumpCardBuilder;

    public JSONDeckBuilder(
            JsonReader jsonReader,
            IPlayCardBuilder playCardBuilder,
            ITrumpCardBuilder trumpCardBuilder
    ) throws FileNotFoundException {

        this.jsonReader = jsonReader;
        this.playCardBuilder = playCardBuilder;
        this.trumpCardBuilder = trumpCardBuilder;
    }

    public JSONDeckBuilder(JsonReader jsonReader) throws FileNotFoundException {
        this(jsonReader, new PlayCardBuilder(), new TrumpCardBuilder());
    }

    @Override
    public IDeck build() {
        ArrayList<ICard> cards = new ArrayList<ICard>();

        //TODO error handing the crap out of this

        for (ParsedCard parsedCard : ((ParsedCardsArray) new Gson().fromJson(jsonReader, ParsedCardsArray.class)).getCards()) {
            if (parsedCard.getChemistry() != null) {
                cards.add(this.playCardBuilder.build(parsedCard));
            } else {
                cards.add(this.trumpCardBuilder.build(parsedCard));
            }
        }
        return new Deck(cards);
    }
}
