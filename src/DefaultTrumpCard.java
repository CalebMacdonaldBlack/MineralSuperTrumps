/**
 * Created by calebmacdonaldblack on 16/08/2016.
 */
public class DefaultTrumpCard extends DefaultCard implements TrumpCard {
    private TrumpCategory trumpCategory;

    public DefaultTrumpCard(String heading, String subHeading, TrumpCategory trumpCategory) {
        super(heading, subHeading);
        this.trumpCategory = trumpCategory;
    }

    @Override
    public TrumpCategory getTrumpCategory() {
        return this.trumpCategory;
    }
}
