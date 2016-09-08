package cmblack.card;

/**
 * Created by calebmacdonaldblack on 9/09/2016.
 */
public interface ICardDescription {
    String getChemicalCompound();

    String getClassification();

    String getCrystalSystem();

    String[] getOccurrences();

    public class FakeCardDescription implements ICardDescription
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
    }
}
