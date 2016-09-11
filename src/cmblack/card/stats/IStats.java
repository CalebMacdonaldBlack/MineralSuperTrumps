package cmblack.card.stats;

import cmblack.card.CategoryComparisonResult;
import cmblack.category.cleavage.ICleavage;
import cmblack.category.crustalabundance.ICrustalAbundance;
import cmblack.category.economicvalue.IEconomicValue;
import cmblack.category.hardness.IHardness;
import cmblack.category.specificgravity.ISpecificGravity;

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
            return new ICrustalAbundance.FakeGoodCrustalAbundance();
        }

        @Override
        public IHardness getHardness() {
            return new IHardness.FakeHardness();
        }

        @Override
        public IEconomicValue getEconomicValue() {
            return new IEconomicValue.FakeGoodEconomicValue();
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
                    new ICrustalAbundance.FakeGoodCrustalAbundance().getValue().compareTo(stats.getCrustalAbundance().getValue()),
                    new IEconomicValue.FakeGoodEconomicValue().getValue().compareTo(stats.getEconomicValue().getValue()),
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
            return new IHardness.FakeGoodHardness();
        }

        @Override
        public IEconomicValue getEconomicValue() {
            return new IEconomicValue.FakeEconomicValue2();
        }

        @Override
        public ISpecificGravity getSpecificGravity() {
            return new ISpecificGravity.FakeGoodSpecificGravity();
        }

        @Override
        public ICleavage getCleavage() {
            return new ICleavage.FakeGoodCleavage();
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
            double hardness = new IHardness.FakeGoodHardness().getMaximumValue() - stats.getHardness().getMaximumValue();
            hardness = Math.round(hardness * 100);
            hardness = hardness/100;

            double specificGravity = new ISpecificGravity.FakeGoodSpecificGravity().getMaximumValue() - stats.getSpecificGravity().getMaximumValue();
            specificGravity = Math.round(specificGravity * 100);
            specificGravity = specificGravity/100;

            return new CategoryComparisonResult(
                    new ICleavage.FakeGoodCleavage().getValue().compareTo(stats.getCleavage().getValue()),
                    new ICrustalAbundance.FakeCrustalAbundance2().getValue().compareTo(stats.getCrustalAbundance().getValue()),
                    new IEconomicValue.FakeEconomicValue2().getValue().compareTo(stats.getEconomicValue().getValue()),
                    hardness,
                    specificGravity
            );
        }
    }

    class FakeBadPlayCardStats implements IStats {

        @Override
        public ICrustalAbundance getCrustalAbundance() {
            return new ICrustalAbundance.FakeBadCrustalAbundance();
        }

        @Override
        public IHardness getHardness() {
            return new IHardness.FakeBadHardness();
        }

        @Override
        public IEconomicValue getEconomicValue() {
            return new IEconomicValue.FakeBadEconomicValue();
        }

        @Override
        public ISpecificGravity getSpecificGravity() {
            return new ISpecificGravity.FakeBadSpecificGravity();
        }

        @Override
        public ICleavage getCleavage() {
            return new ICleavage.FakeBadCleavage();
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
            double hardness = new IHardness.FakeBadHardness().getMaximumValue() - stats.getHardness().getMaximumValue();
            hardness = Math.round(hardness * 100);
            hardness = hardness/100;

            double specificGravity = new ISpecificGravity.FakeBadSpecificGravity().getMaximumValue() - stats.getSpecificGravity().getMaximumValue();
            specificGravity = Math.round(specificGravity * 100);
            specificGravity = specificGravity/100;

            return new CategoryComparisonResult(
                    new ICleavage.FakeBadCleavage().getValue().compareTo(stats.getCleavage().getValue()),
                    new ICrustalAbundance.FakeBadCrustalAbundance().getValue().compareTo(stats.getCrustalAbundance().getValue()),
                    new IEconomicValue.FakeBadEconomicValue().getValue().compareTo(stats.getEconomicValue().getValue()),
                    hardness,
                    specificGravity
            );
        }
    }

    class FakeGoodPlayCardStats implements IStats {

        @Override
        public ICrustalAbundance getCrustalAbundance() {
            return new ICrustalAbundance.FakeGoodCrustalAbundance();
        }

        @Override
        public IHardness getHardness() {
            return new IHardness.FakeGoodHardness();
        }

        @Override
        public IEconomicValue getEconomicValue() {
            return new IEconomicValue.FakeGoodEconomicValue();
        }

        @Override
        public ISpecificGravity getSpecificGravity() {
            return new ISpecificGravity.FakeGoodSpecificGravity();
        }

        @Override
        public ICleavage getCleavage() {
            return new ICleavage.FakeGoodCleavage();
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
            double hardness = this.getHardness().getMaximumValue() - stats.getHardness().getMaximumValue();
            hardness = Math.round(hardness * 100);
            hardness = hardness/100;

            double specificGravity = this.getSpecificGravity().getMaximumValue() - stats.getSpecificGravity().getMaximumValue();
            specificGravity = Math.round(specificGravity * 100);
            specificGravity = specificGravity/100;

            return new CategoryComparisonResult(
                    this.getCleavage().getValue().compareTo(stats.getCleavage().getValue()),
                    this.getCrustalAbundance().getValue().compareTo(stats.getCrustalAbundance().getValue()),
                    this.getEconomicValue().getValue().compareTo(stats.getEconomicValue().getValue()),
                    hardness,
                    specificGravity
            );
        }
    }
}
