package cmblack.card.playcard;

import cmblack.card.CardDescription;
import cmblack.card.playcard.carddescription.CardDescriptionBuilder;
import cmblack.card.playcard.carddescription.ICardDescription;
import cmblack.card.playcard.carddescription.ICardDescriptionBuilder;
import cmblack.card.stats.IStatsBuilder;
import cmblack.card.stats.StatsBuilder;
import cmblack.deck.IParsedCard;

/**
 * Created by calebmacdonaldblack on 10/09/2016.
 */
public class PlayCardBuilder implements IPlayCardBuilder{


    private final IStatsBuilder statsBuilder;
    private final ICardDescriptionBuilder cardDescriptionBuilder;

    public PlayCardBuilder() {
        this(new StatsBuilder(), new CardDescriptionBuilder());
    }

    public PlayCardBuilder(IStatsBuilder statsBuilder, ICardDescriptionBuilder cardDescriptionBuilder) {
        this.statsBuilder = statsBuilder;
        this.cardDescriptionBuilder = cardDescriptionBuilder;
    }

    @Override
    public IPlayCard build(IParsedCard parsedCard) {
        return new PlayCard(
                parsedCard.getTitle(),
                parsedCard.getFileName(),
                this.statsBuilder.build(parsedCard),
                this.cardDescriptionBuilder.build(parsedCard)
        );
    }
}
