/**
 * Created by calebmacdonaldblack on 16/08/2016.
 */
public class DefaultCard implements Card{
    private String heading;
    private String subHeading;

    public DefaultCard(String heading, String subHeading) {
        this.heading = heading;
        this.subHeading = subHeading;
    }

    public String getHeading() {
        return heading;
    }

    public String getSubHeading() {
        return subHeading;
    }
}
