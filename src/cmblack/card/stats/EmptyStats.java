package cmblack.card.stats;

import cmblack.category.CategoryComparisonResult;
import cmblack.category.cleavage.EmptyCleavage;
import cmblack.category.cleavage.ICleavage;
import cmblack.category.crustalabundance.EmptyCrustalAbundance;
import cmblack.category.crustalabundance.ICrustalAbundance;
import cmblack.category.economicvalue.EmptyEconomicValue;
import cmblack.category.economicvalue.IEconomicValue;
import cmblack.category.hardness.EmptyHardness;
import cmblack.category.hardness.IHardness;
import cmblack.category.specificgravity.EmptySpecificGravity;
import cmblack.category.specificgravity.ISpecificGravity;

/**
 * Created by calebmacdonaldblack on 10/09/2016.
 */
public class EmptyStats implements IStats {
    @Override
    public ICrustalAbundance getCrustalAbundance() {
        return new EmptyCrustalAbundance();
    }

    @Override
    public IHardness getHardness() {
        return new EmptyHardness();
    }

    @Override
    public IEconomicValue getEconomicValue() {
        return new EmptyEconomicValue();
    }

    @Override
    public ISpecificGravity getSpecificGravity() {
        return new EmptySpecificGravity();
    }

    @Override
    public ICleavage getCleavage() {
        return new EmptyCleavage();
    }

    @Override
    public boolean equals(IStats stats) {
        return new EmptyCleavage().equals(stats.getCleavage())
                && new EmptyCrustalAbundance().equals(stats.getCrustalAbundance())
                && new EmptyEconomicValue().equals(stats.getEconomicValue())
                && new EmptyHardness().equals(stats.getHardness())
                && new EmptySpecificGravity().equals(stats.getSpecificGravity());
    }

    @Override
    public CategoryComparisonResult compareWith(IStats stats) {
        return null;
    }
}
