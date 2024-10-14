package chapter5.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MinTest {
    @Test
    public void testTwo_Positives() {
        assertEquals(2, Math.min(5, 2));
    }

    @Test
    public void testTwo_Negatives() {
        assertEquals(-2, Math.min(-2, -1));
    }

    @Test
    public void testOne_Positive() {
        assertEquals(-2, Math.min(-2, 1));
    }

    @Test
    public void testSame_Positive() {
        assertEquals(1, Math.min(1, 1));
    }

    @Test
    public void testSame_Negative() {
        assertEquals(-1, Math.min(-1, -1));
    }

    @Test
    public void testTwo_Zeros() {
        assertEquals(0, Math.min(0, 0));
    }

    @Test
    public void testZero_And_Positive() {
        assertEquals(0, Math.min(0, 1));
    }

    @Test
    public void testZero_And_Negative() {
        assertEquals(-1, Math.min(0, -1));
    }
}
