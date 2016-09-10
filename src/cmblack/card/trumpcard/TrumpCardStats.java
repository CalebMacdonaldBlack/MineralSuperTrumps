package cmblack.card.trumpcard;

import cmblack.card.stats.IStats;
import cmblack.category.cleavage.ICleavage;
import cmblack.category.crustalabundance.ICrustalAbundance;
import cmblack.category.economicvalue.IEconomicValue;
import cmblack.category.hardness.IHardness;
import cmblack.category.specificgravity.ISpecificGravity;

/**
 * Created by calebmacdonaldblack on 10/09/2016.
 */
public class TrumpCardStats implements IStats {
    @Override
    public ICrustalAbundance getCrustalAbundance() {
        return null;
    }

    @Override
    public IHardness getHardness() {
        return null;
    }

    @Override
    public IEconomicValue getEconomicValue() {
        return null;
    }

    @Override
    public ISpecificGravity getSpecificGravity() {
        return null;
    }

    @Override
    public ICleavage getCleavage() {
        return null;
    }

    @Override
    public boolean equals(IStats playCardStats) {
        return false;
    }
}
