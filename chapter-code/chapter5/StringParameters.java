package chapter5;

import java.lang.reflect.Method;

public class StringParameters {

    public void invokeStringMethods() {
        Method[] methods = String.class.getDeclaredMethods();

        for (Method method : methods) {
            String emptyString = "";
            if (method.getParameterCount() == 1) {
                method.setAccessible(true);
                try {
                    Object result = method.invoke(emptyString);
                    System.out.println("Method: " + method.getName() + " - Result: " + result);
                } catch (Exception e) {
                    System.err.println("Method: " + method.getName() + " - Exception: " + e);
                }
            }
        }
    }
}
