package cmblack.deck.deckbuilder;

/**
 * Created by calebmacdonaldblack on 10/09/2016.
 */
public interface IParsedCard {
    String getFileName();

    String getTitle();

    String getChemistry();

    String getClassification();

    String getCrystal_system();

    String getHardness();

    String getSpecific_gravity();

    String getCleavage();

    String getCrustal_abundance();

    String getEconomic_value();

    String[] getOccurrence();

    String getSubTitle();

    String[] getCategories();

    class FakeParsedCard implements IParsedCard {

        @Override
        public String getFileName() {
                return "slide45.jpg";
        }

        @Override
        public String getTitle() {
            return "Gold";
        }

        @Override
        public String getChemistry() {
            return "Au";
        }

        @Override
        public String getClassification() {
            return "native element";
        }

        @Override
        public String getCrystal_system() {
            return "isometric";
        }

        @Override
        public String getHardness() {
            return "5-5.5";
        }

        @Override
        public String getSpecific_gravity() {
            return "5-5.5";
        }

        @Override
        public String getCleavage() {
            return "3 good";
        }

        @Override
        public String getCrustal_abundance() {
            return "low";
        }

        @Override
        public String getEconomic_value() {
            return "low";
        }

        @Override
        public String[] getOccurrence() {
            return new String[]{
                    "metamorphic",
                    "sedimentary"
            };
        }

        @Override
        public String getSubTitle() {
            return null;
        }

        @Override
        public String[] getCategories() {
            return null;
        }
    }

    class FakeParsedCard2 implements IParsedCard {

        @Override
        public String getFileName() {
            return "slide59.jpg";
        }

        @Override
        public String getTitle() {
            return "The Geophysist";
        }

        @Override
        public String getChemistry() {
            return null;
        }

        @Override
        public String getClassification() {
            return null;
        }

        @Override
        public String getCrystal_system() {
            return null;
        }

        @Override
        public String getHardness() {
            return null;
        }

        @Override
        public String getSpecific_gravity() {
            return null;
        }

        @Override
        public String getCleavage() {
            return null;
        }

        @Override
        public String getCrustal_abundance() {
            return null;
        }

        @Override
        public String getEconomic_value() {
            return null;
        }

        @Override
        public String[] getOccurrence() {
            return null;
        }

        @Override
        public String getSubTitle() {
            return "Changed the trump category to Specific gravity";
        }

        @Override
        public String[] getCategories() {
            return new String[]{"Specific gravity"};
        }
    }
}
