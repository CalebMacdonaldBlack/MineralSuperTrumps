package cmblack.card.stats;

import cmblack.card.CategoryComparisonResult;
import cmblack.category.cleavage.ICleavage;
import cmblack.category.crustalabundance.ICrustalAbundance;
import cmblack.category.economicvalue.IEconomicValue;
import cmblack.category.hardness.IHardness;
import cmblack.category.specificgravity.ISpecificGravity;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by calebmacdonaldblack on 23/08/2016.
 */
public class Stats implements IStats {
    private final ICleavage cleavage;
    private final ICrustalAbundance crustalAbundance;
    private final IEconomicValue economicValue;
    private final IHardness hardness;
    private final ISpecificGravity specificGravity;

    public Stats(ICleavage cleavage, ICrustalAbundance crustalAbundance, IEconomicValue economicValue, IHardness hardness, ISpecificGravity specificGravity) {
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

    @Override
    public boolean equals(IStats playCardStats) {

        return this.cleavage.equals(playCardStats.getCleavage())
                && this.crustalAbundance.equals(playCardStats.getCrustalAbundance())
                && this.economicValue.equals(playCardStats.getEconomicValue())
                && this.hardness.equals(playCardStats.getHardness())
                && this.specificGravity.equals(playCardStats.getSpecificGravity());
    }

    @Override
    public CategoryComparisonResult compareWith(IStats stats) {
        return new CategoryComparisonResult(
                stats.getCleavage().getValue().compareTo(this.cleavage.getValue()),
                stats.getCrustalAbundance().getValue().compareTo(this.crustalAbundance.getValue()),
                stats.getEconomicValue().getValue().compareTo(this.economicValue.getValue()),
                this.hardness.getMaximumValue() - stats.getHardness().getMaximumValue(),
                this.specificGravity.getMaximumValue() - stats.getSpecificGravity().getMaximumValue()
        );
    }
}
