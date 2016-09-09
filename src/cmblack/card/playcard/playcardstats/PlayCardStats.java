package cmblack.card.playcard.playcardstats;

import cmblack.category.*;
import cmblack.category.cleavage.Cleavage;
import cmblack.category.cleavage.ICleavage;
import cmblack.category.crustalabundance.CrustalAbundance;
import cmblack.category.crustalabundance.ICrustalAbundance;
import cmblack.category.economicvalue.EconomicValue;
import cmblack.category.economicvalue.IEconomicValue;
import cmblack.category.hardness.Hardness;
import cmblack.category.hardness.IHardness;
import cmblack.category.specificgravity.ISpecificGravity;
import cmblack.category.specificgravity.SpecificGravity;

/**
 * Created by calebmacdonaldblack on 23/08/2016.
 */
public class PlayCardStats implements IPlayCardStats{
    private final ICleavage cleavage;
    private final ICrustalAbundance crustalAbundance;
    private final IEconomicValue economicValue;
    private final IHardness hardness;
    private final ISpecificGravity specificGravity;

    public PlayCardStats(ICleavage cleavage, ICrustalAbundance crustalAbundance, IEconomicValue economicValue, IHardness hardness, ISpecificGravity specificGravity) {
        this.cleavage = cleavage;
        this.crustalAbundance = crustalAbundance;
        this.economicValue = economicValue;
        this.hardness = hardness;
        this.specificGravity = specificGravity;
    }

    @Override
    public ICleavage getCleavage() {
        return this.cleavage;
    }

    @Override
    public boolean equals(IPlayCardStats playCardStats) {
        return this.cleavage.equals(playCardStats.getCleavage())
            && this.crustalAbundance.equals(playCardStats.getCrustalAbundance())
            && this.economicValue.equals(playCardStats.getEconomicValue())
            && this.hardness.equals(playCardStats.getHardness())
            && this.specificGravity.equals(playCardStats.getHardness());
    }

    @Override
    public ICrustalAbundance getCrustalAbundance() {
        return this.crustalAbundance;
    }

    @Override
    public IEconomicValue getEconomicValue() {
        return this.economicValue;
    }

    @Override
    public IHardness getHardness() {
        return this.hardness;
    }

    @Override
    public ISpecificGravity getSpecificGravity() {
        return this.specificGravity;
    }
}
