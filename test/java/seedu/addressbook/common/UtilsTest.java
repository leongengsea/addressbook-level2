package seedu.addressbook.common;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class UtilsTest {


    @Test
    public void elementsAreUnique() throws Exception {
        // empty list
        assertAreUnique();

        // only one object
        assertAreUnique((Object) null);
        assertAreUnique(1);
        assertAreUnique("");
        assertAreUnique("abc");

        // all objects unique
        assertAreUnique("abc", "ab", "a");
        assertAreUnique(1, 2);

        // some identical objects
        assertNotUnique("abc", "abc");
        assertNotUnique("abc", "", "abc", "ABC");
        assertNotUnique("", "abc", "a", "abc");
        assertNotUnique(1, Integer.valueOf(1));
        assertNotUnique(null, 1, Integer.valueOf(1));
        assertNotUnique(null, null);
        assertNotUnique(null, "a", "b", null);
    }

    private void assertAreUnique(Object... objects) {
        assertTrue(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    private void assertNotUnique(Object... objects) {
        assertFalse(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    @Test
    public void isAnyNull() {
        //empty list
        assertFalse( false);

        //only one object
        assertTrue(null, true);
        assertFalse("1", false);
        assertFalse("",false);
        assertFalse("abc",false);

        //all null objects
        assertTrue(Utils.isAnyNull(null, null, null));

        //some null objects
        assertTrue(Utils.isAnyNull(null, null, 1));
        assertTrue(Utils.isAnyNull(null, null, "abc"));
        assertTrue(Utils.isAnyNull(null, null, " "));

        //all not null objects
        assertFalse(Utils.isAnyNull(1, "abc", " "));
    }
}
