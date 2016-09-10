package cmblack.card.playcard;

import cmblack.card.CardDescription;
import cmblack.card.ICardDescription;
import cmblack.card.stats.IStats;
import cmblack.card.stats.IStatsBuilder;
import cmblack.card.stats.Stats;
import cmblack.card.stats.StatsBuilder;
import cmblack.category.cleavage.ICleavageBuilder;
import cmblack.category.crustalabundance.ICrustalAbundanceBuilder;
import cmblack.category.economicvalue.IEconomicValueBuilder;
import cmblack.category.hardness.IHardnessBuilder;
import cmblack.category.specificgravity.ISpecificGravityBuilder;
import cmblack.deck.IParsedCard;

/**
 * Created by calebmacdonaldblack on 10/09/2016.
 */
public class PlayCardBuilder implements IPlayCardBuilder{


    private final IStatsBuilder statsBuilder;

    public PlayCardBuilder() {
        this(new StatsBuilder());
    }

    public PlayCardBuilder(IStatsBuilder statsBuilder) {
        this.statsBuilder = statsBuilder;
    }

    @Override
    public IPlayCard build(IParsedCard parsedCard) {
        return new PlayCard(
                parsedCard.getTitle(),
                parsedCard.getFileName(),
                this.statsBuilder.build(parsedCard),
                this.createCardDescription(parsedCard)
        );
    }


    private ICardDescription createCardDescription(IParsedCard parsedCard) {
        return new CardDescription(
                parsedCard.getChemistry(),
                parsedCard.getClassification(),
                parsedCard.getCrystal_system(),
                parsedCard.getOccurrence()
        );
    }
}
