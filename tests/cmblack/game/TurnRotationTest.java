package cmblack.game;


import cmblack.category.Category;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 5/09/2016.
 */
public class TurnRotationTest {

    @Test
    public void testPlayerSelectsCategory(){
        TurnRotation turnRotation = new TurnRotation(Category.Categories.HARDNESS.getName());
        turnRotation.findCategory();
    }

}