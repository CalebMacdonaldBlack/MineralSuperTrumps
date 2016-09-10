package cmblack.card.trumpcard;

import cmblack.card.CategoryComparisonResult;
import cmblack.card.stats.IStats;
import cmblack.category.Category;
import cmblack.category.cleavage.Cleavage;
import cmblack.category.cleavage.CleavageValue;
import cmblack.category.cleavage.ICleavage;
import cmblack.category.crustalabundance.CrustalAbundance;
import cmblack.category.crustalabundance.CrustalAbundanceValue;
import cmblack.category.crustalabundance.ICrustalAbundance;
import cmblack.category.economicvalue.EconomicValue;
import cmblack.category.economicvalue.EconomicValueValue;
import cmblack.category.economicvalue.IEconomicValue;
import cmblack.category.hardness.Hardness;
import cmblack.category.hardness.IHardness;
import cmblack.category.specificgravity.ISpecificGravity;
import cmblack.category.specificgravity.SpecificGravity;

/**
 * Created by calebmacdonaldblack on 10/09/2016.
 */
public class TrumpCardStats implements IStats {
    @Override
    public ICrustalAbundance getCrustalAbundance() {
        return new CrustalAbundance(CrustalAbundanceValue.TRUMPCARD);
    }

    @Override
    public IHardness getHardness() {
        return new Hardness(0,0);
    }

    @Override
    public IEconomicValue getEconomicValue() {
        return new EconomicValue(EconomicValueValue.TRUMPCARD);
    }

    @Override
    public ISpecificGravity getSpecificGravity() {
        return new SpecificGravity(0,0);
    }

    @Override
    public ICleavage getCleavage() {
        return new Cleavage(CleavageValue.TRUMPCARD);
    }

    @Override
    public boolean equals(IStats playCardStats) {
        return playCardStats.getCrustalAbundance().equals(this.getCrustalAbundance())
            && playCardStats.getHardness().equals(this.getHardness())
            && playCardStats.getEconomicValue().equals(this.getEconomicValue())
            && playCardStats.getSpecificGravity().equals(this.getSpecificGravity())
            && playCardStats.getCleavage().equals(this.getCleavage());
    }

    @Override
    public CategoryComparisonResult compareWith(IStats stats) {
        return null;
    }
}
