package cmblack.card;

import java.util.Arrays;

/**
 * Created by calebmacdonaldblack on 9/09/2016.
 */
public interface ICardDescription {
    String getChemicalCompound();

    String getClassification();

    String getCrystalSystem();

    String[] getOccurrences();

    boolean equals(ICardDescription cardDescription);

    class FakeCardDescription implements ICardDescription
    {

        @Override
        public String getChemicalCompound() {
            return "Au";
        }

        @Override
        public String getClassification() {
            return "Native Element";
        }

        @Override
        public String getCrystalSystem() {
            return "isometric";
        }

        @Override
        public String[] getOccurrences() {
            return new String[]{"metamorphic", "sedimentry"};
        }

        @Override
        public boolean equals(ICardDescription cardDescription) {
            return cardDescription.getChemicalCompound().equals(this.getChemicalCompound())
                && cardDescription.getClassification().equals(this.getClassification())
                && cardDescription.getCrystalSystem().equals(this.getCrystalSystem())
                && Arrays.equals(cardDescription.getOccurrences(), this.getOccurrences());
        }
    }
}
