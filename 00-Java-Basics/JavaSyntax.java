// JavaSyntax.java
// Basic Java syntax examples and practice

public class JavaSyntax {
    public static void main(String[] args) {
        // Print Hello World
        System.out.println("Hello, World!");

        // Variables
        int a = 10;
        double b = 20.5;
        char c = 'A';
        boolean isTrue = true;
        String name = "Sampada";

        // Output variables
        System.out.println("Integer: " + a);
        System.out.println("Double: " + b);
        System.out.println("Char: " + c);
        System.out.println("Boolean: " + isTrue);
        System.out.println("String: " + name);

        // Conditional Statement
        if (a > 5) {
            System.out.println("a is greater than 5");
        } else {
            System.out.println("a is 5 or less");
        }

        // Loops
        System.out.println("For loop:");
        for (int i = 0; i < 5; i++) {
            System.out.println("i = " + i);
        }

        System.out.println("While loop:");
        int count = 0;
        while (count < 5) {
            System.out.println("count = " + count);
            count++;
        }

        // Functions
        int sum = add(5, 10);
        System.out.println("Sum: " + sum);
    }

    // Function to add two numbers
    public static int add(int x, int y) {
        return x + y;
    }
}