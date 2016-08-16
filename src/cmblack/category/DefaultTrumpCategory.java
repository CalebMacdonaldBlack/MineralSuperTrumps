package cmblack.category;

/**
 * Created by calebmacdonaldblack on 16/08/2016.
 */
public class DefaultTrumpCategory implements TrumpCategory {
    private String name;

    public DefaultTrumpCategory(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
