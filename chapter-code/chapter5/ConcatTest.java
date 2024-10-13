package chapter5;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

public class ConcatTest {

    @Test
    public void testEmpty_String() {
        assertEquals("", "".concat(""));
    }

    @Test
    public void testFull_and_Empty_String() {
        assertEquals("test", "test".concat(""));
    }

    @Test
    public void testEmpty_and_Full_String() {
        assertEquals("test", "".concat("test"));
    }

    @Test
    public void testFull_String() {
        assertEquals("testandtest", "test".concat("andtest"));
    }

    @Test
    public void testNull_String() {
        assertThrows(NullPointerException.class, () -> "".concat(null));
    }

    @Test
    public void testWhitespace_Characters() {
        assertEquals("test test", "test ".concat("test"));
    }
}
