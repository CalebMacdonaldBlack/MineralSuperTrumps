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

    CategoryComparisonResult compareWith(IStats stats);

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
        public CategoryComparisonResult compareWith(IStats stats) {
            double hardness = new IHardness.FakeHardness().getMaximumValue() - stats.getHardness().getMaximumValue();
            hardness = Math.round(hardness * 100);
            hardness = hardness/100;

            double specificGravity = new ISpecificGravity.FakeSpecificGravity().getMaximumValue() - stats.getSpecificGravity().getMaximumValue();
            specificGravity = Math.round(specificGravity * 100);
            specificGravity = specificGravity/100;

            return new CategoryComparisonResult(
                    new ICleavage.FakeCleavage().getValue().compareTo(stats.getCleavage().getValue()),
                    new ICrustalAbundance.FakeCrustalAbundance().getValue().compareTo(stats.getCrustalAbundance().getValue()),
                    new IEconomicValue.FakeEconomicValue().getValue().compareTo(stats.getEconomicValue().getValue()),
                    hardness,
                    specificGravity
            );
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
        public boolean equals(IStats stats) {
            return this.getCleavage().equals(stats.getCleavage())
                    && this.getSpecificGravity().equals(stats.getSpecificGravity())
                    && this.getEconomicValue().equals(stats.getEconomicValue())
                    && this.getHardness().equals(stats.getHardness())
                    && this.getCrustalAbundance().equals(stats.getCrustalAbundance());
        }

        @Override
        public CategoryComparisonResult compareWith(IStats stats) {
            double hardness = new IHardness.FakeHardness2().getMaximumValue() - stats.getHardness().getMaximumValue();
            hardness = Math.round(hardness * 100);
            hardness = hardness/100;

            double specificGravity = new ISpecificGravity.FakeSpecificGravity2().getMaximumValue() - stats.getSpecificGravity().getMaximumValue();
            specificGravity = Math.round(specificGravity * 100);
            specificGravity = specificGravity/100;

            return new CategoryComparisonResult(
                    new ICleavage.FakeCleavage2().getValue().compareTo(stats.getCleavage().getValue()),
                    new ICrustalAbundance.FakeCrustalAbundance2().getValue().compareTo(stats.getCrustalAbundance().getValue()),
                    new IEconomicValue.FakeEconomicValue2().getValue().compareTo(stats.getEconomicValue().getValue()),
                    hardness,
                    specificGravity
            );
        }
    }
}
