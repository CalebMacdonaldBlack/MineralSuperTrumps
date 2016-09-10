package cmblack.card.playcard;

import cmblack.card.CardDescription;
import cmblack.card.ICardDescription;
import cmblack.card.stats.IStats;
import cmblack.card.stats.Stats;
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

    private final ICleavageBuilder cleavageBuilder;
    private final ICrustalAbundanceBuilder crustalAbundanceBuilder;
    private final IEconomicValueBuilder economicValueBuilder;
    private final IHardnessBuilder hardnessBuilder;
    private final ISpecificGravityBuilder specificGravityBuilder;

    public PlayCardBuilder(
            ICleavageBuilder cleavageBuilder,
            ICrustalAbundanceBuilder crustalAbundanceBuilder,
            IEconomicValueBuilder economicValueBuilder,
            IHardnessBuilder hardnessBuilder,
            ISpecificGravityBuilder specificGravityBuilder
    ){
        this.cleavageBuilder = cleavageBuilder;
        this.crustalAbundanceBuilder = crustalAbundanceBuilder;
        this.economicValueBuilder = economicValueBuilder;
        this.hardnessBuilder = hardnessBuilder;
        this.specificGravityBuilder = specificGravityBuilder;
    }

    @Override
    public IPlayCard build(IParsedCard parsedCard) {
        return new PlayCard(
                parsedCard.getTitle(),
                parsedCard.getFileName(),
                this.createPlayCardStats(parsedCard),
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

    private IStats createPlayCardStats(IParsedCard parsedCard) {
        return new Stats(
                this.cleavageBuilder.build(parsedCard.getCleavage()),
                this.crustalAbundanceBuilder.build(parsedCard.getCrustal_abundance()),
                this.economicValueBuilder.build(parsedCard.getEconomic_value()),
                this.hardnessBuilder.build(parsedCard.getHardness()),
                this.specificGravityBuilder.build(parsedCard.getSpecific_gravity())

        );
    }
}
