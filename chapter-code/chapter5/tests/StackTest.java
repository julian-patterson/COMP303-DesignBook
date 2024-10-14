package chapter5.tests;

import java.util.Stack;

import org.junit.Test;

public class StackTest {
    Stack<Integer> stack = new Stack<>();

    @Test
    public void testEmpty_Stack() {
        stack.pop();
    }
}
