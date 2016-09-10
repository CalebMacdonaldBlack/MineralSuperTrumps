package cmblack.card.stats;

import cmblack.category.cleavage.CleavageBuilder;
import cmblack.category.cleavage.ICleavageBuilder;
import cmblack.category.crustalabundance.CrustalAbundanceBuilder;
import cmblack.category.crustalabundance.ICrustalAbundanceBuilder;
import cmblack.category.economicvalue.EconomicValueBuilder;
import cmblack.category.economicvalue.IEconomicValueBuilder;
import cmblack.category.hardness.HardnessBuilder;
import cmblack.category.hardness.IHardnessBuilder;
import cmblack.category.specificgravity.ISpecificGravityBuilder;
import cmblack.category.specificgravity.SpecificGravityBuilder;
import cmblack.deck.deckbuilder.IParsedCard;

/**
 * Created by calebmacdonaldblack on 10/09/2016.
 */
public class StatsBuilder implements IStatsBuilder {

    private final ICleavageBuilder cleavageBuilder;
    private final ICrustalAbundanceBuilder crustalAbundanceBuilder;
    private final IEconomicValueBuilder economicValueBuilder;
    private final IHardnessBuilder hardnessBuilder;
    private final ISpecificGravityBuilder specificGravityBuilder;

    public StatsBuilder(
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

    public StatsBuilder(){
        this(
                new CleavageBuilder(),
                new CrustalAbundanceBuilder(),
                new EconomicValueBuilder(),
                new HardnessBuilder(),
                new SpecificGravityBuilder()
        );
    }

    @Override
    public IStats build(IParsedCard parsedCard) {
        return new Stats(
                this.cleavageBuilder.build(parsedCard.getCleavage()),
                this.crustalAbundanceBuilder.build(parsedCard.getCrustal_abundance()),
                this.economicValueBuilder.build(parsedCard.getEconomic_value()),
                this.hardnessBuilder.build(parsedCard.getHardness()),
                this.specificGravityBuilder.build(parsedCard.getSpecific_gravity())
        );
    }
}
