package chapter5.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.util.EmptyStackException;
import java.util.Stack;

import org.junit.Before;
import org.junit.Test;

public class StackTest {
    Stack<Integer> stack;

    @Before
    public void setUp() {
        stack = new Stack<>();
    }

    @Test
    public void testEmpty_Stack_Pop() {
        assertThrows(EmptyStackException.class, () -> stack.pop());
    }

    @Test
    public void testEmpty_Stack_Peek() {
        assertThrows(EmptyStackException.class, () -> stack.peek());
    }

    @Test
    public void testFull_Stack_Pop() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        int expectedValue = stack.pop();
        assertEquals(3, expectedValue);
    }

    @Test
    public void testFull_Stack_Peek() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        int expectedValue = stack.peek();
        assertEquals(3, expectedValue);
    }

    @Test
    public void testOrder() {
        stack.push(1);
        stack.push(2);
        stack.push(3);

        for (int i = 3; i < 0; i--) {
            int expectedValue = stack.pop();
            assertEquals(i, expectedValue);
        }
    }

    @Test
    public void testIs_Empty() {
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testIs_Empty_False() {
        stack.push(1);
        assertFalse(stack.isEmpty());
    }

    @Test
    public void testSearch_Stack() {
        stack.push(1);
        stack.push(2);
        stack.push(3);

        int index = stack.search(1);
        assertEquals(2, index);
    }

    @Test
    public void testPush_Multiple_Elements() {
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(3, stack.size());
    }

    @Test
    public void testSize() {

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(6, stack.size());
    }

    @Test
    public void testClear_Stack() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.clear();

        assertTrue(stack.isEmpty());
    }
}
