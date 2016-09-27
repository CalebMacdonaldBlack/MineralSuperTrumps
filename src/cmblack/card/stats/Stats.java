package cmblack.card.stats;

import cmblack.category.CategoryComparisonResult;
import cmblack.category.cleavage.ICleavage;
import cmblack.category.crustalabundance.ICrustalAbundance;
import cmblack.category.economicvalue.IEconomicValue;
import cmblack.category.hardness.IHardness;
import cmblack.category.specificgravity.ISpecificGravity;

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
        double hardness = this.hardness.getMaximumValue() - stats.getHardness().getMaximumValue();
        hardness = Math.round(hardness * 100);
        hardness = hardness/100;

        double specificGravity = this.specificGravity.getMaximumValue() - stats.getSpecificGravity().getMaximumValue();
        specificGravity = Math.round(specificGravity * 100);
        specificGravity = specificGravity/100;

        return new CategoryComparisonResult(
                this.cleavage.getValue().compareTo(stats.getCleavage().getValue()),
                this.crustalAbundance.getValue().compareTo(stats.getCrustalAbundance().getValue()),
                this.economicValue.getValue().compareTo(stats.getEconomicValue().getValue()),
                hardness,
                specificGravity
        );
    }

    @Override
    public String toString() {
        return
            cleavage.toString() + "\n" +
            crustalAbundance.toString() + "\n" +
            economicValue.toString() + "\n" +
            hardness.toString() + "\n" +
            specificGravity.toString() + "\n";
    }
}
