/**
 * Created by calebmacdonaldblack on 16/08/2016.
 */
public class DefaultTrumpCard extends DefaultCard implements TrumpCard {
    public DefaultTrumpCard(String heading, String subHeading, TrumpCategory trumpCategory) {
        super(heading, subHeading);
    }

    @Override
    public TrumpCategory getTrumpCategory() {
        return null;
    }
}
