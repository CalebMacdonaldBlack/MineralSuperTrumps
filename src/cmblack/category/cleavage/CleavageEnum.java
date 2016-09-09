package cmblack.category.cleavage;

import cmblack.category.cleavage.Cleavage;
import cmblack.category.cleavage.ICleavage;

/**
 * Created by calebmacdonaldblack on 9/09/2016.
 */
public enum CleavageEnum {
    NONE(new Cleavage(0, "none")),
    POOR_NONE(new Cleavage(1, "poor/none")),
    POOR1(new Cleavage(2, "1 poor")),
    POOR2(new Cleavage(3, "2 poor")),
    GOOD1(new Cleavage(4, "1 good")),
    GOOD1_POOR1(new Cleavage(5, "1 good, 1 poor")),
    GOOD2(new Cleavage(5, "2 good")),
    GOOD3(new Cleavage(6, "3 good")),
    PERFECT1(new Cleavage(7, "1 perfect")),
    PERFECT1_GOOD1(new Cleavage(8, "1 perfect, 1 good")),
    PERFECT1_GOOD2(new Cleavage(9, "1 perfect, 2 good")),
    PERFECT2_GOOD1(new Cleavage(10, "2 perfect, 1 good")),
    PERFECT3(new Cleavage(11, "3 perfect")),
    PERFECT4(new Cleavage(12, "4 perfect")),
    PERFECT6(new Cleavage(13, "6 perfect"));

    private final Cleavage cleavage;

    CleavageEnum(Cleavage cleavage) {
        this.cleavage = cleavage;
    }

    public Cleavage getCleavage() {
        return cleavage;
    }

    public boolean equals(ICleavage cleavage) {
        return this.cleavage.equals(cleavage);
    }
}
