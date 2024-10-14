package chapter5;

public class Numbers {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Invalid number of arguments. Must include 2 arguments");
            return;
        }

        String numberType = args[0];
        String numberLiteral = args[1];

        try {
            Class<?> NumberClass = Class.forName("java.lang." + numberType);

            if (!Number.class.isAssignableFrom(NumberClass)) {
                System.err.println(numberType + " is not a type of Number.");
                return;
            }

            java.lang.reflect.Constructor<?> constructor = NumberClass.getConstructor(String.class);

            Number number = (Number) constructor.newInstance(numberLiteral);

            System.out.println("Here is your number instance: " + number);
        } catch (Exception e) {
            System.err.println(e);
            return;
        }
    }
}
