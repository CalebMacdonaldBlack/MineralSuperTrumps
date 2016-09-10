package cmblack.card.stats;

import cmblack.card.CategoryComparisonResult;
import cmblack.category.IStat;
import cmblack.category.cleavage.ICleavage;
import cmblack.category.crustalabundance.ICrustalAbundance;
import cmblack.category.economicvalue.IEconomicValue;
import cmblack.category.hardness.IHardness;
import cmblack.category.specificgravity.ISpecificGravity;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by calebmacdonaldblack on 9/09/2016.
 */
public interface IStats {
    ICrustalAbundance getCrustalAbundance();
    IHardness getHardness();
    IEconomicValue getEconomicValue();
    ISpecificGravity getSpecificGravity();
    ICleavage getCleavage();
    boolean equals(IStats playCardStats);

    CategoryComparisonResult isBetterThan(IStats stats);

    class FakePlayCardStats implements IStats {

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
        public boolean equals(IStats playCardStats) {
            return this.getCleavage().equals(playCardStats.getCleavage())
                && this.getSpecificGravity().equals(playCardStats.getSpecificGravity())
                && this.getEconomicValue().equals(playCardStats.getEconomicValue())
                && this.getHardness().equals(playCardStats.getHardness())
                && this.getCrustalAbundance().equals(playCardStats.getCrustalAbundance());
        }

        @Override
        public CategoryComparisonResult isBetterThan(IStats stats) {
            return null;
        }
    }

    class FakePlayCardStats2 implements IStats {

        @Override
        public ICrustalAbundance getCrustalAbundance() {
            return new ICrustalAbundance.FakeCrustalAbundance2();
        }

        @Override
        public IHardness getHardness() {
            return new IHardness.FakeHardness2();
        }

        @Override
        public IEconomicValue getEconomicValue() {
            return new IEconomicValue.FakeEconomicValue2();
        }

        @Override
        public ISpecificGravity getSpecificGravity() {
            return new ISpecificGravity.FakeSpecificGravity2();
        }

        @Override
        public ICleavage getCleavage() {
            return new ICleavage.FakeCleavage2();
        }

        @Override
        public boolean equals(IStats playCardStats) {
            return this.getCleavage().equals(playCardStats.getCleavage())
                    && this.getSpecificGravity().equals(playCardStats.getSpecificGravity())
                    && this.getEconomicValue().equals(playCardStats.getEconomicValue())
                    && this.getHardness().equals(playCardStats.getHardness())
                    && this.getCrustalAbundance().equals(playCardStats.getCrustalAbundance());
        }

        @Override
        public CategoryComparisonResult isBetterThan(IStats stats) {
            throw new NotImplementedException();
        }
    }
}
