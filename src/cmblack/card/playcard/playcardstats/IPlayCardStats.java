package cmblack.card.playcard.playcardstats;

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
 * Created by calebmacdonaldblack on 9/09/2016.
 */
public interface IPlayCardStats {
    ICrustalAbundance getCrustalAbundance();
    IHardness getHardness();
    IEconomicValue getEconomicValue();
    ISpecificGravity getSpecificGravity();
    ICleavage getCleavage();
    boolean equals(IPlayCardStats playCardStats);

    class FakePlayCardStats implements IPlayCardStats {

        @Override
        public ICrustalAbundance getCrustalAbundance() {
            return new ICrustalAbundance.FakeCrustalAbundance();
        }

        @Override
        public IHardness getHardness() {
            return new IHardness.FakeHardness();
        }

        @Override
        public IEconomicValue getEconomicValue() {
            return new IEconomicValue.FakeEconomicValue();
        }

        @Override
        public ISpecificGravity getSpecificGravity() {
            return new ISpecificGravity.FakeSpecificGravity();
        }

        @Override
        public ICleavage getCleavage() {
            return new ICleavage.FakeCleavage();
        }

        @Override
        public boolean equals(IPlayCardStats playCardStats) {
            return this.getCleavage().equals(playCardStats.getCleavage())
                && this.getSpecificGravity().equals(playCardStats.getSpecificGravity())
                && this.getEconomicValue().equals(playCardStats.getEconomicValue())
                && this.getHardness().equals(playCardStats.getHardness())
                && this.getCrustalAbundance().equals(playCardStats.getCrustalAbundance());
        }
    }
}
