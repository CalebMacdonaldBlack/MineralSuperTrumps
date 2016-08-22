package cmblack.category;

/**
 * Created by calebmacdonaldblack on 22/08/2016.
 */
public class SpecificGravity extends Category {
    private CategoryValueRange range;

    public SpecificGravity(String name, CategoryValueRange range) {
        super(name);
        this.range = range;
    }

    public CategoryValueRange getRange() {
        return range;
    }
}
